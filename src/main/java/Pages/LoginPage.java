package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    By registeredUserEmail = By.id("input-email");
    By registeredUserPassword = By.id("input-password");
    By loginButton = By.cssSelector("input[value='Login']");
    By result = By.xpath("//h2[normalize-space()='My Orders']");
    By logout = By.xpath("//a[normalize-space()='Sign Out']");

    public void enterEmail(String email) {
        $(registeredUserEmail).setValue(email);
    }

    public void enterPassword(String password) {
        $(registeredUserPassword).setValue(password);
    }

    public void loginButton() {
        $(loginButton).click();
    }

    public String checkResult() {
      return $(result).getText();
    }

    public void logout() {
        $(logout).hover().click();
    }
}

//RegistrationPage regPage = new RegistrationPage();
//String email = regPage.getSavedEmail();
//email = email.isEmpty() ? "test@tet.com" : email;
// String password = regPage.getSavedPassword();
// password = password.isEmpty() ? "password1234" : password;