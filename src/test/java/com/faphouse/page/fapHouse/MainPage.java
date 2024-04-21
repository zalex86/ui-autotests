package com.faphouse.page.fapHouse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.faphouse.BaseSetup;
import com.faphouse.helpers.PageObjectUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final String PAGE_URL = BaseSetup.SERVER;

    public final SelenideElement emailInput = $("div[data-el-name='E-mail'] input");
    public final SelenideElement usernameInput = $("div[data-el-name='Username'] input");
    public final SelenideElement passwordIInput = $("div[data-el-format='password'] input");
    public final SelenideElement startEarningMoneyButton = $("button[class='fh-button fh-button__stretch fh-button__primary']");

    public MainPage() {
        PageObjectUtils.waitPageIsPresentByURL(PAGE_URL);
    }

    @Step("Insert username {0}")
    public MainPage inputUsername(String username) {
        usernameInput.shouldBe(Condition.visible).sendKeys(username);
        return this;
    }

    @Step("Insert email {0}")
    public MainPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Insert password {0}")
    public MainPage inputPassword(String password) {
        passwordIInput.sendKeys(password);
        return this;
    }

    @Step("Click 'Start earning money' button")
    public void clickStartEarningMoneyButton() {
        startEarningMoneyButton.shouldNotHave(Condition.cssClass("fh-button__disabled")).click();
    }
}