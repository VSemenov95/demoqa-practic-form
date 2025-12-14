package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private final Faker faker = new Faker();

    public String getRandomState() {
        return faker.options().option(
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan"
        );
    }
    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
    public String setFirstName() {
        return faker.name().firstName();
    }

    public String setLastName() {
        return faker.name().lastName();
    }

    public String setEmail() {
        return faker.internet().emailAddress();
    }

    public String setGender() {
        return faker.options().option("Male","Female","Other");
    }

    public String setPhoneNumber() {
        return String.valueOf(faker.phoneNumber().subscriberNumber(10));
    }

    public String setDay() {
        return String.valueOf(faker.number().numberBetween(1,28));
    }

    public String setMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String setYear() {
        return String.valueOf(faker.number().numberBetween(1900,2024));
    }

    public String setPicture() {
        return faker.options().option("selenide.png","profile.png");
    }

    public String setFullAddress() {
        return faker.address().fullAddress();
    }

    public String setSubjects() {
        return faker.options().option("Arts","Accouting","Biology",
                "Civics","English","Economics","Hindi","History","Maths","Physics",
                "Computer Science","Chemistry","Commerce","Social Studies");
    }

    public String setHobbies() {
        return faker.options().option("Sports","Reading","Music");
    }

}
