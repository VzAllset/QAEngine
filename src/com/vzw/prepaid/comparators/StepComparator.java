package com.vzw.prepaid.comparators;

import java.util.Comparator;

import com.vzw.prepaid.beans.Step;

public class StepComparator implements Comparator<Step>
{
	@Override
	public int compare(Step step1, Step step2) 
	{
		return Integer.valueOf(step1.getExecutionSequence()).compareTo(Integer.valueOf(step2.getExecutionSequence()));
	}

}
