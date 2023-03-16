package com.asteroster.practiceform.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalResultsComponent {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldBe(visible)
                .shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
