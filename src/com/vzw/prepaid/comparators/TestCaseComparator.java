package com.vzw.prepaid.comparators;

import java.util.Comparator;
import com.vzw.prepaid.beans.TestCase;

public class TestCaseComparator implements Comparator<TestCase>
{
	@Override
	public int compare(TestCase case1, TestCase case2) {
		return Integer.valueOf(case1.getExecutionSequence()).compareTo(Integer.valueOf(case2.getExecutionSequence()));
	}
}
