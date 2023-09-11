package in.amazon.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;

public class VerifyErrorMessageTest {

WebDriver driver;

@BeforeTest
public void launchApplication() {
	//1. Open the browser
	driver = new ChromeDriver();
	
	//Maximize it
	driver.manage().window().maximize();
	
	//Navigate to the application
	driver.get("https://amazon.in");
}

@Test

public void verifyErrorMsg() {
	//4. Hover over the pointer over Hello Sign-in menu
	LandingPage landingPage = new LandingPage(driver);
	landingPage.hoverOverHelloSignInMenu();
	
	//5) Click in SIgn-in button in the sub menu
	landingPage.clickSignInBtn();
	
	//6)Enter invalid username in the email box
	SignIn signIn = new SignIn(driver);
	signIn.enterMail("batman554466@gmail.com");
	
	//7) Clickm on continue button
	signIn.clickContinueBtn();
	
	String expectedErrMsg = "";
	String actualErrMsg = signIn.getErrMsg();
	Assert.assertEquals(actualErrMsg, expectedErrMsg);
}
	
}
