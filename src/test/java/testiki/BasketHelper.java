package testiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.ExecutionException;

public class BasketHelper {
    WebDriver driver;
    ClickHelper clickHelper;

    public BasketHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void Basket () {
       try {
           WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
           blockDesserts.click(); // перехожу на вкладку "Десерт"
           WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
           productDesserts.click(); // открывать маскарпоне
           WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
           diameter.click(); // выбираю диаметр 30см
           Thread.sleep(5000);
           clickHelper.Buy();
           Thread.sleep(5000);
           clickHelper.Close();
           WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
           blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
           WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
           pineapple.click(); // открывать ананасики
           Thread.sleep(5000);
           clickHelper.Buy();
           Thread.sleep(5000);
           clickHelper.Close();
           Thread.sleep(5000);
           WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
           bacon.click(); // открывать бекон
           Thread.sleep(5000);
           clickHelper.Buy();
           Thread.sleep(5000);
           WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
           basket.click(); // перехожу в корзину
           Thread.sleep(5000);
       }
       catch (Exception exception) {
           System.out.println("Everything is ok");
       }
    }
}
