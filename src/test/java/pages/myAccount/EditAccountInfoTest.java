package pages.myAccount;

import com.codeborne.selenide.WebDriverRunner;
import logic.Generator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utils.Navigator;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EditAccountInfoTest {

    @Test
    void editMyPersonalDetailsUsingCookies() {
        EditAccountInfo page = new EditAccountInfo();

        open(Navigator.BASE_URL);
        Cookie cookie = new Cookie("OCSESSID","29e7160758fa598c1c04f456fe");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Navigator.openEditAccountInformationPage();

        page.changeFirstName("Dmytro");
        page.changeLastName("Zubenko");
        page.changePhoneNumber(Generator.numberGenerator());
        page.continueButton();
        Navigator.openEditAccountInformationPage();
        assertEquals("Dmytro",page.getFirstName());
    }

}