package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    By registeredUserEmail = By.id("input-email");
    By registeredUserPassword = By.id("input-password");
    By loginButton = By.xpath("//input[@type=\"submit\"]");
    By result = By.xpath("//h2[normalize-space()='My Orders']");
    By logout = By.xpath("//a[normalize-space()='Sign Out']");
    By returningCustomerTitle = By.xpath("//h2[normalize-space()='Returning Customer']");

    public void enterEmail(String email) {
        $(registeredUserEmail).click();
        $(registeredUserEmail).setValue(email);
    }

    public void enterPassword(String password) {
        $(registeredUserPassword).click();
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

    public String returningCustomerTitle() {
        return $(returningCustomerTitle).getText();
    }
}

//RegistrationPage regPage = new RegistrationPage();
//String email = regPage.getSavedEmail();
//email = email.isEmpty() ? "test@tet.com" : email;
// String password = regPage.getSavedPassword();
// password = password.isEmpty() ? "password1234" : password;