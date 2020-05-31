package com.techland.paypay.intregration.events;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.Immutable;

import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandEvent;
import com.techland.paypay.intregration.helper.Settings;

@Immutable
@TechLandEvent(externalName = "Customer.AccountAddedEvent")
public class AccountAddedEvent implements PayPayEvent, Serializable {

	private static final long serialVersionUID = 1L;
	private final String id;
	private final String accoiuntId;
	private final String expiryMonth;
	private final String expiryYear;
	private final String cardBin;
	private final String lastDigits;
	private final String brand;
	private final String accountToken;
	private final Timestamp timestamp;
	private final String eventId;

	
	public AccountAddedEvent(String id, String accoiuntId, String expiryMonth, String expiryYear, String cardBin,
			String lastDigits, String brand, String accountToken, Timestamp timestamp,
			String eventId) {
		this.id = id;
		this.accoiuntId = accoiuntId;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cardBin = cardBin;
		this.lastDigits = lastDigits;
		this.brand = brand;
		this.accountToken = accountToken;
		this.timestamp = timestamp;
		this.eventId = eventId;
	}

	@Override
	public String getId() {
		return id;
	}

	

	public String getAccoiuntId() {
		return accoiuntId;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public String getCardBin() {
		return cardBin;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public String getBrand() {
		return brand;
	}

	public String getAccountToken() {
		return accountToken;
	}

	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public String getEventId() {
		return eventId;
	}

	@Override
	public String getObiquitusName() {
		return Settings.DOMAIN + "." + this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return "{\"class\":\"AccountAddedEvent\",\"id\":\"" + id + "\", \"accoiuntId\":\"" + accoiuntId
				+ "\", \"expiryMonth\":\"" + expiryMonth + "\", \"expiryYear\":\"" + expiryYear + "\", \"cardBin\":\""
				+ cardBin + "\", \"lastDigits\":\"" + lastDigits + "\", \"brand\":\"" + brand
				+ "\", \"accountToken\":\"" + accountToken + "\", \"timestamp\":\"" + timestamp + "\", \"eventId\":\""
				+ eventId + "\"}";
	}

	

}
