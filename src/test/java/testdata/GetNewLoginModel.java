package testdata;

import models.LoginModel;
import utilities.GenerateFakeMessage;
import utilities.PropertiesManager;

public class GetNewLoginModel {

    public static LoginModel getCredentials(){
        PropertiesManager propertiesManager = new PropertiesManager();
        return LoginModel
                .builder()
                .login(propertiesManager.get("EMAIL"))
                .password(propertiesManager.get("PASSWORD"))
                .build();
    }
}
