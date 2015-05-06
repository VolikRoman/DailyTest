package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import webdriver.Browser;

public class NotificationPage extends AbstractPage {
    public static By PROFILE_CREATE_BUTTON = By.id("searchProfileCreate");
    public static By PROFILE_CREATE_IFRAME = By.xpath(".//div[@id='ui-id-1']/iframe");
    public static String PROFILE_NAME = "MYTEST";
    public static By PROFILE_NAME_TEXTBOX = By.id("name");
    public static By PROFILE_REGION_DROPDOWN = By.id("region");
    public static String SELECT_REGION = "1";
    public static By PROFILE_INDUSTRY_DROPDOWN = By.id("industry");
    public static String SELECT_INDUSTRY = "1";
    public static By PROFILE_SUBJECT_DROPDOWN = By.id("selKwOption_");
    public static String SELECT_SUBJECT = "subject";
    public static By CREATED_PROFILE = By.xpath(".//div[@class='title']/strong[text()='" + PROFILE_NAME + "']");
    public static By FIELD_LINK = By.id("kw_");
    public static String FIELD_TEXT = "Послуги";
    public static By ENTER_BUTTON_LINK = By.id("Submit");
//    public static By DELETE_PURCHASE_PROFILE = By.id("delete_profile");
    public static By DELETE_PURCHASE_PROFILE = By.xpath("(.//a[@id = 'delete_profile'])[6]/img");  //xpath("(.//a[@title = 'Видалити?'])[7]/img")
    public static By CLOSE_WINDOW = By.xpath(".//button[@type = 'button']/span");


    public NotificationPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean isOpened() {
       return browser.findElement(PROFILE_CREATE_BUTTON).isDisplayed();
    }

    public void testCreatePurchaseProfile(){
        isOpened();
        browser.findElement(PROFILE_CREATE_BUTTON).click();
        browser.switchTo().frame(browser.findElement(PROFILE_CREATE_IFRAME));
        browser.findElement(PROFILE_NAME_TEXTBOX).sendKeys(PROFILE_NAME);
        new Select(browser.findElement(PROFILE_REGION_DROPDOWN)).selectByValue(SELECT_REGION);
        new Select(browser.findElement(PROFILE_INDUSTRY_DROPDOWN)).selectByValue(SELECT_INDUSTRY);
        new Select(browser.findElement(PROFILE_SUBJECT_DROPDOWN)).selectByValue(SELECT_SUBJECT);
        browser.findElement(FIELD_LINK).sendKeys(FIELD_TEXT);
        browser.findElement(ENTER_BUTTON_LINK).click();
        browser.findElement(CREATED_PROFILE).isDisplayed();
        browser.findElement(DELETE_PURCHASE_PROFILE).click();
        Alert alert = browser.switchTo().alert();
        alert.accept();
        browser.findElement(CLOSE_WINDOW).click();

    }
}
