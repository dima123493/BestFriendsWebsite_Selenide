package Pages;

import Logic.SavedCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    By registeredUserEmail = By.id("input-email");
    By registeredUserPassword = By.id("input-password");
    By loginButton = By.cssSelector("input[value='Login']");
    By result = By.xpath("//h2[normalize-space()='My Orders']");

    By logout = By.xpath("//a[normalize-space()='Sign Out']");

    public void loginToAccount() {
        SavedCredentials credentials = new SavedCredentials();
        $(registeredUserEmail).setValue(credentials.getEmail());
        $(registeredUserPassword).setValue(credentials.getPassword());
        $(loginButton).click();
    }
    public String checkResult() {
      return $(result).getText();
    }

    public void logout() {
        $(logout).hover().click();
    }
}
