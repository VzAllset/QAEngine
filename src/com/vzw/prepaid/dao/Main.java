package com.vzw.prepaid.dao;

import com.vzw.prepaid.dao.generated.QaTestSuite;
import com.vzw.prepaid.dao.generated.QaTestSuiteHome;

public class Main 
{
	public static void main(String args[])
	{
		QaTestSuiteHome suite = new QaTestSuiteHome();
		QaTestSuite suites = suite.findById(5);
		System.out.println("Barath ::::"+suites.toString());
	}
}
