package testiki;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Locale;

public class PositiveTests {
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
    public void Basket() throws InterruptedException {
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

        WebElement costMascarpone = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [3]")); // стоимость Маскарпоне в корзине (без руб)
        WebElement costPineapple = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [2]")); // стоимость Ананасиков в корзине (без руб)
        WebElement costBacon = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [1]")); // стоимость Бекона в корзине (без руб)
        WebElement costSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-total-value')]")); // стоимость Итого (без руб)

        // перевожу в int чтобы сложить и сравнить
        int costMascarponeV = Integer.parseInt(costMascarpone.getText());
        int costPineappleV = Integer.parseInt(costPineapple.getText());
        int costBaconV = Integer.parseInt(costBacon.getText());
        String costSumS = costSum.getText();
       // int costSumV = Integer.parseInt(costSumS);
        int expectationSum = costMascarponeV + costPineappleV + costBaconV; // ожидаемая сумма
        String expectationSumS = Integer.toString(expectationSum) + " " + "руб.";

        Assert.assertEquals(expectationSumS, costSumS); // сравниваем ожидаемую и фактическую сумму

        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }

    @Test
    public void Ordering () throws InterruptedException {
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
        try {
            WebElement buttonOff = driver.findElement(By.xpath("//a[contains(@class, 'button-solid button-large button-md cart-dialog-create-order button-md  button-disabled')]")); // кнопка "Сделать заказ" не активная
            Assert.assertFalse(buttonOff.isEnabled());
        }
        catch (Exception exception) {
            System.out.println("Everything is ok");
     }
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
    public void DeletedProducts1() throws InterruptedException {
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
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        WebElement costMascarpone = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [2]")); // стоимость Маскарпоне в корзине (без руб)
        WebElement costPineapple = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [1]")); // стоимость Ананасиков в корзине (без руб)
        WebElement costSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-total-value')]")); // стоимость Итого (без руб)
        // перевожу в int чтобы сложить и сравнить
        int costMascarponeV = Integer.parseInt(costMascarpone.getText());
        int costPineappleV = Integer.parseInt(costPineapple.getText());
        String costSumS = costSum.getText();
        int expectationSum = costMascarponeV + costPineappleV; // ожидаемая сумма
        String expectationSumS = Integer.toString(expectationSum) + " " + "руб.";
        Assert.assertEquals(expectationSumS, costSumS); // сравниваем ожидаемую и фактическую сумму
        clickHelper.Minus();  // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void DeletedProducts2() throws InterruptedException {
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
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        WebElement costMascarpone = driver.findElement(By.xpath("(//div[contains(@class, 'cart-product-price')]//b) [1]")); // стоимость Маскарпоне в корзине (без руб)
        WebElement costSum = driver.findElement(By.xpath("//div[contains(@class, 'cart-receipt-total-value')]")); // стоимость Итого (без руб)
        // перевожу в int чтобы сложить и сравнить
        int costMascarponeV = Integer.parseInt(costMascarpone.getText());
        String costSumS = costSum.getText();
        int expectationSum = costMascarponeV; // ожидаемая сумма
        String expectationSumS = Integer.toString(expectationSum) + " " + "руб.";
        Assert.assertEquals(expectationSumS, costSumS); // сравниваем ожидаемую и фактическую сумму
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
    @Test
    public void DeletedProducts3() throws InterruptedException {
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
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        clickHelper.Minus(); // удаляем первую позицию в корзине
        Thread.sleep(2500);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(text(), 'В вашей корзине нет ни одного товара')]")).isDisplayed());
    }
}
