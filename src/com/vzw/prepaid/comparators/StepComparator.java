package com.vzw.prepaid.comparators;

import java.util.Comparator;
import com.vzw.prepaid.dao.generated.QaFlowStepMap;

public class StepComparator implements Comparator<QaFlowStepMap>
{
	@Override
	public int compare(QaFlowStepMap map1, QaFlowStepMap map2) {
		// TODO Auto-generated method stub
		return map1.getExecSequence().compareTo(map2.getExecSequence());
	}
}
