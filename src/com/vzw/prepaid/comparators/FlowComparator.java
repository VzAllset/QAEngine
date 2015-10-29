package com.vzw.prepaid.comparators;

import java.util.Comparator;

import com.vzw.prepaid.beans.Flow;

public class FlowComparator implements Comparator<Flow>
{
	@Override
	public int compare(Flow flow1, Flow flow2) 
	{
		return Integer.valueOf(flow1.getExecutionSequence()).compareTo(Integer.valueOf(flow2.getExecutionSequence()));
	}

}
