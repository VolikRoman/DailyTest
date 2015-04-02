package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IpsSearchTest {
    private WebDriver driver;
    private static final String BaseURL = "http://ips.vdz.ua/ua/";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testIpsDaily() throws Exception {
        driver.get(BaseURL + "/ua/index.php"); // переход на сайт
        driver.findElement(By.id("login")).sendKeys("VRomanA@i.ua"); // логин
        driver.findElement(By.id("pwd")).sendKeys("11111");  //пароль
        driver.findElement(By.name("enter")).click();
        Assert.assertEquals(driver.getTitle(), "Сервіс Пошукових профілів та Відстеження тендерів");
        driver.findElement(By.xpath("//a[1]/img")).click(); //переход на стр. поиска
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "ЗАКУПІВЛІ"); //проверка что находимся на стр. поиска
        driver.findElement(By.id("Submit")).click(); //нажатие кнопки "Поиск"
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ"); //проверка наличии кнопки "ВІДСТЕЖИТИ"
        //поиск "Оголошення про початок"
        driver.findElement(By.id("area_6")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        //поиск "Оголошення про результати"
        driver.findElement(By.id("area_9")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        //поиск "Всі документи"
        driver.findElement(By.id("area_0")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        //поиск "Відкриті торги"
        driver.findElement(By.id("purchase_type_1")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_1")).click();
        //поиск "Двоступеневі торги"
        driver.findElement(By.id("purchase_type_3")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_3")).click();
        //поиск "Запит цінових пропозицій"
        driver.findElement(By.id("purchase_type_4")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_4")).click();
        //поиск "Попередня кваліфікація учасників"
        driver.findElement(By.id("purchase_type_7")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_7")).click();
        //поиск "Переговорна процедура закупівлі"
        driver.findElement(By.id("purchase_type_11")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_11")).click();
        //поиск "Інша закупівля"
        driver.findElement(By.id("purchase_type_10")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_10")).click();
        //поиск "Закупівля в одного учасника"
        driver.findElement(By.id("purchase_type_6")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("purchase_type_6")).click();
        //поиск по ключевому словам
        driver.findElement(By.id("subject")).sendKeys("Газ");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("subject")).clear();
        driver.findElement(By.id("subject")).sendKeys("Послуги");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");
        driver.findElement(By.id("subject")).clear();
        //поиск по класификатору
        driver.findElement(By.id("purchase_classifier")).sendKeys("01");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
