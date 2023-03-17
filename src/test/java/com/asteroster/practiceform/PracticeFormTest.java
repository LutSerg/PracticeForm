package com.asteroster.practiceform;

import com.asteroster.practiceform.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormTest() {
        String name = "Фантомас";
        String lastname = "Багровый";
        String email = "fantom@bagroviy.ru";
        String gender = "Male";
        String number = "4415639874";
        String day = "20";
        String year = "1999";
        String month = "August";
        String subject = "History";
        String hobby = "Music";
        String picture = "screen_getting_started.png";
        String currentAddress = "some current address";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(name)
                .setLastname(lastname)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit()
                .verifyModalAppears()
                .verifyResult("Student Name", name + " " + lastname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("State and City", state + " " + city)
                .closeModal();
    }
}
