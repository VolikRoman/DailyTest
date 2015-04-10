package functional;

import org.testng.annotations.Test;
import pages.NotificationPage;

public class IpsSearchProfileFunctionTest extends AbstractTest {

    @Test
    public void test(){
        NotificationPage notificationPage = new NotificationPage(browser);
        notificationPage.openHomePage();
        notificationPage.login();
        notificationPage.openNotificationPage();
        notificationPage.testCreatePurchaseProfile();
        notificationPage.logout();
    }

}
