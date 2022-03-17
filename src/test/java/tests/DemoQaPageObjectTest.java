package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DemoQaPageObjectTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    String firstName = "Vadim";
    String lastName = "Frolov";
    String userEmail = "vadim.frolov.2018@inbox.ru";
    String userNumber = "8999612028";
    String currentAddress = "Moscow";
    String userGender = "Male";
    String userHobbies = "Sports";
    String day = "15";
    String month = "October";
    String year = "1998";
    String subjects = "Physics";
    String subjectsTwo = "Computer Science";
    String stateName = "NCR";
    String city = "Delhi";
    String fileName = "file.png";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationTest(){
        authorizationPage.openPage()
                .setName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setUserAdress(currentAddress)
                .clickRadiButtonGender(userGender)
                .clickRadiButtonHobbies(userHobbies)
                .calendar(day, month, year)
                .pressSubject(subjects)
                .pressSubjectTwo(subjectsTwo)
                .setState(stateName)
                .setCity(city)
                .uploadFile(fileName)
                .clickSubmit();


        authorizationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", userGender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", userHobbies)
                .checkForm("Address", currentAddress)
                .checkForm("Picture", fileName)
                .checkForm("State and City", stateName + " " + city);
    }

}

