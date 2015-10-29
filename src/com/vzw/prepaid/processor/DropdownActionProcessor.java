package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;

public class DropdownActionProcessor implements ActionExecutor {
	
	
	static Logger logger  = Logger.getLogger(DropdownActionProcessor.class);
	
	private Data data;
	private Object object;
	private WebDriver driver;
	
	
	public DropdownActionProcessor(Data data, Object object, WebDriver driver) {
		this.data = data;
		this.object = object;
		this.driver = driver;
	}
	
	
	
	@Override
	public void runAction(){
		String xpath = object.getObjectXPath();
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(data.getDataValue());
	}
	
	
	
}
