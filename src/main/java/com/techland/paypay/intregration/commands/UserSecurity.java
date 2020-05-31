package com.techland.paypay.intregration.commands;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.techland.paypay.intregration.helper.Constants;
import com.techland.paypay.intregration.helper.Settings;
import com.techland.paypay.util.LogFeed;


public final class UserSecurity {
	
	
	static String encrypt(final String val)
	{
        StringBuilder sb = new StringBuilder();
        
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance(Settings.HASH);
            byte[] bs;
            bs = messageDigest.digest(val.getBytes());
            for(int i = 0; i < bs.length; i++)
            {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if(hexVal.length() == 1) 
                {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        }
        catch (NoSuchAlgorithmException ex) 
        {
        	LogFeed logfeed = new LogFeed.LogProcessor()  
					.setInfo(Constants.ENCRYPT_ERROR)
					.setClazz(UserSecurity.class)
					.setDomain(Settings.DOMAIN)
					.setOtherInfo(ex.getMessage())
					.build(); 
			logfeed.process();
        	
        }
        return sb.toString();
    }
	

}
