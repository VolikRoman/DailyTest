package functional;

import org.testng.annotations.Test;
import pages.NotificationPage;

import java.awt.*;

public class SearchProfileTest extends AbstractTest {

    @Test
    public void test() throws AWTException {
        NotificationPage notificationPage = new NotificationPage(browser);
        notificationPage.openHomePage();
        notificationPage.login();
        notificationPage.openNotificationPage();
        notificationPage.testCreatePurchaseProfile();
        notificationPage.logout();
    }

}
