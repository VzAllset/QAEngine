package com.vzw.prepaid.comparators;

import java.util.Comparator;
import com.vzw.prepaid.dao.generated.QaTestSuiteTestCaseMap;

public class TestCaseComparator implements Comparator<QaTestSuiteTestCaseMap>
{
	@Override
	public int compare(QaTestSuiteTestCaseMap case1, QaTestSuiteTestCaseMap case2) {
		return case1.getExecSequence().compareTo(case2.getExecSequence());
	}
}
