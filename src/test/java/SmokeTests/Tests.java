package SmokeTests;

import logic.Generator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.ForgetPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.header.LanguageChanger;
import utils.Navigator;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    String savedEmail = Generator.nameGenerator() + "@test.com";
    String savedPassword = Generator.passwordGenerator();
    String firstName = Generator.nameGenerator();
    String lastName = Generator.nameGenerator();
    String phone = Generator.numberGenerator();
    LanguageChanger language = new LanguageChanger();

// open new tab instead of new session

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void openRegistrationPageFromTheMainPage() {
        Navigator.openMainPage();
        MainPage mainPage = new MainPage();
        language.changeLanguageToEnglish();
        mainPage.myAccountButton();
        mainPage.registerButton();
        assertEquals("Register Account", mainPage.getResultText());
    }

    @Test
    void registrationOfUser() {
        Navigator.openRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage();
        language.changeLanguageToEnglish();
        registrationPage.firstName(firstName);
        registrationPage.lastName(lastName);
        registrationPage.email(savedEmail);
        registrationPage.phoneNumber(phone);
        registrationPage.setPassword(savedPassword);
        registrationPage.passwordConfirmation(savedPassword);
        registrationPage.agreeWithSubscription();
        registrationPage.agreeWithPolicy();
        registrationPage.register();
        assertEquals("Your Account Has Been Created!", registrationPage.getResult());
    }

    @Test
    void loginWithRegisteredUser() {
        LoginPage login = new LoginPage();
        try {
            Navigator.openLoginPage();
            language.changeLanguageToEnglish();
            login.enterEmail("unique@test.com");
            login.enterPassword("unique1234");
            login.loginButton();
        } catch (Exception e) {
            System.out.println("User with such credentials is not registered");
        }
        assertEquals("My Orders", login.checkResult());
        login.logout();
    }

    @Test
    void restoreForgottenPassword() {
        Navigator.openForgetPasswordPage();
        language.changeLanguageToEnglish();
        ForgetPasswordPage restorePassword = new ForgetPasswordPage();
        restorePassword.email("unique@test.com");
        restorePassword.submitButton();
        LoginPage login = new LoginPage();
        assertEquals("Returning Customer", login.returningCustomerTitle());
    }

    @Test
    void subscribeToStoreNews() {
        MainPage mainPage = new MainPage();
        Navigator.openMainPage();
        language.changeLanguageToEnglish();
        mainPage.newsLetterSubscriptionField(Generator.nameGenerator() + "@test.com");
        mainPage.newsLetterSubscriptionButton();
        assertEquals("You have successfully subscribed", mainPage.successSubscriptionTitle());
    }

    @Test
    void invalidEmailSub() {
        MainPage mainPage = new MainPage();
        Navigator.openMainPage();
        language.changeLanguageToEnglish();
        mainPage.newsLetterSubscriptionField("invalidEmail.com");
        mainPage.newsLetterSubscriptionButton();
        assertEquals("Please enter a valid e-mail!", mainPage.failedSubscriptionTitle());
    }
}