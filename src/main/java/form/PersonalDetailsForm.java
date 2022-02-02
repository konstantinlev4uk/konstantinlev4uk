package form;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    protected PersonalDetailsForm() {
        super(By.xpath("//div[@class='personal-details__form']"), "Personal Details Form");
    }
}
