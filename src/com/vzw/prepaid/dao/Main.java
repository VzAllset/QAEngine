package com.vzw.prepaid.dao;

import com.vzw.prepaid.dao.generated.QaTestCase;
import com.vzw.prepaid.dao.generated.QaTestCaseHome;

public class Main 
{
	public static void main(String args[])
	{
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		QaTestCaseHome testCaseHome = new QaTestCaseHome();
		QaTestCase testCase = testCaseHome.findById(5);
		System.out.println(testCase);
		System.out.println(testCase.getTestCaseDesc());
		System.out.println(testCase.getQaTestCaseFlowMaps().size());
		//HibernateUtil.shutdown();
	}
}
