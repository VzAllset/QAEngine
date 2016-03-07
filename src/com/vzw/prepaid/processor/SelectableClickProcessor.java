package com.vzw.prepaid.processor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;

public class SelectableClickProcessor implements ActionExecutor {
	
	
	static Logger logger  = Logger.getLogger(SelectableClickProcessor.class);
	
	
	private QaObject object;
	private WebDriver driver;
	
	
	public SelectableClickProcessor(QaObject object, QaData data, WebDriver driver) {
		
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
	}

}
