package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            classMainHeader = $(".main-header"),
            inputFirstName = $("#firstName"),
            inputLastName = $("#lastName"),
            inputUserEmail = $("#userEmail"),
            inputUserNumber = $("#userNumber"),
            inputCurrentAddress = $("#currentAddress"),
            inputDateOfBirth = $("#dateOfBirthInput"),
            inputSubject = $("#subjectsInput"),
            inputFile = $("#uploadPicture"),
            stateAndCityInput = $("#stateCity-wrapper"),
            clickSubmitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public AuthorizationPage openPage() {
        open("/automation-practice-form");
        classMainHeader.shouldHave(text("Practice Form"));

        return this;
    }

    public AuthorizationPage setName(String firstName) {
        inputFirstName.setValue(firstName);

        return this;
    }

    public AuthorizationPage setLastName(String lastName) {
        inputLastName.setValue(lastName);

        return this;
    }

    public AuthorizationPage setUserEmail(String userEmail) {
        inputUserEmail.setValue(userEmail);

        return this;
    }

    public AuthorizationPage setUserNumber(String userNumber) {
        inputUserNumber.setValue(userNumber);

        return this;
    }

    public AuthorizationPage setUserAdress(String currentAddress) {
        inputCurrentAddress.setValue(currentAddress);

        return this;
    }

    public AuthorizationPage clickRadiButtonGender(String userGender) {
        $(byText(userGender)).click();

        return this;
    }

    public AuthorizationPage clickRadiButtonHobbies(String userHobbies) {
        $(byText(userHobbies)).click();

        return this;
    }

    public AuthorizationPage calendar(String day, String month, String year) {
        inputDateOfBirth.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public AuthorizationPage pressSubject(String subjects) {
        inputSubject.setValue(subjects).pressEnter();

        return this;
    }

    public AuthorizationPage pressSubjectTwo(String subjectTwo) {
        inputSubject.setValue(subjectTwo).pressEnter();

        return this;
    }

    public AuthorizationPage uploadFile(String fileName) {
        inputFile.uploadFromClasspath(fileName);
        ;

        return this;
    }

    public AuthorizationPage setState(String stateName) {
        stateAndCityInput.$("#state").scrollTo().click();
        $(byText(stateName)).click();

        return this;
    }

    public AuthorizationPage setCity(String cityName) {
        stateAndCityInput.$("#city").click();
        $(byText(cityName)).click();

        return this;
    }

    public AuthorizationPage clickSubmit() {
        clickSubmitButton.click();

        return this;
    }

    public AuthorizationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}

