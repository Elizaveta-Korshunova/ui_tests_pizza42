package testiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickHelper {

    WebDriver driver;

    public ClickHelper (WebDriver driver) {
        this.driver = driver;
    }

    public void buy () {
        WebElement buy = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large')]"));
        buy.click(); // кладу в корзину маскарпоне
    }
    public void close () {
        WebElement close = driver.findElement(By.xpath("//*[contains(@viewBox, '0 0 18 18')]"));
        close.click(); // кладу в корзину маскарпоне
    }
    public void minus () {
        WebElement minus = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-count-control')]//a) [1]"));
        minus.click();
    }
}
