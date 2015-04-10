package functional;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.Browser;

public class IpsSearchTest extends AbstractTest {
    private Browser browser;
    private static final String BaseURL = "http://ips.vdz.ua/ua/";

    public void login(){
        browser.get(BaseURL + "/index.php"); // переход на сайт
        browser.findElement(By.id("login")).sendKeys("VRomanA@i.ua"); // логин
        browser.findElement(By.id("pwd")).sendKeys("11111");  //пароль
        browser.findElement(By.name("enter")).click();
    }

    public void logout(){
        browser.findElement(By.xpath("//div[@class='enterForm']/span[4]")).click();
    }

    public void submit(){
        browser.findElement(By.id("Submit")).click(); //нажатие кнопки "Поиск"
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ"  /*"ВІДСТЕЖУЄТЬСЯ"*/); //проверка наличии кнопки "ВІДСТЕЖИТИ"
    }

    public void testTitle(){
        Assert.assertEquals(browser.getTitle(), "Сервіс Пошукових профілів та Відстеження тендерів");
    }

    public void testSearch(){
        browser.findElement(By.xpath("//a[1]/img")).click(); //переход на стр. поиска
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "ЗАКУПІВЛІ"); //проверка что находимся на стр. поиска
        submit();
    }

    //поиск "Оголошення про початок"
    public void testAnnouncementStartSearch(){
        browser.findElement(By.id("area_6")).click();
        submit();
    }

    //поиск "Оголошення про результати"
    public void testAnnouncementResultSearch(){
        browser.findElement(By.id("area_9")).click();
        submit();
    }

    //поиск "Всі документи"
    public void testAllDocumentsSearch(){
        browser.findElement(By.id("area_0")).click();
        submit();
    }

    //поиск "Відкриті торги"
    public void testOpenPurchaseSearch(){
        browser.findElement(By.id("purchase_type_1")).click();
        submit();
        browser.findElement(By.id("purchase_type_1")).click();
    }

    //поиск "Двоступеневі торги"
    public void testTwoStagePurchaseSearch(){
        browser.findElement(By.id("purchase_type_3")).click();
        submit();
        browser.findElement(By.id("purchase_type_3")).click();
    }

    //поиск "Запит цінових пропозицій"
    public void testQuotationSearch(){
        browser.findElement(By.id("purchase_type_4")).click();
        submit();
        browser.findElement(By.id("purchase_type_4")).click();
    }

    //поиск "Попередня кваліфікація учасників"
    public void testPrequalificationSearch(){
        browser.findElement(By.id("purchase_type_7")).click();
        submit();
        browser.findElement(By.id("purchase_type_7")).click();
    }

    //поиск "Переговорна процедура закупівлі"
    public void testNegotiatingPurchase(){
        browser.findElement(By.id("purchase_type_11")).click();
        submit();
        browser.findElement(By.id("purchase_type_11")).click();
    }

    //поиск "Інша закупівля"
    public void testOtherPurchase(){
        browser.findElement(By.id("purchase_type_10")).click();
        submit();
        browser.findElement(By.id("purchase_type_10")).click();
    }

    //поиск "Закупівля в одного учасника"
    public void testPurchaseOfOneParticipant(){
        browser.findElement(By.id("purchase_type_6")).click();
        submit();
        browser.findElement(By.id("purchase_type_6")).click();
    }

    //поиск по ключевому словам
    public void testByKeyWord(){
        browser.findElement(By.id("subject")).sendKeys("Газ");
        submit();
        browser.findElement(By.id("subject")).clear();
        browser.findElement(By.id("subject")).sendKeys("Послуги");
        submit();
        browser.findElement(By.id("subject")).clear();
    }

    //поиск по класификатору
    public void testPurchaseClassifier(){
        browser.findElement(By.id("purchase_classifier")).sendKeys("01");
        submit();
        browser.findElement(By.id("subject")).clear();
    }
    @Test
    public void testIpsPurchaseSearchDaily() {
        login();
        testTitle();
        testSearch();
        testAnnouncementStartSearch();
        testAnnouncementResultSearch();
        testAllDocumentsSearch();
        testOpenPurchaseSearch();
        testTwoStagePurchaseSearch();
        testQuotationSearch();
        testPrequalificationSearch();
        testNegotiatingPurchase();
        testOtherPurchase();
        testPurchaseOfOneParticipant();
        testByKeyWord();
        testPurchaseClassifier();

        logout();
    }

    @Test
    public void testIpsDocumentSearchDaily() {
        login();
        browser.findElement(By.xpath("//a[1]/img")).click(); //переход на стр. поиска
        //Непроцедурні документи
//        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab2")).getText(), "НЕПРОЦЕДУРНІ ДОКУМЕНТИ");
        browser.findElement(By.cssSelector("h1.blockTitle.tab2")).click();
//        browser.findElement(By.xpath("//div[@class='searchForm']/.//button[@id='Submit']/span")).click();
        browser.findElement(By.cssSelector("td > #Submit")).click();

        browser.findElement(By.name("p_user")).sendKeys("37927092");
        browser.findElement(By.className("btnDefault")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");
        browser.findElement(By.name("p_user")).clear();
        logout();
    }

}
