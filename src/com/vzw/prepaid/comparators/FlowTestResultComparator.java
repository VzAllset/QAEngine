package com.vzw.prepaid.comparators;

import java.util.Comparator;
import com.vzw.prepaid.dao.generated.QaFlowTestMap;

public class FlowTestResultComparator implements Comparator<QaFlowTestMap>
{
	@Override
	public int compare(QaFlowTestMap map1, QaFlowTestMap map2) {
		return map1.getExecSequence().compareTo(map2.getExecSequence());
	}
}
