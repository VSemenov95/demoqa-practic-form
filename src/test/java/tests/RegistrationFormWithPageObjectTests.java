package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;


class RegistrationFormWithPageObjectTests extends TestBase{
       RegistrationPage registrationPage = new RegistrationPage();
       TestData testData = new TestData();

    @Test
    @DisplayName("Проверка регистрации с заполнением всех полей")
    void successfulRegistrationTest() {

        registrationPage
            .openPage()
            .removeBanner()
        //filling out the registration form
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setUserNumber(phoneNumber)
            .setDateOfBirth(day,month,year)
            .setSubject(subjects)
            .setHobbies(hobbies)
            .uploadPicture(picture)
            .setCurrentAddress(fullAddress)
            .setStateAndCity(testData.state, testData.city)
            .clickSubmitButton();

        //check the result from the table
        registrationPage
             .checkResult("Student Name", fullName)
             .checkResult("Student Email", email)
             .checkResult("Gender", gender)
             .checkResult("Mobile", phoneNumber)
             .checkResult("Date of Birth", dateBirth)
             .checkResult("Subjects", subjects)
             .checkResult("Hobbies", hobbies)
             .checkResult("Picture", picture)
             .checkResult("Address", fullAddress)
             .checkResult("State and City", testData.state + " " + testData.city);
        //closing modal window with a table
    }

    @Test
    @DisplayName("Проверка регистрации с заполнением только обязательных полей")
    void successfulFillingRequiredFieldsForm() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmitButton();

        registrationPage
                .checkResult("Student Name", fullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    @DisplayName("Проверка с незаполненным полем First Name")

    void checkRegistrationWithoutFirstName() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName("")
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmitButton()
                .checkTitleForm();
    }
}

