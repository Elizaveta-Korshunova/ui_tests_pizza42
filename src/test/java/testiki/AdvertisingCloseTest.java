package testiki;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AdvertisingCloseTest {

    @Test
    public void advertising() {
        {
            System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://xn--42-vlcmszua7f.xn--p1ai/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            boolean rek = driver.findElement(By.xpath("//div[contains(@class, 'modal-dialog-content')]")).isDisplayed();
            WebElement close = driver.findElement(By.xpath("//a[contains(@class , 'modal-dialog-close')]"));
            close.click();
            driver.quit();
        }
    }
}
