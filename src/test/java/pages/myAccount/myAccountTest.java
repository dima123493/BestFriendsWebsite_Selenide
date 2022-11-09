package pages.myAccount;

import logic.Generator;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import pages.LoginPage;
import pages.header.LanguageChanger;
import utils.Navigator;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class myAccountTest {
    final String email = "unique@test.com";

    static LanguageChanger language = new LanguageChanger();

    @BeforeEach
    public void login() {
        LoginPage login = new LoginPage();
        try {
            Navigator.openLoginPage();
            language.changeLanguageToEnglish();
            login.enterEmail(email);
            login.enterPassword("unique1234");
            login.loginButton();
        } catch (Exception e) {
            System.out.println("User with such credentials is not registered");
        }
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    @Test
    public void editMyPersonalDetails() {
        String temporaryEmail = Generator.nameGenerator() + "@test.com";
        EditAccountInfo page = new EditAccountInfo();
        Navigator.openEditAccountInformationPage();
        page.changeFirstName("Dmytro");
        page.changeLastName("Zubenko");
        page.changeEmail(temporaryEmail);
        page.changePhoneNumber(Generator.numberGenerator());
        page.continueButton();
        Navigator.openEditAccountInformationPage();
        assertEquals("Dmytro",page.firstName.toString());
        page.changeEmail(email);
        page.continueButton();
    }

}