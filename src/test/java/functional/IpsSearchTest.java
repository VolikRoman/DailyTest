package functional;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.Browser;

public class IpsSearchTest extends AbstractTest {
    private Browser browser;
    private static final String BaseURL = "http://ips.vdz.ua/ua/";

    public void login(){
        browser.get(BaseURL + "/index.php"); // ������� �� ����
        browser.findElement(By.id("login")).sendKeys("VRomanA@i.ua"); // �����
        browser.findElement(By.id("pwd")).sendKeys("11111");  //������
        browser.findElement(By.name("enter")).click();
    }

    public void logout(){
        browser.findElement(By.xpath("//div[@class='enterForm']/span[4]")).click();
    }

    public void submit(){
        browser.findElement(By.id("Submit")).click(); //������� ������ "�����"
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������"  /*"²�����Ӫ����"*/); //�������� ������� ������ "²��������"
    }

    public void testTitle(){
        Assert.assertEquals(browser.getTitle(), "����� ��������� ������� �� ³��������� �������");
    }

    public void testSearch(){
        browser.findElement(By.xpath("//a[1]/img")).click(); //������� �� ���. ������
        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "����ϲ�˲"); //�������� ��� ��������� �� ���. ������
        submit();
    }

    //����� "���������� ��� �������"
    public void testAnnouncementStartSearch(){
        browser.findElement(By.id("area_6")).click();
        submit();
    }

    //����� "���������� ��� ����������"
    public void testAnnouncementResultSearch(){
        browser.findElement(By.id("area_9")).click();
        submit();
    }

    //����� "�� ���������"
    public void testAllDocumentsSearch(){
        browser.findElement(By.id("area_0")).click();
        submit();
    }

    //����� "³����� �����"
    public void testOpenPurchaseSearch(){
        browser.findElement(By.id("purchase_type_1")).click();
        submit();
        browser.findElement(By.id("purchase_type_1")).click();
    }

    //����� "����������� �����"
    public void testTwoStagePurchaseSearch(){
        browser.findElement(By.id("purchase_type_3")).click();
        submit();
        browser.findElement(By.id("purchase_type_3")).click();
    }

    //����� "����� ������� ����������"
    public void testQuotationSearch(){
        browser.findElement(By.id("purchase_type_4")).click();
        submit();
        browser.findElement(By.id("purchase_type_4")).click();
    }

    //����� "��������� ����������� ��������"
    public void testPrequalificationSearch(){
        browser.findElement(By.id("purchase_type_7")).click();
        submit();
        browser.findElement(By.id("purchase_type_7")).click();
    }

    //����� "����������� ��������� �������"
    public void testNegotiatingPurchase(){
        browser.findElement(By.id("purchase_type_11")).click();
        submit();
        browser.findElement(By.id("purchase_type_11")).click();
    }

    //����� "���� ��������"
    public void testOtherPurchase(){
        browser.findElement(By.id("purchase_type_10")).click();
        submit();
        browser.findElement(By.id("purchase_type_10")).click();
    }

    //����� "�������� � ������ ��������"
    public void testPurchaseOfOneParticipant(){
        browser.findElement(By.id("purchase_type_6")).click();
        submit();
        browser.findElement(By.id("purchase_type_6")).click();
    }

    //����� �� ��������� ������
    public void testByKeyWord(){
        browser.findElement(By.id("subject")).sendKeys("���");
        submit();
        browser.findElement(By.id("subject")).clear();
        browser.findElement(By.id("subject")).sendKeys("�������");
        submit();
        browser.findElement(By.id("subject")).clear();
    }

    //����� �� �������������
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
        browser.findElement(By.xpath("//a[1]/img")).click(); //������� �� ���. ������
        //����������� ���������
//        Assert.assertEquals(browser.findElement(By.cssSelector("h1.blockTitle.tab2")).getText(), "����������Ͳ ���������");
        browser.findElement(By.cssSelector("h1.blockTitle.tab2")).click();
//        browser.findElement(By.xpath("//div[@class='searchForm']/.//button[@id='Submit']/span")).click();
        browser.findElement(By.cssSelector("td > #Submit")).click();

        browser.findElement(By.name("p_user")).sendKeys("37927092");
        browser.findElement(By.className("btnDefault")).click();
        Assert.assertEquals(browser.findElement(By.xpath("//a[@class='btnDefault']/span")).getText(), "����");
        browser.findElement(By.name("p_user")).clear();
        logout();
    }

}
