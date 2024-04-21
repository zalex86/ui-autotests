package com.faphouse.page.fapHouse.accountWizard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.faphouse.BaseSetup;
import com.faphouse.helpers.PageObjectUtils;
import com.faphouse.page.fapHouse.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class EmailConfirmationPage {
    private static final String PAGE_URL = BaseSetup.SERVER + "account/wizard/step/email-confirmation";

    public final SelenideElement confirmationModal = $("div[data-testid='affidavit-modal']");
    public final SelenideElement dismissAndDeleteButton = $("button[data-testid='affidavit-modal__cancel']");
    public final SelenideElement dismissModal = $("div[data-testid='affidavit-dismiss-modal']");
    public final SelenideElement deleteButton = $("button[data-testid='affidavit-dismiss-modal__ok']");

    public EmailConfirmationPage() {
        PageObjectUtils.waitPageIsPresentByURL(PAGE_URL);
    }

    @Step("Scroll the form and click the dismiss button")
    public EmailConfirmationPage dismissAcknowledgmentConfirmation() {
        confirmationModal.shouldBe(Condition.visible);
        dismissModal.shouldNotBe(Condition.visible);
        dismissAndDeleteButton.scrollIntoView(true).shouldBe(Condition.visible).click();
        dismissModal.shouldBe(Condition.visible);
        return this;
    }

    @Step("Confirm deleting the account by clicking the delete button")
    public MainPage confirmDeletingOfAccount() {
        deleteButton.click();
        return new MainPage();
    }
}