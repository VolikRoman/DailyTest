package pages;

import org.openqa.selenium.By;
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
}
