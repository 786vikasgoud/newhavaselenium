package Driver_setup;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class driver_setup {
    public static WebDriver driver = null;
    @BeforeSuite
    public void setDriver(){
        driver=new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void driverquit(){
        driver.quit();
    }
}
