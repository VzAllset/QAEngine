package com.vzw.prepaid.comparators;

import java.util.Comparator;
import com.vzw.prepaid.beans.TestResult;

public class FlowTestResultComparator implements Comparator<TestResult>
{
	@Override
	public int compare(TestResult result1, TestResult result2) 
	{
		return Integer.valueOf(result1.getExecSequence()).compareTo(Integer.valueOf(result2.getExecSequence()));
	}
}
