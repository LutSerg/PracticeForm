package com.asteroster.practiceform.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTest {

    @Test
    void simplePropertyTest() {
        String browserName =  System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest2 () {
        System.setProperty("browser", "chrome");
        String browserName =  System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest3() {
        String browserName =  System.getProperty("browser", "mozilla");
        System.out.println(browserName);
    }

    @Test
    @Tag("simple_property")
    void simplePropertyTest4() {
        System.setProperty("browser", "chrome");
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName);
    }

    @Test
    @Tag("many_properties")
    void simplePropertyTest5() {
        String browserName = System.getProperty("browser", "mozilla");
        String browserVersion = System.getProperty("browser_version", "99.0");
        System.out.println(browserName);
        System.out.println(browserVersion);
    }

    @Test
    @Tag("hello")
    void simplePropertyTest6() {
        System.out.println(format("Hello, %s!", System.getProperty("userName", "some student")));
    }
}
