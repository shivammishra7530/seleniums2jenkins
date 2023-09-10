package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {

    WebDriver driver;

    @BeforeTest
    public void launchApplication() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/register");
    }

    public String takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\hp\\Pictures\\Screenshots\\" + System.currentTimeMillis() + ".png";
        File target = new File(path);
        FileUtils.copyFile(source, target);
        String targetPath = target.getAbsolutePath();
        return targetPath;
    }
}
