package Utils;

import Logic.Generator;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Tests extends BrowserManager{
    final String baseUrl = "http://opencart.qatestlab.net";
    String savedEmail = Generator.nameGenerator()+"@test.com";
    String savedPassword = Generator.passwordGenerator();
    String firstAndLatName = Generator.nameGenerator();
    String phone = Generator.numberGenerator();

    @Test
    public void openRegistrationPageFromTheMainPage() {
        openBrowser(baseUrl);
        MainPage mainPage = new MainPage();
        mainPage.myAccountButton();
        mainPage.registerButton();
        assertEquals(mainPage.getResultText(), "Register Account");
        Selenide.closeWebDriver();
    }

    @Test
    public void registrationOfUser() {
        openBrowser(baseUrl + "/index.php?route=account/register");
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.firstName(firstAndLatName);
        registrationPage.lastName(firstAndLatName);
        registrationPage.email(savedEmail);
        registrationPage.phoneNumber(phone);
        registrationPage.setPassword(savedPassword);
        registrationPage.passwordConfirmation(savedPassword);
        registrationPage.agreeWithSubscription();
        registrationPage.agreeWithPolicy();
        registrationPage.register();
        assertEquals(registrationPage.getResult(), "Your Account Has Been Created!");
    }

    @Test
    public void loginWithRegisteredUser() {
        LoginPage login = new LoginPage();
        try {
            openBrowser(baseUrl + "/index.php?route=account/login");
            login.enterEmail("unique@test.com");
            login.enterPassword("unique1234");
            login.loginButton();
        } catch (Exception e) {
            System.out.println("User with such credentials is not registered");
        }
        assertEquals(login.checkResult(), "My Orders");
        login.logout();
    }

}