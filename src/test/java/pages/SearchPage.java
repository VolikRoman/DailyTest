package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import webdriver.Browser;

/**
 * Created by Роман on 08.04.2015.
 */
public class SearchPage extends AbstractPage {

    public static By RESET_BUTTON = By.id("resetBtn");

    public SearchPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean isOpened() {
        return browser.findElement(RESET_BUTTON).isDisplayed();
    }

    public void submit(){
        browser.findElement(By.id("Submit")).click(); //нажатие кнопки "Поиск"
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "ВІДСТЕЖИТИ"  /*"ВІДСТЕЖУЄТЬСЯ"*/); //проверка наличии кнопки "ВІДСТЕЖИТИ"
    }

    public void testTitle(){
        Assert.assertEquals(browser.getTitle(), "Пошук тендерів");
    }

    public void testSearch(){
        browser.findElement(By.xpath("//a[1]/img")).click(); //переход на стр. поиска
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "ЗАКУПІВЛІ"); //проверка что находимся на стр. поиска
        submit();
    }

    public void testRadioButton(By by){
        browser.findElement(by).click();
        submit();
    }

    //поиск "Оголошення про початок"
    public void testAnnouncementStartSearch(){
        testRadioButton(By.id("area_6"));
    }

    //поиск "Оголошення про результати"
    public void testAnnouncementResultSearch(){
        testRadioButton(By.id("area_9"));
    }

    //поиск "Всі документи"
    public void testAllDocumentsSearch(){
        testRadioButton(By.id("area_0"));
    }

    public void testCheckBox(By by){
        browser.findElement(by).click();
        submit();
        browser.findElement(by).click();
    }

    //поиск "Відкриті торги"
    public void testOpenPurchaseSearch(){
        testCheckBox(By.id("purchase_type_1"));
    }

    //поиск "Двоступеневі торги"
    public void testTwoStagePurchaseSearch(){
        testCheckBox(By.id("purchase_type_3"));
    }

    //поиск "Запит цінових пропозицій"
    public void testQuotationSearch(){
        testCheckBox(By.id("purchase_type_4"));
    }

    //поиск "Попередня кваліфікація учасників"
    public void testPrequalificationSearch(){
        testCheckBox(By.id("purchase_type_7"));
    }

    //поиск "Переговорна процедура закупівлі"
    public void testNegotiatingPurchase(){
        testCheckBox(By.id("purchase_type_11"));
    }

    //поиск "Інша закупівля"
    public void testOtherPurchase(){
        testCheckBox(By.id("purchase_type_10"));
    }

    //поиск "Закупівля в одного учасника"
    public void testPurchaseOfOneParticipant(){
        testCheckBox(By.id("purchase_type_6"));
    }

    public void testText(By by, String str){
        browser.findElement(by).sendKeys(str);
        submit();
        browser.findElement(by).clear();
    }

    //поиск по ключевому словам
    public void testByKeyWord(){
        testText(By.id("subject"), "Газ");
        testText(By.id("subject"), "Послуги");
    }

    //поиск по класификатору
    public void testPurchaseClassifier(){
        testText(By.id("purchase_classifier"), "01");
    }

    public void testIpsPurchaseSearchDaily() {
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
    }

    public void testIpsDocumentSearchDaily() {
        browser.findElement(By.xpath("//a[1]/img")).click(); //переход на стр. поиска
        //Непроцедурні документи
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab2")).getText(), "НЕПРОЦЕДУРНІ ДОКУМЕНТИ");
        browser.findElement(By.cssSelector("h1.blockTitle.tab2")).click();
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");

        new Select(browser.findElement(By.className("p_var_region"))).selectByValue("1");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");
        new Select(browser.findElement(By.className("p_var_region"))).selectByValue("-1");
        browser.findElement(By.id("Submit_nonprocedural")).click();

        new Select(browser.findElement(By.className("type_document"))).selectByValue("1");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");
        new Select(browser.findElement(By.className("type_document"))).selectByValue("2");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");
        new Select(browser.findElement(By.className("type_document"))).selectByValue("3");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");


//        browser.findElement(By.name("p_user")).sendKeys("37927092");
//        browser.findElement(By.id("Submit_nonprocedural")).click();
//        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "ФАЙЛ");
//        browser.findElement(By.name("p_user")).clear();
    }

}
