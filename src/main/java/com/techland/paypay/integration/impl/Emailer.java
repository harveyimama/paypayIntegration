package com.techland.paypay.integration.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.techland.paypay.intregration.contracts.Messenger;
@Component
public class Emailer implements Messenger {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMessage(String message, String to, String from, String subject) {

		try {

			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(to);

			helper.setSubject(subject);
			helper.setText(message);

			javaMailSender.send(msg);

		} catch (MailException | MessagingException e) {
			e.printStackTrace();
		}

	}

}
