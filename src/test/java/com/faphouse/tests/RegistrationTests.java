package com.faphouse.tests;

import com.faphouse.page.AccountWizardStepOnePage;
import com.faphouse.page.MainPage;
import org.testng.annotations.Test;

import static com.faphouse.helpers.TestUtils.getRandomString;
import static com.faphouse.helpers.TestUtils.getRandomStringWithNumbers;

public class RegistrationTests {
    @Test(description = "Business Registration test")
    public void registrationTest() {
        String username = getRandomStringWithNumbers(12);
        String email = getRandomString(4) + "@test.com";
        String password = getRandomStringWithNumbers(6);
        new MainPage()
                .inputUsername(username)
                .inputEmail(email)
                .inputPassword(password)
                .clickStartEarningMoneyButton();
        new AccountWizardStepOnePage()
                .chooseBusinessAccountType()
                .fillAllRequiredFields()
                .clickNextButton();

    }
}
