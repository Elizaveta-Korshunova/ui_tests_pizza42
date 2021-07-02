package testiki;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactsTest {

    WebDriver driver;
    Helper helper;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://xn--42-vlcmszua7f.xn--p1ai/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        helper = new Helper(driver);
    }
    @After
    public void over () {
        driver.quit();
    }
    @Test
    public void Contacts () {
        helper.CloseAdvertisement();
        WebElement contacts = driver.findElement(By.xpath("(//a[contains(@class, 'menu-item')] )[5]"));
        contacts.click();
        Assert.assertNotNull(driver.findElement(By.xpath("//div[contains(@class, 'default-content')]")).isDisplayed());
    }
}
