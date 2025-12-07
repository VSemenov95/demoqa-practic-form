package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Проверка регистрации с заполнением всех полей")
    void successfulRegistrationTest() {
        registrationPage
            .openPage()

        //filling out the registration form
            .setFirstName("Ivan")
            .setLastName("Ivanov")
            .setEmail("IvanIvanov@gmail.com")
            .setGender("Male")
            .setUserNumber("8999999999")
            .setDateOfBirth("3","May","1995")
            .setSubject("c","Commerce")
            .setHobbies("Music")
            .uploadPicture("selenide.png")
            .setCurrentAddress("Russia, Moscow, Lenina st, 5")
            .scrollToSubmitButton("{block: 'center'}")
            .setStateAndCity("Haryana","Karnal")
            .clickSubmitButton();

        //check the result from the table
        registrationPage
             .checkResult("Student Name", "Ivan Ivanov")
             .checkResult("Student Email", "Ivanov")
             .checkResult("Gender", "Male")
             .checkResult("Mobile", "8999999999")
             .checkResult("Date of Birth", "03 May,1995")
             .checkResult("Subjects", "Commerce")
             .checkResult("Hobbies", "Music")
             .checkResult("Picture", "selenide.png")
             .checkResult("Address", "Russia, Moscow, Lenina st, 5")
             .checkResult("State and City", "Haryana Karnal")
        //closing modal window with a table
             .pressCloseButton("{block: 'center'}");
    }

    @Test
    @DisplayName("Проверка регистрации с заполнением только обязательных полей")
    void successfullFillingRequiredFieldsForm() {
        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("8999999999")
                .scrollToSubmitButton("{block: 'center'}")
                .clickSubmitButton();

        registrationPage
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999999999")
                .pressCloseButton("{block: 'center'}");
    }

    @Test
    @DisplayName("Проверка с незаполненным полем First Name")

    void checkRegistrationWithoutFirstName() {
        registrationPage
                .openPage()
                .setFirstName("")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("8999999999")
                .scrollToSubmitButton("{block: 'center'}")
                .clickSubmitButton()
                .checkTitleForm();
    }
}

