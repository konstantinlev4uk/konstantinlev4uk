package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;

public class TimerTestCase4 extends BaseTest {
    @Test
    public void timerTest() {

        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not loaded");

        RegistrationPage registrationPage = homePage.openRegistrationPage();
        Assert.assertEquals(registrationPage.getTimer(), "00:00:00", "Timer does not start counting from zero");
    }
}
