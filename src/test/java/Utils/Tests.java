package Utils;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class Tests {
    String baseUrl = "http://opencart.qatestlab.net";

    @Test
    public void openRegistrationPageFromTheMainPage() {
        open(baseUrl);
        MainPage mainPage = new MainPage();
        mainPage.goToRegistrationPage();
        assertEquals(mainPage.getResultText(), "Register Account");
    }

    @Test
    public void registrationOfUser() {
        open(baseUrl + "/index.php?route=account/register");
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUserCredentialsIntoFields();
        registrationPage.agreeWithSubscription();
        registrationPage.agreeWithPolicy();
        registrationPage.register();
        assertEquals(registrationPage.getResult(), "Your Account Has Been Created!");
    }

    @Test
    public void loginWithRegisteredUser() {
        LoginPage login = new LoginPage();
        try {
            open(baseUrl + "/index.php?route=account/login");
            login.loginToAccount();
        } catch (Exception e) {
            System.out.println("No user credentials are specified");
        }
        assertEquals(login.checkResult(), "My Orders");
        login.logout();
    }

}