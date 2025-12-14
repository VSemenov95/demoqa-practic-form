package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;


public class TestData {
    static Faker faker = new Faker();
     RandomUtils randomUtils = new RandomUtils();


    static String firstName = faker.name().firstName(),
                  lastName = faker.name().lastName(),
                  fullName = firstName + " " + lastName,
                  email = faker.internet().emailAddress(),
                  gender = faker.options().option("Male","Female","Other"),
                  phoneNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10)),
                  day = String.valueOf(faker.number().numberBetween(1,28)),
                  month = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"),
                  year = String.valueOf(faker.number().numberBetween(1900,2024)),
                  dateBirth = day + " " + month + "," + year,
                  picture = faker.options().option("selenide.png","profile.png"),
                  fullAddress = faker.address().fullAddress(),
                  subjects = faker.options().option("Arts","Accouting","Biology",
                          "Civics","English","Economics","Hindi","History","Maths","Physics",
                          "Computer Science","Chemistry","Commerce","Social Studies"),
                  hobbies = faker.options().option("Sports","Reading","Music");
            String state = randomUtils.getRandomState(),
                    city = randomUtils.getRandomCity(state);






}
