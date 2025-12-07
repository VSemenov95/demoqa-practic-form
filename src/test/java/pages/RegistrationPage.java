package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $(".subjects-auto-complete__input"),
            subjectsDropDown = $("[aria-autocomplete=list"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            selectPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            submitButton = $("#submit"),
            stateDropDown =  $("#state"),
            cityDropDown =  $("#city"),
            closeButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }


    public RegistrationPage setSubject(String input, String choice) {
        subjectsInput.click();
        subjectsDropDown.sendKeys(input);
        $(byText(choice)).click();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesCheckBox.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        selectPicture.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);

        return this;
    }

    public RegistrationPage scrollToSubmitButton(String location) {
        submitButton.scrollIntoView(location);

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city){
        stateDropDown.click();
        $(byText(state)).click();
        cityDropDown.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public RegistrationPage pressCloseButton(String location) {
        closeButton.scrollIntoView(location).click();

        return this;
    }
}