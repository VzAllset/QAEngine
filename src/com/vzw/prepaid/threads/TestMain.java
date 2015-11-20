package com.vzw.prepaid.threads;

import java.util.HashMap;

public class TestMain 
{
	public static void main(String args[])
	{
		/* Following lines to disable selenium webdriver logging */
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
		/* ends */
		ThreadInitiator initiator= new ThreadInitiator();
		HashMap<String,Object> result = initiator.initiate("4");
		System.out.println(result.toString());
	}
}
