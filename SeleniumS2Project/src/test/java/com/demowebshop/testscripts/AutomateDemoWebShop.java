package com.demowebshop.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demowebshop.pages.ClickLogIn;
import com.demowebshop.pages.ClickLogOut;
import com.demowebshop.pages.LoginPage;
import utilities.ExcelRead;
import utilities.MyListener;


@Listeners(value= {MyListener.class})

public class AutomateDemoWebShop {

	WebDriver driver;
	ClickLogOut clickLogOut;
	
	@BeforeTest
	public void launchApplication() throws InterruptedException{
		
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://demowebshop.tricentis.com/register");
			}
	

	ExcelRead e = new ExcelRead();
	
	@DataProvider
	public Object[][] loginData() throws IOException{
		int LastRow = e.getLastRow("C:\\Users\\hp\\Desktop\\TestDataNew.xlsx", "Sheet1");
		Object[][] mydata = new Object[LastRow+1][2];
		for(int i=0; i<=LastRow; i++)
		{
	    mydata[i][0] = e.readExcel("C:\\Users\\hp\\Desktop\\TestDataNew.xlsx", "Sheet1", i, 0);
	    mydata[i][1] = e.readExcel("C:\\Users\\hp\\Desktop\\TestDataNew.xlsx", "Sheet1", i, 1);
	    
	}
		return mydata;
	}
	
	@Test(dataProvider="loginData", priority=1)
	public void testLogin(String u, String p) {
		
		ClickLogIn clickLogIn = new ClickLogIn(driver);
		clickLogIn.clickLogIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginDetails(u, p);
		try {
			clickLogOut = new ClickLogOut(driver);
			clickLogOut.clickLogOut();
		}
		catch(Exception e)
		{
			Assert.fail("Sign Out not found");
		}
		
	}
	

	@Test(priority=2)
	public void loginTestInvalid() {
		
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
	
}
