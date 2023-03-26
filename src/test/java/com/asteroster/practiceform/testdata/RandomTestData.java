package com.asteroster.practiceform.testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class RandomTestData {
    public static Faker faker = new Faker(new Locale("en"));

    public static String fakerUserName = faker.name().firstName();
    public static String fakerUserLastName = faker.name().lastName();
    public static String fakerUserEmail = faker.internet().emailAddress();
    public static String fakerUserAddress = faker.address().fullAddress();
    public static String fakerUserNumber = faker.phoneNumber().subscriberNumber(10);
    public static String fakerUserSubject = faker.options()
            .option("Maths", "Computer Science", "History", "English", "Arts", "Biology", "Hindi");
    public static String fakerUserHobby = faker.options().option("Sports", "Reading", "Music");
    public static Date fakerDateOfBirthday = faker.date().birthday();
    public static String birthDay = (new SimpleDateFormat("d", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String birthMonth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String birthYear = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String fakerUserGender = faker.options().option("Male", "Female", "Other");
    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    public static String fakerState = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    public static String fakerCity = faker.options().option(mapStateWithCity.get(fakerState));
    public static String userPicture = "screen_getting_started.png";

}
