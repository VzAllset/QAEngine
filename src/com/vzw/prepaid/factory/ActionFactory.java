package com.vzw.prepaid.factory;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.processor.ActionExecutor;
import com.vzw.prepaid.processor.AjaxClickActionProcessor;
import com.vzw.prepaid.processor.CaptureActionProcessor;
import com.vzw.prepaid.processor.ClickActionProcessor;
import com.vzw.prepaid.processor.DropdownActionProcessor;
import com.vzw.prepaid.processor.FillActionProcessor;

public class ActionFactory 
{
	public static ActionExecutor getActionProcessor(String action, Object object, Data data, WebDriver driver,Step step, Flow flow)
	{
		if(action != null)
		{
			if(action.equalsIgnoreCase("FILL"))
			{
				return new FillActionProcessor(object,data,driver);
			}
			else if(action.equalsIgnoreCase("NORMAL_CLICK"))
			{
				return new ClickActionProcessor(object,data,driver);
			}
			else if(action.equalsIgnoreCase("SELECT"))
			{
				return new DropdownActionProcessor(object,data,driver);
			}
			else if(action.equalsIgnoreCase("CAPTURE"))
			{
				return new CaptureActionProcessor(object,data,driver,step,flow);
			}
			else if(action.equalsIgnoreCase("AJAX_CLICK"))
			{
				return new AjaxClickActionProcessor(object,data,driver);
			}
		}
		return null;
	}
}
