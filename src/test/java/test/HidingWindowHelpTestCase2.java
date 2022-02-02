package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;

public class HidingWindowHelpTestCase2 extends BaseTest {
    @Test
    public void hidingWindowHelpTest() {

        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not loaded");

        RegistrationPage registrationPage = homePage.openRegistrationPage();
        registrationPage.sendHelpBottom();
        Assert.assertTrue(registrationPage.isHelpDisplayed(), "Help not Displayed");
    }
}
