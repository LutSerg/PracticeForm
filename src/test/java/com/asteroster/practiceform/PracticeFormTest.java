package com.asteroster.practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeEach
    void setUp() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
    @Test
    void practiceFormTest () {
        $("#firstName").setValue("Some name");
        $("#lastName").setValue("Some surname");
        $("#userEmail").setValue("Some_email@email.com");
        $("[for = gender-radio-1]").click();
        $("#userNumber").setValue("4415639874");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select")
                .$(byText("August")).click();
        $(".react-datepicker__year-select").selectOptionByValue("2001");
        $(".react-datepicker__month").$(byText("23")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("[for = hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("screen_getting_started.png");
        $("[placeholder='Current Address']").setValue("use some text");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();
    }
}
