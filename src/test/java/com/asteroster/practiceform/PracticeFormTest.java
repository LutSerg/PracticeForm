package com.asteroster.practiceform;

import com.asteroster.practiceform.pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void practiceFormTest () {
        String name = "Фантомас";
        String lastname = "Багровый";
        String email = "fantom@bagroviy.ru";
        String gender = "Male";
        String number = "4415639874";
        String subject = "History";
        String hobbie = "Music";
        String picture = "screen_getting_started.png";
        String currentAddress = "some current address";

        registrationPage.openPage()
                .setFirstName(name)
                .setLastname(lastname)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth("20", "August", "1999")
                .setSubject(subject)
                .setHobbie(hobbie)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress);

        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();
        $(".modal-header").shouldBe(visible)
                .shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive")
                .shouldHave(text("Фантомас Багровый"))
                .shouldHave(text(email))
                .shouldHave(text(gender))
                .shouldHave(text(number))
                .shouldHave(text("23 August,2001"))
                .shouldHave(text("History"))
                .shouldHave(text("Music"))
                .shouldHave(text("Uttar Pradesh Lucknow"));
        $("#closeLargeModal").click();

    }
}
