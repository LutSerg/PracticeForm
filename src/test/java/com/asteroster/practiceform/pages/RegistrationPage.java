package com.asteroster.practiceform.pages;

import com.asteroster.practiceform.pages.components.CalendarComponent;
import com.asteroster.practiceform.pages.components.ModalResultsComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


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
        step("Открываем страницу", () -> {
        open("/automation-practice-form");
        });
        return this;
    }

    public RegistrationPage removeBanner() {
        step("Убираем рекламный баннер", () -> {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        });

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        step("Ввод имени", () -> {
        firstName.setValue(value);});

        return this;
    }

    public RegistrationPage setLastname(String value) {
        step("Ввод фамилии", () -> {
        lastname.setValue(value);});

        return this;
    }

    public RegistrationPage setEmail(String value) {
        step("Ввод email", () -> {
        email.setValue(value);
        });
        return this;
    }

    public RegistrationPage setGender(String value) {
        step ("Выбирается гендер", () -> {
        gender.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setNumber(String value) {
        step("Ввод номера телефона", () -> {
        phone.setValue(value);
        });

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        step("Ввод даты рождения", () -> {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        });

        return this;
    }

    public RegistrationPage setSubject(String value) {
        step("Выбор предмета", () -> {
        subject.setValue(value).pressEnter();
        });

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        step("Выбо хобби", () -> {
        hobbie.$(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        step("Загрузка авата", () -> {
        uploadPicture.uploadFromClasspath(value);
        });

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        step("Ввод адреса", () -> {
        address.setValue(value);
        });

        return this;
    }

    public RegistrationPage setState(String value) {
        step("Выбор штата", () -> {
        state.click();
        $(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage setCity(String value) {
        step("Выбор города", () -> {
        city.click();
        $(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage pressSubmit() {
        step("Нажатие кнопки Submit", () -> {
        submit.click();
        });

        return this;
    }

    public RegistrationPage verifyModalAppears() {
        step ("Появление модального окна с результатами заполнения", () -> {
        modalResultsComponent.verifyModalAppears();
        });

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        step("Проверка результатов заполненной формы", () -> {
        modalResultsComponent.verifyResult(key, value);
        });

        return this;
    }

    public RegistrationPage closeModal() {
        step("Закрытие модального окна", () -> {
        closeButton.click();
        });

        return this;
    }
}
