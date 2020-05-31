package com.techland.paypay.intregration.helper;

public final class Settings {
	
	final static int NUMBER_OF_THREADS = 100;
	public final static int THREAD_LOCK_TIMEOUT = 8;
	public static boolean MOCK;
	public final static int ASYNC_WAIT_TIME = 2;
	public final static int ASYNC_NUMBER_OF_TRIES= 2;
	public final static String DOMAIN  = "User";
	public final static int CHECKPOINT_LIMIT = 8;
	//public final static Duration CASSANDRA_WAIT_TIME = ;
	public static final String HASH = "SHA-512";
	public final static int SELF_HEAL_RUN_TIME = 2000000;
	
	public  static void setTest()
	{
		MOCK = true;
		System.out.println("Set to test mode");
	}

	public  static void setProd()
	{
		MOCK = false;
		System.out.println("Set to live mode");
	}
	
	private static long lastTime;
	
	public static synchronized String aggregateTag()
	{
		for (;/*ever*/;) {
			final long n = System.nanoTime();
			if (n==lastTime) continue;
			lastTime = n;
			return ""+System.currentTimeMillis()+n;
		}
	}
}
