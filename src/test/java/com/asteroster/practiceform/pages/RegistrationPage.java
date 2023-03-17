package com.asteroster.practiceform.pages;

import com.asteroster.practiceform.pages.components.CalendarComponent;
import com.asteroster.practiceform.pages.components.ModalResultsComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ModalResultsComponent modalResultsComponent = new ModalResultsComponent();
    SelenideElement
            firstName = $("#firstName"),
            lastname = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            hobbie = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            address = $("[placeholder='Current Address']"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastname(String value) {
        lastname.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        phone.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbie.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        address.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submit.click();

        return this;
    }

    public RegistrationPage verifyModalAppears() {
        modalResultsComponent.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        modalResultsComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeModal() {
        closeButton.click();

        return this;
    }
}
