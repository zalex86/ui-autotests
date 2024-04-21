package com.faphouse.page.fapHouse.accountWizard;

import com.codeborne.selenide.SelenideElement;
import com.faphouse.BaseSetup;
import com.faphouse.helpers.PageObjectUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StepTwoPage {
    private static final String PAGE_URL = BaseSetup.SERVER + "account/wizard/step/two";

    public final SelenideElement agreementSignBlock = $("div[data-testid='field-element-contractSigned']");
    public final By checkbox = By.cssSelector("span");
    public final SelenideElement nextButton = $x("//div[@class='form__actions']//span[contains(text(),'Next')]/..");

    public StepTwoPage() {
        PageObjectUtils.waitPageIsPresentByURL(PAGE_URL);
    }

    @Step("Check the sign agreement checkbox")
    public void checkSignAgreementCheckbox() {
        agreementSignBlock.$(checkbox).click();
    }


}