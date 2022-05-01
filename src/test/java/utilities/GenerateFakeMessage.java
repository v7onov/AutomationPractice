package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        Faker faker = new Faker();
        return faker.funnyName().name();
    }

    public static String getFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getLastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String getCompanyName(){
        Faker faker = new Faker();
        return faker.company().name();
    }

    public static String getAddress(){
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }

    public static String getCity(){
        Faker faker = new Faker();
        return faker.address().cityName();
    }

    public static String getZipCode(){
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String getPhoneNumber(){
        Faker faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }

    public static String getAddressAlias(){
        Faker faker = new Faker();
        return faker.funnyName().name();
    }

}