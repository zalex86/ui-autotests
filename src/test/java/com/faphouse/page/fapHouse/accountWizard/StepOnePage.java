package com.faphouse.page.fapHouse.accountWizard;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.faphouse.BaseSetup;
import com.faphouse.helpers.PageObjectUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.faphouse.helpers.TestUtils.getRandomString;

public class StepOnePage {
    private static final String PAGE_URL = BaseSetup.SERVER + "account/wizard/step/one";

    public final SelenideElement businessTypeButton = $(".value-business");
    public final SelenideElement producerNameInput = $("input[data-testid='field-element-producerName']");
    public final SelenideElement contactFirstnameInput = $("input[data-testid='field-element-contactFirstname']");
    public final SelenideElement contactLastnameInput = $("input[data-testid='field-element-contactLastname']");
    public final SelenideElement directorFirstnameInput = $("input[data-testid='field-element-directorFirstname']");
    public final SelenideElement directorLastnameInput = $("input[data-testid='field-element-directorLastname']");
    public final SelenideElement companyNameInput = $("input[data-testid='field-element-companyName']");
    public final SelenideElement registrationNumberInput = $("input[data-testid='field-element-registrationNumber']");
    public final SelenideElement addressCountryInput = $("input[data-testid='field-element-addressCountryCode']");
    public final SelenideElement countriesListDropdown = $(".field-select__dropdown");
    public final By countryListItem = By.cssSelector("button");
    public final SelenideElement addressCityInput = $("input[data-testid='field-element-addressCity']");
    public final SelenideElement addressRegionInput = $("input[data-testid='field-element-addressRegion']");
    public final SelenideElement addressPostInput = $("input[data-testid='field-element-addressPostCode']");
    public final SelenideElement addressStreetInput = $("input[data-testid='field-element-addressStreet']");
    public final SelenideElement custodianRecordsInput = $("textarea[data-testid='field-element-custodianOfRecordsAddress']");
    public final SelenideElement nextButton = $("button[data-testid='wizard-business-form-submit-btn']");

    public StepOnePage() {
        PageObjectUtils.waitPageIsPresentByURL(PAGE_URL);
    }

    @Step("Choose the business account type")
    public StepOnePage chooseBusinessAccountType() {
        businessTypeButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Fill all required fields")
    public StepOnePage fillAllRequiredFields() {
        String randomString = getRandomString(8);
        producerNameInput.shouldBe(Condition.visible).sendKeys(randomString);
        contactFirstnameInput.sendKeys(randomString);
        contactLastnameInput.sendKeys(randomString);
        directorFirstnameInput.sendKeys(randomString);
        directorLastnameInput.sendKeys(randomString);
        companyNameInput.sendKeys(randomString);
        registrationNumberInput.sendKeys(randomString);
        countriesListDropdown.shouldNotBe(Condition.visible);
        addressCountryInput.sendKeys("usa");
        countriesListDropdown.shouldBe(Condition.visible).$$(countryListItem).shouldHave(CollectionCondition.size(1)).get(0)
                .click();
        addressCityInput.sendKeys(randomString);
        addressRegionInput.sendKeys(randomString);
        addressPostInput.sendKeys(randomString);
        addressStreetInput.sendKeys(randomString);
        custodianRecordsInput.sendKeys(randomString);
        return this;
    }

    @Step("Click on the 'next' button")
    public void clickNextButton() {
        nextButton.shouldNotHave(Condition.cssClass("button__disabled")).click();
    }
}