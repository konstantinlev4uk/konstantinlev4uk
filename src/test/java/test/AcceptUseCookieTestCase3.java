package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;

public class AcceptUseCookieTestCase3 extends BaseTest {
    @Test
    public void acceptUseCookieTestCase3() {

        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not loaded");

        RegistrationPage registrationPage = homePage.openRegistrationPage();
        registrationPage.acceptUseCookie();
        Assert.assertTrue(registrationPage.isCookieFormDisplayed(), "CookieForm is not closed");
    }
}
