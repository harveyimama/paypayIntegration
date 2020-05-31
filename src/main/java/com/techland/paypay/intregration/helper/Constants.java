package com.techland.paypay.intregration.helper;

public final class Constants {

	public static final String IN = "payload-in";
	public static final String OUT = "payload-out";
	
	
	public static final String SOURCE_ERROR = "Event Store failed to persist event";
	public static final String SERVER_ERROR = "Server Error Occured";
	public static final int SERVER_ERROR_CODE = 10;
	public static final int SUCESS_CODE = 0;
	public static final String SUCESS_MESSAGE= "User Operation successful :-)";
	public static final String ENCRYPT_ERROR = "Could not dencrypt password";
	public static final String DUPLICATE_MESSAGE= "User already exists :-)";
	public static final int DUPLICATE_CODE= 12;
	public static final String NOTFOUND_MESSAGE= "User Not Found";
	public static final int NOTFOUND_CODE= 13;
}
