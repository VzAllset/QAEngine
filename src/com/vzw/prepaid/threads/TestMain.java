package com.vzw.prepaid.threads;

import java.util.HashMap;

public class TestMain 
{
	public static void main(String args[])
	{
		ThreadInitiator initiator= new ThreadInitiator();
		HashMap<String,Object> result = initiator.initiate("1,2");
		System.out.println(result.toString());
	}
}