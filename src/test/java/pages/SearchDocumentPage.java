package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import webdriver.Browser;

public class SearchDocumentPage extends AbstractPage {

    public static By SEARCH_BUTTON = By.id("Submit_nonprocedural");
    public static By REGION_DROP_DOWN = By.className("p_var_region");
    public static By TYPE_DOCUMENT_DROP_DOWN = By.className("type_document");

    public SearchDocumentPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean isOpened() {
        return browser.findElement(SEARCH_BUTTON).isDisplayed();
    }

    public void submit(){
        browser.findElement(SEARCH_BUTTON).click();
    }

    public void testText(By by, String str){
        browser.findElement(by).sendKeys(str);
        submit();
        browser.findElement(by).clear();
    }

    public void selectDropDown(By by, String str){
        new Select(browser.findElement(by)).selectByValue(str);
        submit();
    }

    public void testIpsDocumentSearchDaily() {
        isOpened();
        selectDropDown(REGION_DROP_DOWN, "1");
        selectDropDown(REGION_DROP_DOWN, "-1");
        selectDropDown(TYPE_DOCUMENT_DROP_DOWN, "2");
        selectDropDown(TYPE_DOCUMENT_DROP_DOWN, "3");
        testText(By.name("p_user"), "1");
    }
}
