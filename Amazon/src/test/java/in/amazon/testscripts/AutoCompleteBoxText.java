package in.amazon.testscripts;

import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;

public class AutoCompleteBoxText extends BaseTestJava{

	@Test
	public void selectItem() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.searchItem("computer");
	}
	
}
