package utilities;

import com.github.javafaker.Faker;
import lombok.ToString;

public class GenerateFakeMessage {

    public static String getAccountName() {
        Faker faker = new Faker();
        return faker.beer().name();
    }

    public static String getPhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public static String getFax() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public static String getWebsite() {
        Faker faker = new Faker();
        return faker.internet().domainName();
    }

    public static String getEmployees() {
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(20, 5000));
    }

    public static String getRevenue() {
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(20, 5000));
    }

    public static String getDescription() {
        Faker faker = new Faker();
        return faker.rickAndMorty().quote();
    }

    public static String getBillingStreet() {
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }

    public static String getBillingCity() {
        Faker faker = new Faker();
        return faker.address().city();
    }

    public static String getBillingZipCode() {
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String getBillingState() {
        Faker faker = new Faker();
        return faker.address().state();
    }

    public static String getBillingCountry() {
        Faker faker = new Faker();
        return faker.address().country();
    }


}
