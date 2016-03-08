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
		// Serial processing with one flow -  FlipKart Login
		//HashMap<String,Object> result = initiator.initiate("1");
		
		/*Serial processing with more than one flow -  Amazon Login & Checkout */
		//HashMap<String,Object> result = initiator.initiate("5");
		
		/*Parallel processing each having different flows -  Flipkart Login + Amazon Login & Checkout */
		//HashMap<String,Object> result = initiator.initiate("1,5");
		
		/* Tester can configure test if a flow is successful or not ?? - Flipkart login validated */
		//HashMap<String,Object> result = initiator.initiate("3");
		
		/* Result generated from one flow can be fed as an input to another flow - JIRA create defect and use id generated to search in search flow */
		HashMap<String,Object> result = initiator.initiate("4");
		
		/* Compatible with browsers IE & Firefox for now :P */

		//Verizon
		//HashMap<String,Object> result = initiator.initiate("6");
		
		
		//HashMap<String,Object> result = initiator.initiate("1");
		
		System.out.println(result.toString());
	}
}
