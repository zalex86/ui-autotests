package com.faphouse;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.faphouse.helpers.DriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BaseSetup {

    public static String SERVER;
    public static Logger LOGGER = Logger.getLogger("");
    public static final String downloadFilepath = "D:\\Users\\AleksanDR\\Downloads\\";//"/tmp/";
    public static String TESTER_EMAIL;
    public static HashMap<String, String> USER_CREDENTIALS;
    public static String USER_EMAIL;
    public static String USER_PASSWORD;
    public static ConcurrentMap<String, Map<String, String>> apiCookieTokens = new ConcurrentHashMap<>();

    @BeforeSuite
    public void setupServer() throws IOException {
        serverSetup();
        testerSetup();
    }

    @BeforeMethod
    public final void setUpDriver() {
        DriverFactory.setUpDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(false)
                .includeSelenideSteps(false));
        open(SERVER);
    }

    @AfterMethod
    public final void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    private void serverSetup() {
        SERVER = System.getProperty("server");
    }

    private void testerSetup() throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(Files.newInputStream(Path.of("src/test/resources/configuration/authorization.xml")));
        TESTER_EMAIL = properties.getProperty("testerEmail");

        String testerPassword = properties.getProperty("testerPassword");

        USER_CREDENTIALS = new HashMap<>() {{
            put(TESTER_EMAIL, testerPassword);
        }};

        USER_EMAIL = properties.getProperty("userEmail");
        USER_PASSWORD = properties.getProperty("userPassword");

    }
}
