package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickLogOut {

	@FindBy(linkText="Log out")
	private WebElement logOut;
	
	
	public ClickLogOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogOut(){
		logOut.click();
	}
	
}
