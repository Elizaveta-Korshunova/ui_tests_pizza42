package testiki;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.time.Duration;

public class AuthorizationTest {
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
    public void Authorization () {
        helper.CloseAdvertisement();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.setItem("form_agreement", "confirmed");
        local.setItem("ppm_cart_guid", "8984f72c-26ca-40a0-ae43-f3a75281ce26");
        local.setItem("form_agreement2", "confirmed");
        local.setItem("cookies_accepted", "on");
        local.setItem("_ym46483551_il", "\"Мой аккаунт\"");
        local.setItem("_uthm", "8b66f7b32d0dbdc1ab62a4ed4a3c7b53");
        local.setItem("_prhm", "{\"ts\":1625030802281,\"p\":\"79095131507\"}");
        local.setItem("customNotifications", "{\"2769601054\":{\"updated_at\":1624939930358},\"2769601057\":{\"updated_at\":1625040299736},\"2769601064\":{\"updated_at\":1624530412806}}");
        local.setItem("_ym46483551_lsid", "1218367933194");
        local.setItem("_ym46483551_lastHit", "1625040314794");
        local.setItem("apvstundefined", "kemerovo");
        local.setItem("_ym46483551_reqNum", "112");
        local.setItem("_ym_uid", "\"1624524797275673344\"");
        local.setItem("_grecaptcha", "09ABU7dzNgYSZpeQGFzLqAiy1RUOSgX8X8goMe_Dh0fqEuLWwW7UyMxuXPyBWpbcfSX_e5mddEgguWzfuBq6T2f3E");
        local.setItem("_ym_retryReqs", "{}");
        driver.navigate().refresh();
        helper.CloseAdvertisement();


    }
}
