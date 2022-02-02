package form;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AvatarInterestsForm extends Form {

    private ITextBox uploadAvatarButton = AqualityServices.getElementFactory().getTextBox(By.xpath("//a[contains(text(),'upload')]"), "Upload Button");
    private IButton nextButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(text(),'Next')]"), "Next Button");
    private IButton unSelectAllButton = AqualityServices.getElementFactory().getButton(By.xpath("//label[@for='interest_unselectall']"), "UnSelectAll Button");

    public AvatarInterestsForm() {
        super(By.xpath("//div[contains(@class,'interests__form')]"), "Avatar Interests Form");
    }

    public void unSelectAll() {
        unSelectAllButton.click();
    }

    public void selectRandomInterests(int interests) {
        List<String> item = getRandomInterests(interests);
        for (int i = 0; i < item.size(); i++) {
            IButton button = AqualityServices.getElementFactory().getButton(By.xpath("//div[contains(@class,'interests-list__item')][.//span[text()='" + item.get(i) + "']]//span[@class='checkbox__box']"), "button");
            button.click();
        }
    }

    private List<String> getRandomInterests(int interests) {
        List<String> item = getInterests();
        int a = item.indexOf("Unselect all");
        item.remove(a);
        int b = item.indexOf("Select all");
        item.remove(b);
        List<Integer> index = new ArrayList<>();
        while (index.size() != interests) {
            index.add((int) (Math.random() * item.size()));
        }
        List<String> itemString = new ArrayList<>();
        for (int i = 0; i < index.size(); i++) {
            itemString.add(item.get(index.get(i)));
        }
        return itemString;
    }

    private List<String> getInterests() {
        List<ILabel> interests = AqualityServices.getElementFactory().findElements(By.xpath("//div[contains(@class,'interests-list__item')]"), ElementType.LABEL);
        List<String> item = new ArrayList<>();
        for (int i = 0; i < interests.size(); i++) {
            item.add(interests.get(i).getText());
        }
        return item;
    }

    public PersonalDetailsForm openPersonalDetailsForm() {
        nextButton.state().waitForNotExist(Duration.ofSeconds(5));
        nextButton.click();
        return new PersonalDetailsForm();
    }

    public void uploadAvatar() {
        uploadAvatarButton.click();
        try {
            Runtime.getRuntime().exec("src/test/resources/input3.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
