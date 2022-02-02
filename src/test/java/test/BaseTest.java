package test;

import aquality.selenium.browser.AqualityServices;
import help.PropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

import java.util.Properties;

public class BaseTest {
    protected HomePage homePage;
    PropertyUtil helper;
    Properties pageProperties;

    @BeforeMethod
    protected void beforeMethod() {
        helper = new PropertyUtil();
        pageProperties = helper.getProperties("page.properties");
        AqualityServices.getBrowser().goTo(pageProperties.getProperty("home"));
        homePage = new HomePage();
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
