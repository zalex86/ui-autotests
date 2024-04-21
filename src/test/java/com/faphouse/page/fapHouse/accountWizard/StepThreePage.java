package com.faphouse.page.fapHouse.accountWizard;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.faphouse.BaseSetup;
import com.faphouse.helpers.PageObjectUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StepThreePage {
    private static final String PAGE_URL = BaseSetup.SERVER + "account/wizard/step/three";
    private static final String SRC_TEST_RESOURCES_VERIFICATION_EXAMPLE_1_BIG_PNG = "src/test/resources/1.png";
    private static final String ABSOLUTE_PATH = new File(SRC_TEST_RESOURCES_VERIFICATION_EXAMPLE_1_BIG_PNG).getAbsolutePath();

    public final SelenideElement passportUploadField = $("#field-element-passport");
    public final SelenideElement passportPreviewDropdownMenu = $("[data-testid='dropdown']");

    public final SelenideElement commercialRegisterBlock = $("div[data-testid='form-field-commercialRegisterExtract']");
    public final By uploadField = By.cssSelector("input");
    public final By uploadedFilePreview = By.cssSelector(".upload-preview-file");
    public final SelenideElement certificateIncorporationBlock = $("div[data-testid='form-field-certificateOfIncorporation']");
    public final SelenideElement finishButton = $x("//div[@class='form__actions']//span[contains(text(),'Finish')]/..");


    public StepThreePage() {
        PageObjectUtils.waitPageIsPresentByURL(PAGE_URL);
    }

    @Step("Upload all required files")
    public StepThreePage uploadAllRequiredFiles() {
        passportPreviewDropdownMenu.shouldNotBe(Condition.visible);
        passportUploadField.sendKeys(ABSOLUTE_PATH);
        passportPreviewDropdownMenu.shouldBe(Condition.visible);
        commercialRegisterBlock.$(uploadField).sendKeys(ABSOLUTE_PATH);
        commercialRegisterBlock.$$(uploadedFilePreview).shouldHave(CollectionCondition.size(1));
        certificateIncorporationBlock.$(uploadField).sendKeys(ABSOLUTE_PATH);
        certificateIncorporationBlock.$$(uploadedFilePreview).shouldHave(CollectionCondition.size(1));
        return this;
    }

    @Step("Click the finish button")
    public void clickFinishButton() {
        finishButton.click();
    }
}