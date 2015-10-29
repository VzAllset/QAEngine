package com.vzw.prepaid.factory;

import com.vzw.prepaid.configuration.GenerateTestObject;
import com.vzw.prepaid.request.DatabaseRequest;

public class RequestFactory {
	public static GenerateTestObject getRequest(String requestType)
	{
		if(requestType.equals("DB"))
		{
			return new DatabaseRequest();
		}
		return null;
	}
}
