package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage();

        //filling out the registration form
        registrationPage.setFirstName("Ivan");
        registrationPage.setLastName("Ivanov");
        registrationPage.setEmail("IvanIvanov@gmail.com");
        registrationPage.setGender("Male");
        registrationPage.setUserNumber("89911111111");
        registrationPage.setDateOfBirth("3","May","1995");
        registrationPage.setSubject("c","Commerce");
        registrationPage.setHobbies("Music");
        registrationPage.uploadPicture("selenide.png");
        registrationPage.setCurrentAddress("Russia, Moscow, Lenina st, 5");
        registrationPage.scrollToSubmitButton("{block: 'center'}");
        registrationPage.setStateAndCity("Haryana","Karnal");
        registrationPage.clickSubmitButton();

        //check the result from the table
        registrationPage.checkResult("Student Name","Ivan Ivanov");
        registrationPage.checkResult("Student Email","Ivanov");
        registrationPage.checkResult("Gender","Male");
        registrationPage.checkResult("Mobile","89911111111");
        registrationPage.checkResult("Date of Birth","03 May,1995");
        registrationPage.checkResult("Subjects","Commerce");
        registrationPage.checkResult("Hobbies","Music");
        registrationPage.checkResult("Picture","selenide.png");
        registrationPage.checkResult("Address","Russia, Moscow, Lenina st, 5");
        registrationPage.checkResult("State and City","Haryana Karnal");

        //closing modal window with a table
        registrationPage.pressCloseButton("{block: 'center'}");
    }
}

