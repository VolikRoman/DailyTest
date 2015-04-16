package functional;

import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchPurchaseTest extends AbstractTest {

    @Test
    public void testPurchaseSearch(){
        SearchPage searchPage = new SearchPage(browser);
        searchPage.openHomePage();
        searchPage.login();
        searchPage.openSearchPage();
        searchPage.testIpsPurchaseSearchDaily();
        searchPage.logout();
    }
}
