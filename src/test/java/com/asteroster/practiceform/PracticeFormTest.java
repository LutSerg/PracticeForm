package com.asteroster.practiceform;

import com.asteroster.practiceform.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.asteroster.practiceform.testdata.RandomTestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("practice_form")
    @DisplayName("Форма регистрации студентов. Тест в jenkins")
    void practiceFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(fakerUserName)
                .setLastname(fakerUserLastName)
                .setEmail(fakerUserEmail)
                .setGender(fakerUserGender)
                .setNumber(fakerUserNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(fakerUserSubject)
                .setHobbie(fakerUserHobby)
                .uploadPicture(userPicture)
                .setCurrentAddress(fakerUserAddress)
                .setState(fakerState)
                .setCity(fakerCity)
                .pressSubmit()
                .verifyModalAppears()
                .verifyResult("Student Name", fakerUserName + " " + fakerUserLastName)
                .verifyResult("Student Email", fakerUserEmail)
                .verifyResult("Gender", fakerUserGender)
                .verifyResult("Mobile", fakerUserNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", fakerUserSubject)
                .verifyResult("Hobbies", fakerUserHobby)
                .verifyResult("Address", fakerUserAddress)
                .verifyResult("State and City", fakerState + " " + fakerCity)
                .closeModal();
    }
}
