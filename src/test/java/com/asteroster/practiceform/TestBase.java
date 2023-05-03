package com.asteroster.practiceform;

import com.asteroster.practiceform.helpers.Attach;
import com.asteroster.practiceform.pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
        Configuration.browserVersion = System.getProperty("browser_version", "99.0");
        Configuration.remote = System.getProperty("remote_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browser = System.getProperty("browser", "chrome");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("allure", new AllureSelenide());
        }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
