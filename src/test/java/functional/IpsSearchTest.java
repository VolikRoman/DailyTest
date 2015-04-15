package functional;

import org.testng.annotations.Test;
import pages.SearchPage;

public class IpsSearchTest extends AbstractTest {

    @Test
    public void test(){
        SearchPage searchPage = new SearchPage(browser);
        searchPage.openHomePage();
        searchPage.login();
        searchPage.openSearchPage();
        searchPage.testIpsPurchaseSearchDaily();
        searchPage.testIpsDocumentSearchDaily();
        searchPage.logout();
    }

}
