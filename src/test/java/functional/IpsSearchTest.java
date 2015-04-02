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
        driver.get(BaseURL + "/ua/index.php"); // ������� �� ����
        driver.findElement(By.id("login")).sendKeys("VRomanA@i.ua"); // �����
        driver.findElement(By.id("pwd")).sendKeys("11111");  //������
        driver.findElement(By.name("enter")).click();
        Assert.assertEquals(driver.getTitle(), "����� ��������� ������� �� ³��������� �������");
        driver.findElement(By.xpath("//a[1]/img")).click(); //������� �� ���. ������
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.blockTitle.tab1")).getText(), "����ϲ�˲"); //�������� ��� ��������� �� ���. ������
        driver.findElement(By.id("Submit")).click(); //������� ������ "�����"
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������"); //�������� ������� ������ "²��������"
        //����� "���������� ��� �������"
        driver.findElement(By.id("area_6")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        //����� "���������� ��� ����������"
        driver.findElement(By.id("area_9")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        //����� "�� ���������"
        driver.findElement(By.id("area_0")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        //����� "³����� �����"
        driver.findElement(By.id("purchase_type_1")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_1")).click();
        //����� "����������� �����"
        driver.findElement(By.id("purchase_type_3")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_3")).click();
        //����� "����� ������� ����������"
        driver.findElement(By.id("purchase_type_4")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_4")).click();
        //����� "��������� ����������� ��������"
        driver.findElement(By.id("purchase_type_7")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_7")).click();
        //����� "����������� ��������� �������"
        driver.findElement(By.id("purchase_type_11")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_11")).click();
        //����� "���� ��������"
        driver.findElement(By.id("purchase_type_10")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_10")).click();
        //����� "�������� � ������ ��������"
        driver.findElement(By.id("purchase_type_6")).click();
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("purchase_type_6")).click();
        //����� �� ��������� ������
        driver.findElement(By.id("subject")).sendKeys("���");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("subject")).clear();
        driver.findElement(By.id("subject")).sendKeys("�������");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");
        driver.findElement(By.id("subject")).clear();
        //����� �� �������������
        driver.findElement(By.id("purchase_classifier")).sendKeys("01");
        driver.findElement(By.id("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='button btnDefault doTrack']/span")).getText(), "²��������");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
