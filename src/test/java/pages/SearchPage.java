package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

public class SearchPage extends AbstractPage {
    public static By RESET_BUTTON = By.id("resetBtn");
    public static By SEARCH_BUTTON = By.id("Submit");
    public static By ANNOUNCE_START_RADIO_BUTTON = By.id("area_6");
    public static By ANNOUNCE_RESULT_RADIO_BUTTON = By.id("area_9");
    public static By ALL_DOCUMENTS_RADIO_BUTTON = By.id("area_0");
    public static By OPEN_PURCHASE_CHECKBOX = By.id("purchase_type_1");
    public static By TWO_STAGE_PURCHASE_CHECKBOX = By.id("purchase_type_3");
    public static By QUOTATION_CHECKBOX = By.id("purchase_type_4");
    public static By PREQUALIFICATION_CHECKBOX = By.id("purchase_type_7");
    public static By NEGOTIATING_CHECKBOX = By.id("purchase_type_11");
    public static By OTHER_PURCHASE_CHECKBOX = By.id("purchase_type_10");
    public static By ONE_PARTICIPANT_PURCHASE_CHECKBOX = By.id("purchase_type_6");
    public static By SUBJECT_TEXTBOX = By.id("subject");
    public static By CLASSIFIER_TEXTBOX = By.id("purchase_classifier");

    public SearchPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean isOpened() {
        return browser.findElement(RESET_BUTTON).isDisplayed();
    }

    public void submit(){
        browser.findElement(SEARCH_BUTTON).click();
    }

    public void testRadioButton(By by){
        browser.findElement(by).click();
        submit();
    }

    public void testCheckBox(By by){
        browser.findElement(by).click();
        submit();
        browser.findElement(by).click();
    }

    public void testText(By by, String str){
        browser.findElement(by).sendKeys(str);
        submit();
        browser.findElement(by).clear();
    }

    public void testIpsPurchaseSearchDaily() {
        isOpened();
        testRadioButton(ANNOUNCE_START_RADIO_BUTTON);
        testRadioButton(ANNOUNCE_RESULT_RADIO_BUTTON);
        testRadioButton(ALL_DOCUMENTS_RADIO_BUTTON);
        testCheckBox(OPEN_PURCHASE_CHECKBOX);
        testCheckBox(TWO_STAGE_PURCHASE_CHECKBOX);
        testCheckBox(QUOTATION_CHECKBOX);
        testCheckBox(PREQUALIFICATION_CHECKBOX);
        testCheckBox(NEGOTIATING_CHECKBOX);
        testCheckBox(OTHER_PURCHASE_CHECKBOX);
        testCheckBox(ONE_PARTICIPANT_PURCHASE_CHECKBOX);
        testText(SUBJECT_TEXTBOX, "Газ");
        testText(SUBJECT_TEXTBOX, "Послуги");
        testText(SUBJECT_TEXTBOX, "Запчастини");
        testText(SUBJECT_TEXTBOX, "Бензин");
        testText(CLASSIFIER_TEXTBOX, "01");
        testText(CLASSIFIER_TEXTBOX, "1");
        testText(CLASSIFIER_TEXTBOX, "11");
    }
}
