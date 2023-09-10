package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(xpath="//input[contains(@class,'button-1 login-button')]")
	private WebElement logInButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterLoginDetails(String u, String p)
	{
		email.sendKeys(u);
		password.sendKeys(p);
		logInButton.click();
	}
	
}
