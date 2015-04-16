package functional;

import org.testng.annotations.Test;
import pages.SearchDocumentPage;

public class SearchDocumentTest extends AbstractTest {

    @Test
    public void testDocumentSearch(){
        SearchDocumentPage searchDocumentPage = new SearchDocumentPage(browser);
        searchDocumentPage.openHomePage();
        searchDocumentPage.login();
        searchDocumentPage.openSearchDocumentPage();
        searchDocumentPage.testIpsDocumentSearchDaily();
        searchDocumentPage.logout();
    }
}
