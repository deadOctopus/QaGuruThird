package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void homeWorkTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Frolov");
        $("#userEmail").setValue("vadim.frolov.2018@inbox.ru");
        $("#userNumber").setValue("8999612028");
        $("#currentAddress").setValue("Penza");

        $(byText("Male")).click();
        $(byText("Sports")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__month-select").selectOptionContainingText("October");
        $(".react-datepicker__day--015").click();

        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();


        $("#uploadPicture").uploadFromClasspath("file.png");

        $("#submit").scrollTo().click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Vadim Frolov"));
        $(".table-responsive").shouldHave(text("vadim.frolov.2018@inbox.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8999612028"));
        $(".table-responsive").shouldHave(text("15 October,1998"));
        $(".table-responsive").shouldHave(text("Physics, Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("file.png"));
        $(".table-responsive").shouldHave(text("Penza"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}