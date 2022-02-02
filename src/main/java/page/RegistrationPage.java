package page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import form.FirstRegistrationForm;
import org.openqa.selenium.By;

import java.util.List;

public class RegistrationPage extends Form {

    private static By registrationPage = By.xpath("//div[@class='view__content']");
    private IButton sendBottomButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class,'send-to-bottom-button')]"), "Send Bottom Button");
    private IButton notReallyButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(text(),'Not really')]"), "Not Really Button");
    private ILabel timeLabel = AqualityServices.getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "Timer");

    protected RegistrationPage() {
        super(registrationPage, "registration Page");
    }

    public FirstRegistrationForm getFirstForm() {
        return new FirstRegistrationForm();
    }

    public void sendHelpBottom() {
        sendBottomButton.click();
    }

    public boolean isHelpDisplayed() {
        ILabel label = AqualityServices.getElementFactory().getLabel(By.xpath("//div[@class='game view']/div[contains(@class,'help-form')]"), "Help Form");
        return label.getAttribute("class").contains("hidden");
    }

    public void acceptUseCookie() {
        notReallyButton.click();
    }

    public boolean isCookieFormDisplayed() {
        List<IElement> cookies = AqualityServices.getElementFactory().findElements(By.xpath("//div[@class='cookies']"), ElementType.LABEL);
        return cookies.size() == 0;
    }

    public String getTimer() {
        return timeLabel.getText();
    }
}
