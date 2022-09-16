package Logic;

import Pages.RegistrationPage;

import java.util.Objects;

public class SavedCredentials {
    RegistrationPage credentials = new RegistrationPage();
    String email = credentials.getSavedEmail();
    String password = credentials.getSavedPassword();

    public String getEmail() {
        if(!Objects.equals(email, "")) {
            return email;
        }else{
            return email = "test@tet.com";
        }
    }

    public String getPassword() {
        if(!Objects.equals(password, "")) {
        return password;
        }else{
          return password = "password1234";
        }
    }
}
