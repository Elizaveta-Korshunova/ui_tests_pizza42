package testiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    public static WebDriver driver;
    public static  PageTest Page_Test;
    public static  Helper helpers;
    public static void driver () {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        Page_Test = new PageTest();
        helpers = new Helper(driver);
    }

}
