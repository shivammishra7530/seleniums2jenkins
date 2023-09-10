package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickLogIn {

	@FindBy(linkText="Log in")
	private WebElement logIn;
	
	
	public ClickLogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogIn(){
		logIn.click();
	}
	
}
