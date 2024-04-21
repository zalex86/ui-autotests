package com.faphouse.tests;

import com.codeborne.selenide.Condition;
import com.faphouse.BaseSetup;
import com.faphouse.page.fapHouse.MainPage;
import com.faphouse.page.fapHouse.accountWizard.EmailConfirmationPage;
import com.faphouse.page.fapHouse.accountWizard.StepOnePage;
import com.faphouse.page.fapHouse.accountWizard.StepThreePage;
import com.faphouse.page.fapHouse.accountWizard.StepTwoPage;
import org.testng.annotations.Test;

import static com.faphouse.helpers.TestUtils.getRandomString;
import static com.faphouse.helpers.TestUtils.getRandomStringWithNumbers;

public class RegistrationTests extends BaseSetup {
    @Test(description = "Business Registration test")
    public void registrationTest() {
        String username = getRandomStringWithNumbers(10);
        String email = getRandomString(4) + "@test.com";
        String password = getRandomStringWithNumbers(6);
        new MainPage()
                .inputUsername(username)
                .inputEmail(email)
                .inputPassword(password)
                .clickStartEarningMoneyButton();
        new StepOnePage()
                .chooseBusinessAccountType()
                .fillAllRequiredFields()
                .clickNextButton();
        StepTwoPage stepTwoPage = new StepTwoPage();
        stepTwoPage.nextButton.shouldHave(Condition.visible)
                .shouldHave(Condition.cssClass("button__disabled"));
        stepTwoPage.agreementSignBlock.shouldHave(Condition.visible)
                .shouldHave(Condition.attribute("data-value", "false"));
        stepTwoPage.checkSignAgreementCheckbox();

        stepTwoPage.agreementSignBlock.shouldHave(Condition.visible)
                .shouldHave(Condition.attribute("data-value", "true"));
        stepTwoPage.nextButton
                .shouldNotHave(Condition.cssClass("button__disabled"))
                .click();

        new StepThreePage()
                .uploadAllRequiredFiles()
                .clickFinishButton();
        new EmailConfirmationPage()
                .dismissAcknowledgmentConfirmation()
                .confirmDeletingOfAccount()
                .startEarningMoneyButton.shouldBe(Condition.visible);
    }
}
