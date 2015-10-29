package com.vzw.prepaid.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.dao.DatabaseRequestDAO;
import com.vzw.prepaid.dao.DatabaseRequestDAOImpl;

public class AjaxListener extends AbstractWebDriverEventListener{
	
	DatabaseRequestDAO dao = new DatabaseRequestDAOImpl();
	Object obj;

	public void afterClickon(WebElement element, WebDriver driver){
		int objId = Integer.parseInt( PropertyConfigurator.props.getProperty("SUCCESS_POPUP_OBJ_ID"));
		obj = dao.getObject(objId);
		
		try {
	
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getObjectXPath())));
		
		}
		catch(StaleElementReferenceException e){
			e.printStackTrace();
		}
		
	}
	
}
