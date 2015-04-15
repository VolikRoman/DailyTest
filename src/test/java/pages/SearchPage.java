package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import webdriver.Browser;

/**
 * Created by ����� on 08.04.2015.
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
        browser.findElement(By.id("Submit")).click(); //������� ������ "�����"
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������"  /*"²�����Ӫ����"*/); //�������� ������� ������ "²��������"
    }

    public void testTitle(){
        Assert.assertEquals(browser.getTitle(), "����� �������");
    }

    public void testSearch(){
        browser.findElement(By.xpath("//a[1]/img")).click(); //������� �� ���. ������
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "����ϲ�˲"); //�������� ��� ��������� �� ���. ������
        submit();
    }

    public void testRadioButton(By by){
        browser.findElement(by).click();
        submit();
    }

    //����� "���������� ��� �������"
    public void testAnnouncementStartSearch(){
        testRadioButton(By.id("area_6"));
    }

    //����� "���������� ��� ����������"
    public void testAnnouncementResultSearch(){
        testRadioButton(By.id("area_9"));
    }

    //����� "�� ���������"
    public void testAllDocumentsSearch(){
        testRadioButton(By.id("area_0"));
    }

    public void testCheckBox(By by){
        browser.findElement(by).click();
        submit();
        browser.findElement(by).click();
    }

    //����� "³����� �����"
    public void testOpenPurchaseSearch(){
        testCheckBox(By.id("purchase_type_1"));
    }

    //����� "����������� �����"
    public void testTwoStagePurchaseSearch(){
        testCheckBox(By.id("purchase_type_3"));
    }

    //����� "����� ������� ����������"
    public void testQuotationSearch(){
        testCheckBox(By.id("purchase_type_4"));
    }

    //����� "��������� ����������� ��������"
    public void testPrequalificationSearch(){
        testCheckBox(By.id("purchase_type_7"));
    }

    //����� "����������� ��������� �������"
    public void testNegotiatingPurchase(){
        testCheckBox(By.id("purchase_type_11"));
    }

    //����� "���� ��������"
    public void testOtherPurchase(){
        testCheckBox(By.id("purchase_type_10"));
    }

    //����� "�������� � ������ ��������"
    public void testPurchaseOfOneParticipant(){
        testCheckBox(By.id("purchase_type_6"));
    }

    public void testText(By by, String str){
        browser.findElement(by).sendKeys(str);
        submit();
        browser.findElement(by).clear();
    }

    //����� �� ��������� ������
    public void testByKeyWord(){
        testText(By.id("subject"), "���");
        testText(By.id("subject"), "�������");
    }

    //����� �� �������������
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
        browser.findElement(By.xpath("//a[1]/img")).click(); //������� �� ���. ������
        //����������� ���������
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab2")).getText(), "����������Ͳ ���������");
        browser.findElement(By.cssSelector("h1.blockTitle.tab2")).click();
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");

        new Select(browser.findElement(By.className("p_var_region"))).selectByValue("1");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");
        new Select(browser.findElement(By.className("p_var_region"))).selectByValue("-1");
        browser.findElement(By.id("Submit_nonprocedural")).click();

        new Select(browser.findElement(By.className("type_document"))).selectByValue("1");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");
        new Select(browser.findElement(By.className("type_document"))).selectByValue("2");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");
        new Select(browser.findElement(By.className("type_document"))).selectByValue("3");
        browser.findElement(By.id("Submit_nonprocedural")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");


//        browser.findElement(By.name("p_user")).sendKeys("37927092");
//        browser.findElement(By.id("Submit_nonprocedural")).click();
//        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");
//        browser.findElement(By.name("p_user")).clear();
    }

}
