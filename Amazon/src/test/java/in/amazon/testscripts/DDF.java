package in.amazon.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;
import utils.ReadExcel;

public class DDF  extends BaseTestJava{
	@Test

	public void verifyErrorMsg() throws IOException {
		//4. Hover over the pointer over Hello Sign-in menu
		LandingPage landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignInMenu();
		
		//5) Click in SIgn-in button in the sub menu
		landingPage.clickSignInBtn();
		String[][] data = ReadExcel.getData("resources//TestData.xlsx", "Sheet1");
		
		
		for(int i =1; i<6; i++) {
			String username = data[i][1];
		
		//6)Enter invalid username in the email box
		SignIn signIn = new SignIn(driver);
		signIn.enterMail(username);
		
		//7) Click on continue button
		signIn.clickContinueBtn();
		
		String expectedErrMsg = "";
		String actualErrMsg = signIn.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
	}
}
