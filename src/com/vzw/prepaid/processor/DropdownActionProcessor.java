package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;

public class DropdownActionProcessor implements ActionExecutor {
	
	
	static Logger logger  = Logger.getLogger(DropdownActionProcessor.class);
	
	private QaData data;
	private QaObject object;
	private WebDriver driver;
	
	
	public DropdownActionProcessor(QaObject object, QaData data, WebDriver driver) {
		this.data = data;
		this.object = object;
		this.driver = driver;
	}
	
	
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(data.getDataValue());
	}
	
	
	
}
