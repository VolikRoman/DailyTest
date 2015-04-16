package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

public abstract class AbstractPage {
    protected Browser browser;
    private static final String BASE_URL = "http://ips.vdz.ua/ua/";
    public static final By SEARCH_PAGE_LINK = By.xpath("//a[1]/img");
    public static final By NOTIFICATION_PAGE_LINK = By.xpath("//a[2]/img");
    public static final By LOGIN_LINK = By.id("login");
    public static final String LOGIN_TEXT = "VRomanA@i.ua";
    public static final By PASSWORD_LINK = By.id("pwd");
    public static final String PASSWORD_TEXT = "11111";
    public static final By ENTER_BUTTON_LINK = By.name("enter");
    public static final By LOGOUT_LINK = By.xpath("//div[@class='enterForm']/span[4]");
    public static By DOCUMENT_TAB = By.cssSelector("h1.blockTitle.tab2");

    public AbstractPage(Browser browser){
        this.browser = browser;
    }

    public void login(){
        browser.findElement(LOGIN_LINK).sendKeys(LOGIN_TEXT); // логин
        browser.findElement(PASSWORD_LINK).sendKeys(PASSWORD_TEXT);  //пароль
        browser.findElement(ENTER_BUTTON_LINK).click();
    }

    public void logout(){
        browser.findElement(LOGOUT_LINK).click();
    }

    public void openHomePage(){
        browser.get(BASE_URL);
    }

    public SearchPage openSearchPage(){
        browser.findElement(SEARCH_PAGE_LINK).click();
        return (SearchPage) this;
    }

    public SearchDocumentPage openSearchDocumentPage(){
        browser.findElement(SEARCH_PAGE_LINK).click();
        browser.findElement(DOCUMENT_TAB).click();
        return (SearchDocumentPage) this;
    }

    public NotificationPage openNotificationPage(){
        browser.findElement(NOTIFICATION_PAGE_LINK).click();
        return (NotificationPage) this;
    }

    public abstract boolean isOpened();
}
