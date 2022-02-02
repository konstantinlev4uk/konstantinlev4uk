package page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private IButton nextPageButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='start__link']"), "NextPage button");

    public HomePage() {
        super(By.xpath("//div[@class='view__content']"), "Userinyerface Home Page");
    }

    public RegistrationPage openRegistrationPage() {
        nextPageButton.click();
        return new RegistrationPage();
    }
}
