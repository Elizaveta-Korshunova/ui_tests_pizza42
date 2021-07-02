package testiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
    WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void CloseAdvertisement() {
        try {
            boolean rek = driver.findElement(By.xpath("//div[contains(@class, 'modal-dialog-content')]")).isDisplayed();
            WebElement close = driver.findElement(By.xpath("//a[contains(@class , 'modal-dialog-close')]"));
            close.click();
        }
        catch (Exception exception) {
            System.out.println("Element not found, everything is ok");
        }

    }
}
