package Utils;

import Logic.Generator;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Tests {

    String savedEmail = Generator.nameGenerator() + "@test.com";
    String savedPassword = Generator.passwordGenerator();
    String firstAndLatName = Generator.nameGenerator();
    String phone = Generator.numberGenerator();

    @Test
    public void openRegistrationPageFromTheMainPage() {
        Navigator.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.myAccountButton();
        mainPage.registerButton();
        assertEquals(mainPage.getResultText(), "Register Account");
        Selenide.closeWebDriver();
    }

    @Test
    public void registrationOfUser() {
        Navigator.openRegistrationPage();
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
            Navigator.openLoginPage();
            login.enterEmail("unique@test.com");
            login.enterPassword("unique1234");
            login.loginButton();
        } catch (Exception e) {
            System.out.println("User with such credentials is not registered");
        }
        assertEquals(login.checkResult(), "My Orders");
        login.logout();
    }

    @Test
    public void restoreForgottenPassword() {
        ForgetPasswordPage restorePassword = new ForgetPasswordPage();
        Navigator.openForgetPasswordPage();
        restorePassword.email("unique@test.com");
        restorePassword.submitButton();
        LoginPage login = new LoginPage();
        assertEquals("Returning Customer", login.returningCustomerTitle());
    }

    @Test
    public void subscribeToStoreNews() {
        MainPage mainPage = new MainPage();
        Navigator.openMainPage();
        mainPage.newsLetterSubscriptionField(savedEmail);
        mainPage.newsLetterSubscriptionButton();
        assertEquals("You have successfully subscribed", mainPage.successSubscriptionTitle());
    }

    @Test
    public void invalidEmailSub() {
        MainPage mainPage = new MainPage();
        Navigator.openMainPage();
        mainPage.newsLetterSubscriptionField("invalidEmail.com");
        mainPage.newsLetterSubscriptionButton();
        assertEquals("Please enter a valid e-mail!", mainPage.failedSubscriptionTitle());
    }
}