package form;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.stream.Collectors;

public class FirstRegistrationForm extends Form {

    private ITextBox inputPasswordTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "input Password TextBox");
    private ITextBox inputEmailTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "input Email TextBox");
    private ITextBox inputDomainTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "input Domain");
    private IButton dropDownButton = AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='dropdown__header']"), "Drop Down Button");
    private IButton termsButton = AqualityServices.getElementFactory().getButton(By.xpath("//span[contains(@class,'icon-check')]"), "Terms Button");
    private IButton nextButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(text(),'Next')]"), "Next Button");
    private final String DOMAIN = "gmail";
    private String domainZone = "//div[contains(text(),'%s')]";

    public FirstRegistrationForm() {
        super(By.xpath("//div[@class='login-form__container']"), "First Registration Form");
    }

    public void inputPAssword() {
        String randomPassword = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
        String password = "A1" + randomPassword;
        inputPasswordTextBox.clearAndType(password);
    }

    public void inputEmail() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String email = "A" + generatedString;
        inputEmailTextBox.clearAndType(email);
    }

    public void inputDomain() {
        inputDomainTextBox.clearAndType(DOMAIN);
    }

    public void selectDomainZone() {
        dropDownButton.click();
        AqualityServices.getElementFactory().getLabel(By.xpath(String.format(domainZone, ".com")), "Select Domain Zone").click();
    }

    public void checkAcceptTerms() {
        termsButton.click();
    }

    public AvatarInterestsForm openAvatarInterestsForm() {
        nextButton.click();
        return new AvatarInterestsForm();
    }
}
