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

public class NegativeTests {
    WebDriver driver;
    Helper helper;
    Authorization authorization;
    ClickHelper clickHelper;
    BasketHelper basketHelper;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://xn--42-vlcmszua7f.xn--p1ai/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        helper = new Helper(driver);
        authorization = new Authorization();
        clickHelper = new ClickHelper(driver);
        basketHelper = new BasketHelper(driver);

    }
    @After
    public void over () {
        driver.quit();
    }
    @Test
    public void OrderingNotName () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement street = driver.findElement(By.xpath("//input[contains(@id, 'cart-street')]")); // поле улицы
        WebElement house = driver.findElement(By.xpath("//input[contains(@id, 'cart-house')]")); // поле дома
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        Thread.sleep(2500);
        street.sendKeys("Космическая");
        Thread.sleep(2500);
        house.sendKeys("6а");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        WebElement button = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md')]")); // кнопка "Сделать заказ" активная
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void OrderingNotStreet () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'cart-name')]")); // поле имени
        WebElement house = driver.findElement(By.xpath("//input[contains(@id, 'cart-house')]")); // поле дома
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        name.sendKeys("Елизавета");
        Thread.sleep(2500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        Thread.sleep(2500);
        house.sendKeys("6а");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void OrderingNotHouse () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'cart-name')]")); // поле имени
        WebElement street = driver.findElement(By.xpath("//input[contains(@id, 'cart-street')]")); // поле улицы
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        name.sendKeys("Елизавета");
        Thread.sleep(2500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        Thread.sleep(2500);
        street.sendKeys("Космическая");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void OrderingChangeDistrict () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'cart-name')]")); // поле имени
        WebElement street = driver.findElement(By.xpath("//input[contains(@id, 'cart-street')]")); // поле улицы
        WebElement house = driver.findElement(By.xpath("//input[contains(@id, 'cart-house')]")); // поле дома
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        name.sendKeys("Елизавета");
        Thread.sleep(2500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtRainbow = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [4]")); // поле район радуга
        districtRainbow.click();// радуга
        Thread.sleep(2500);
        street.sendKeys("Космическая");
        Thread.sleep(2500);
        house.sendKeys("6а");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
        Assert.assertTrue(minSum.isEnabled());
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void OrderingNotChekOne () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'cart-name')]")); // поле имени
        WebElement street = driver.findElement(By.xpath("//input[contains(@id, 'cart-street')]")); // поле улицы
        WebElement house = driver.findElement(By.xpath("//input[contains(@id, 'cart-house')]")); // поле дома
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        name.sendKeys("Елизавета");
        Thread.sleep(2500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        Thread.sleep(2500);
        street.sendKeys("Космическая");
        Thread.sleep(2500);
        house.sendKeys("6а");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement check = driver.findElement(By.xpath("(//i[contains(@class, 'fa fa-check-square-o')]) [1]"));
        check.click();
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        WebElement button = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md')]")); // кнопка "Сделать заказ" активная
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void OrderingNotChekFirst () throws InterruptedException {
        helper.CloseAdvertisement();
        authorization.authorization(driver);
        helper.CloseAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        clickHelper.Close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.Buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'cart-name')]")); // поле имени
        WebElement street = driver.findElement(By.xpath("//input[contains(@id, 'cart-street')]")); // поле улицы
        WebElement house = driver.findElement(By.xpath("//input[contains(@id, 'cart-house')]")); // поле дома
        WebElement appartment = driver.findElement(By.xpath("//input[contains(@id, 'cart-appartment')]")); // поле квартиры
        name.sendKeys("Елизавета");
        Thread.sleep(2500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        Thread.sleep(2500);
        street.sendKeys("Космическая");
        Thread.sleep(2500);
        house.sendKeys("6а");
        Thread.sleep(2500);
        appartment.sendKeys("1");
        Thread.sleep(2500);
        WebElement check = driver.findElement(By.xpath("(//i[contains(@class, 'fa fa-check-square-o')]) [2]"));
        check.click();
        WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
        Assert.assertTrue(buttonOff.isEnabled());
        WebElement button = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md')]")); // кнопка "Сделать заказ" активная
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }

}
