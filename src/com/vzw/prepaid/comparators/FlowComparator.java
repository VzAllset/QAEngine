package com.vzw.prepaid.comparators;

import java.util.Comparator;

import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.dao.generated.QaTestCaseFlowMap;

public class FlowComparator implements Comparator<QaTestCaseFlowMap>
{
	@Override
	public int compare(QaTestCaseFlowMap map1, QaTestCaseFlowMap map2) {
		return Long.valueOf(map1.getExecSequence()).compareTo(Long.valueOf(map2.getExecSequence()));
	}
}
