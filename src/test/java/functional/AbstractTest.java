package functional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyLoader;
import webdriver.Browser;
import webdriver.BrowserFactory;

/**
 * Created by Роман on 08.04.2015.
 */
public class AbstractTest {
    protected Browser browser;

    @BeforeClass
    public void initDriver(){
        browser = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        browser.manage().window().maximize();
    }

    @AfterClass
    public void shutEnv(){
        if (browser != null){
            browser.quit();
        }
    }
}
