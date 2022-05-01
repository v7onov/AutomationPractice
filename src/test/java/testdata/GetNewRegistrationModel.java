package testdata;

import models.RegistrationModel;
import utilities.GenerateFakeMessage;

public class GetNewRegistrationModel {

    public static RegistrationModel getRegistrationModelWithAllFields(){
        return RegistrationModel
                .builder()
                .firstName(GenerateFakeMessage.getFirstName())
                .lastName(GenerateFakeMessage.getLastName())
                .password(GenerateFakeMessage.getPassword())
                .companyName(GenerateFakeMessage.getCompanyName())
                .address(GenerateFakeMessage.getAddress())
                .city(GenerateFakeMessage.getCity())
                .zipCode(GenerateFakeMessage.getZipCode())
                .phoneNumber(GenerateFakeMessage.getPhoneNumber())
                .addressAlias(GenerateFakeMessage.getAddressAlias())
                .build();
    }
}
