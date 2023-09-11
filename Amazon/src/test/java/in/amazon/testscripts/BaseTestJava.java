package in.amazon.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestJava {
WebDriver driver;

@BeforeTest
public void launchApplication() {
	//Open the browser
	driver = new ChromeDriver();
	
	//2) Maximize it
	driver.manage().window().maximize();
	
	//Navigate to the application
	driver.get("https://amazon.in");
}
//9) Close the browser
@AfterTest
public void closeBrowser() {
	driver.quit();
}

}
