package models;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class RegistrationModel {

    private String firstName;
    private String lastName;
    private String password;
    private String companyName;
    private String address;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String addressAlias;

}
