package testdata;

import models.LoginModel;
import utilities.GenerateFakeMessage;

public class GetNewLoginModel {

    public static LoginModel getCredentials(){
        return LoginModel
                .builder()
                .login(GenerateFakeMessage.getEmail())
                .password(GenerateFakeMessage.getPassword())
                .build();


    }
}
