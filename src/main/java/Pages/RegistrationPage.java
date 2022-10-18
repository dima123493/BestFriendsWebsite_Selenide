package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phoneNumber = By.id("input-telephone");
    By password = By.id("input-password");
    By passwordConfirmation = By.id("input-confirm");
    By subscribeRadioButton = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]");
    By privacyPolicy = By.xpath("//input[@name='agree']");
    By submitButton = By.cssSelector("input[value='Continue']");
    By result = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

    public void firstName(String firstNameValue) {
        $(firstName).setValue(firstNameValue);
    }
    public void lastName(String lastNameValue) {
        changeLastNameInputType();
        $(lastName).setValue(lastNameValue);
    }

    public void email(String emailValue) {
        $(email).setValue(emailValue);
    }

    public void phoneNumber(String phone) {
        $(phoneNumber).setValue(phone);
    }

    public void setPassword(String passwordValue) {
        $(password).setValue(passwordValue);
    }

    public void passwordConfirmation(String passwordValue) {
        $(passwordConfirmation).setValue(passwordValue);
    }

    public void agreeWithSubscription() {
        $(subscribeRadioButton).hover().click();
    }

    public void agreeWithPolicy() {
        $(privacyPolicy).hover().click();
    }

    public void register() {
        $(submitButton).hover().click();
    }
    public String getResult() {
        return $(result).getText();
    }
    public void changeLastNameInputType() {
        executeJavaScript("document.getElementById('input-lastname').setAttribute('type', 'string');", "");
    }

}
