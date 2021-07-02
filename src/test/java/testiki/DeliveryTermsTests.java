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

public class DeliveryTermsTests {
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
    public void districtSouthernOne() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
        Assert.assertTrue(minSum.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtSouthernFirst() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '24')]"));
        diameter.click(); // выбираю диаметр 24см
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
        Assert.assertTrue(minSumFree.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtSouthernThree() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtSouthern = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [1]")); // поле район южный
        districtSouthern.click();// южный
        try {
            WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись закаpать до бесплатной доставки сумма заказа
            Assert.assertFalse(minSumFree.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        try {
            WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
            Assert.assertFalse(minSum.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtCentralOne() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtCentral = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [2]")); // поле район центральный
        districtCentral.click();// южный
        WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
        Assert.assertTrue(minSum.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtCentralFirst() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 24см
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtCentral = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [2]")); // поле район центральный
        districtCentral.click();// центральный
        WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
        Assert.assertTrue(minSumFree.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtCentralThree() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtCenter = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [2]")); // поле район центаральный
        districtCenter.click();// южный
        try {
            WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
            Assert.assertFalse(minSumFree.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        try {
            WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
            Assert.assertFalse(minSum.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtComisarovoOne() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtComisarovo = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [3]")); // поле район комисарово
        districtComisarovo.click();// южный
        WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
        Assert.assertTrue(minSum.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtComisarovoFirst() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtComisarovo = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [3]")); // поле район комисарово
        districtComisarovo.click();// южный
        WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
        Assert.assertTrue(minSumFree.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtComisarovoThree() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtComisarovo = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [3]")); // поле район комиссарово
        districtComisarovo.click();// комисарово
        try {
            WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
            Assert.assertFalse(minSumFree.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        try {
            WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
            Assert.assertFalse(minSum.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtRainbowOne() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockPizzaAdditives = driver.findElement(By.xpath("(//a[contains(text(), 'Добавки к пицце')]) [1]"));
        blockPizzaAdditives.click(); // перехожу на вкладку "Добавки к пицце"
        WebElement pineapple = driver.findElement(By.xpath("//*[contains(text(), 'Ананасы консервированные')]"));
        pineapple.click(); // открывать ананасики
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.close();
        Thread.sleep(500);
        WebElement bacon = driver.findElement(By.xpath("(//*[contains(text(), 'Бекон')]) [2]"));
        bacon.click(); // открывать бекон
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtRainbow = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [4]")); // поле район радуга
        districtRainbow.click();// радуга
        WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
        Assert.assertTrue(minSum.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtRainbowFirst() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtRainbow = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [4]")); // поле район радуга
        districtRainbow.click();// радуга
        WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
        Assert.assertTrue(minSumFree.isEnabled());
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void districtRainbowThree() throws InterruptedException {
        helper.closeAdvertisement();
        authorization.authorization(driver);
        helper.closeAdvertisement();
        WebElement blockDesserts = driver.findElement(By.xpath("(//a[contains(text(), 'Десерт')]) [1]"));
        blockDesserts.click(); // перехожу на вкладку "Десерт"
        WebElement productDesserts = driver.findElement(By.xpath("//*[contains(text(), 'Маскарпоне с малиной')]"));
        productDesserts.click(); // открывать маскарпоне
        WebElement diameter = driver.findElement(By.xpath("//a[contains(text(), '30')]"));
        diameter.click(); // выбираю диаметр 30см
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        clickHelper.buy();
        Thread.sleep(500);
        WebElement basket = driver.findElement(By.xpath("//span[contains(@class, 'cart-widget-container')]"));
        basket.click(); // перехожу в корзину
        Thread.sleep(500);
        WebElement district = driver.findElement(By.xpath("//a[contains(@class, 'form-control form-control-selector-link')]")); // поле район
        district.click();
        Thread.sleep(2500);
        WebElement districtRainbow = driver.findElement(By.xpath("(//a[contains(@class, 'with-right-icon')]) [4]")); // поле район радуга
        districtRainbow.click();// радуга
        try {
            WebElement minSumFree = driver.findElement(By.xpath("//div[contains(@class, 'free-delivery-from')]")); // Надпись заказать до бесплатной доставки сумма заказа
            Assert.assertFalse(minSumFree.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        try {
            WebElement minSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-footer-min-order-price')]")); // Надпись минимальная сумма заказа
            Assert.assertFalse(minSum.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
        }
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }

}
