package com.techland.paypay.intregration.contracts;

public interface Messenger {
	
	void sendMessage(final String message ,final String to,final String from,final String subject);

}
