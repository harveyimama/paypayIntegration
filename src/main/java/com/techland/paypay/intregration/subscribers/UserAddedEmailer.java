package com.techland.paypay.intregration.subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techland.paypay.contracts.EventSubscriber;
import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandSubscriber;
import com.techland.paypay.integration.impl.Emailer;
import com.techland.paypay.intregration.events.AdminUserAddedEvent;
import com.techland.paypay.intregration.events.CustomerUserAddedEvent;
import com.techland.paypay.intregration.events.MerchantUserAddedEvent;
import com.techland.paypay.intregration.helper.Email;
import com.techland.paypay.intregration.helper.Settings;
import com.techland.paypay.persistence.EventFailure;
import com.techland.paypay.persistence.EventFailureRepository;

@Component
@TechLandSubscriber(events = { "MerchantUserAddedEvent","CustomerUserAddedEvent","AdminUserAddedEvent" }, isstate = false)
public final class UserAddedEmailer implements EventSubscriber {

	@Autowired
	private EventFailure failure;
	@Autowired
	private EventFailureRepository failureRepo;
	@Autowired
	private Emailer emailer;

	@Override
	public boolean isState() {
		return false;
	}

	@Override
	public <T extends PayPayEvent> boolean process(final T userEvent) {
		boolean ret = false;
		try {
			if (userEvent instanceof MerchantUserAddedEvent) {
				sendVericiationEmail(((MerchantUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 false, userEvent.getObiquitusName());
			}
			else if (userEvent instanceof CustomerUserAddedEvent) {
				sendVericiationEmail(((CustomerUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 false, userEvent.getObiquitusName());
			}
			
			else if (userEvent instanceof AdminUserAddedEvent) {
				sendVericiationEmail(((AdminUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 false, userEvent.getObiquitusName());
			}
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public <T extends PayPayEvent> boolean reProcess(final T userEvent) {
		boolean ret = false;
		try {
			if (userEvent instanceof MerchantUserAddedEvent) {
				sendVericiationEmail(((MerchantUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 true, userEvent.getObiquitusName());
			}
			else if (userEvent instanceof CustomerUserAddedEvent) {
				sendVericiationEmail(((CustomerUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 true, userEvent.getObiquitusName());
			}
			
			else if (userEvent instanceof AdminUserAddedEvent) {
				sendVericiationEmail(((AdminUserAddedEvent) userEvent).getEmail(), userEvent.getId(), userEvent.toString(),
						 true, userEvent.getObiquitusName());
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	private boolean sendVericiationEmail(final String email, final String id, final String userEventString,
			 boolean isReprocess, String name) {

		System.out.print("Sending veirifcation Email");

		try {
			emailer.sendMessage(Email.WELCOME_EMAIL, email, Email.WELCOME_SENDER, Email.WELCOME_SUBJECT);
			return true;

		} catch (Exception e) {
			// e.printStackTrace();
			if (!isReprocess)
				handleError(userEventString, failure, failureRepo, name);
			return false;
		}

	}

	@Override
	public void handleError(final String userEvent, final EventFailure failure,
			final EventFailureRepository failureRepo, String name) {
		failure.setFailureEvent(userEvent);
		failure.setEventSubscriber(this.getClass().getSimpleName());
		failure.setEventFailureId(Settings.aggregateTag());
		failure.setFailureName(name);
		failureRepo.save(failure);
	}

}
