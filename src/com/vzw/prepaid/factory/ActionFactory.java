package com.vzw.prepaid.factory;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.processor.ActionExecutor;
import com.vzw.prepaid.processor.AjaxClickActionProcessor;
import com.vzw.prepaid.processor.CaptureActionProcessor;
import com.vzw.prepaid.processor.CaptureAttrActionProcessor;
import com.vzw.prepaid.processor.ClickActionProcessor;
import com.vzw.prepaid.processor.DropdownActionProcessor;
import com.vzw.prepaid.processor.EnterKeyProcessor;
import com.vzw.prepaid.processor.FillActionProcessor;
import com.vzw.prepaid.processor.HoverProcessor;
import com.vzw.prepaid.processor.IframeSwitchProcessor;
import com.vzw.prepaid.processor.SelectableClickProcessor;

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
			else if(action.equalsIgnoreCase("CAPTURE_ATTR"))
			{
				return new CaptureAttrActionProcessor(object,data,driver,step,flow);
			}
			else if(action.equalsIgnoreCase("AJAX_CLICK"))
			{
				return new AjaxClickActionProcessor(object,data,driver);
			}
			else if(action.equalsIgnoreCase("PRESS_ENTER"))
			{
				return new EnterKeyProcessor(object,driver);
			}
			else if(action.equalsIgnoreCase("HOVER"))
			{
				return new HoverProcessor(object,driver);
			}
			else if(action.equalsIgnoreCase("IFRAME_SWITCH"))
			{
				return new IframeSwitchProcessor(object,driver);
			}
			else if(action.equalsIgnoreCase("SELECTABLE_CLICK"))
			{
				return new SelectableClickProcessor(object,data,driver);
			}
		}
		return null;
	}
}
