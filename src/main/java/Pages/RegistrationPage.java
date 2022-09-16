package Pages;

import Logic.Generator;
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
    String savedEmail = "";
    String savedPassword = "";

    public String getSavedEmail() {
        return savedEmail;
    }

    public String getSavedPassword() {
        return savedPassword;
    }

    public void inputUserCredentialsIntoFields() {
        Generator generator = new Generator();
        String generatePassword = generator.passwordGenerator();

        $(firstName).setValue(generator.nameGenerator());
        changeLastNameInputType();
        $(lastName).setValue(generator.nameGenerator());
        savedEmail = String.valueOf($(email).setValue(generator.nameGenerator()+ "@test.com"));
        $(phoneNumber).setValue(generator.numberGenerator());
        $(password).setValue(generatePassword);
        savedPassword = String.valueOf($(passwordConfirmation).setValue(generatePassword));
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
