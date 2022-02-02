package test;

import form.AvatarInterestsForm;
import form.FirstRegistrationForm;
import form.PersonalDetailsForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;

public class FillingCardsInformationTestCase1 extends BaseTest {

    @Test
    public void fillingCardsInformationTest() {

        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not loaded");

        RegistrationPage registrationPage = homePage.openRegistrationPage();
        FirstRegistrationForm firstRegistrationForm = registrationPage.getFirstForm();
        Assert.assertTrue(firstRegistrationForm.state().isDisplayed()
                , "First Registration Form is not loaded");

        firstRegistrationForm.inputPAssword();
        firstRegistrationForm.inputEmail();
        firstRegistrationForm.inputDomain();
        firstRegistrationForm.selectDomainZone();
        firstRegistrationForm.checkAcceptTerms();
        AvatarInterestsForm avatarInterestsForm = firstRegistrationForm.openAvatarInterestsForm();
        Assert.assertTrue(avatarInterestsForm.state().isDisplayed(), "Avatar Interests Form is not loaded");

        avatarInterestsForm.unSelectAll();
        avatarInterestsForm.selectRandomInterests(3);
        avatarInterestsForm.uploadAvatar();
        PersonalDetailsForm personalDetailsForm = avatarInterestsForm.openPersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().isDisplayed(), "Personal Details Form is not loaded");
    }
}
