package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillStudentRegistrationForm(){
        open("/automation-practice-form");

        //filling name & last name
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");

        //filling contacts
        $("#userEmail").setValue("IvanIvanov@gmail.com");
        $("#userNumber").setValue("89911111111");

        //filling gender
        $("#genterWrapper").$(byText("Male")).click();

        //filling date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1995")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__month").$(byText("3")).click();

        //filling subject
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("c");
        $(byText("Commerce")).click();
        $("[aria-autocomplete=list").sendKeys("Physics");
        $("[aria-autocomplete=list").pressEnter();

        //filling hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //filling picture
        $("#uploadPicture").uploadFromClasspath("selenide.png");

        //filing address
        $("#currentAddress").setValue("Russia, Moscow, Lenina st, 5");

        //scroll to button Submit
        $("#submit").scrollIntoView("{block: 'center'}");

        //filling State and City
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        //check filling
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).closest("tr").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).closest("tr").shouldHave(text("IvanIvanov@gmail.com"));
        $(".table-responsive").$(byText("Gender")).closest("tr").shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).closest("tr").shouldHave(text("8991111111"));
        $(".table-responsive").$(byText("Date of Birth")).closest("tr").shouldHave(text("03 May,1995"));
        $(".table-responsive").$(byText("Subjects")).closest("tr").shouldHave(text("Commerce, Physics"));
        $(".table-responsive").$(byText("Hobbies")).closest("tr").shouldHave(text("Music, Sports"));
        $(".table-responsive").$(byText("Picture")).closest("tr").shouldHave(text("selenide.png"));
        $(".table-responsive").$(byText("Address")).closest("tr").shouldHave(text("Russia, Moscow, Lenina st, 5"));
        $(".table-responsive").$(byText("State and City")).closest("tr").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").scrollIntoView("{block: 'center'}").click();
    }

}
