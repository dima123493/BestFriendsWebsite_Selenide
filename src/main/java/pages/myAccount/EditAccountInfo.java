package pages.myAccount;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditAccountInfo {
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phoneNumber = By.id("input-telephone");
    By continueButton = By.xpath("//input[@type='submit']");
    By backButton = By.xpath("//a[@class='btn btn-default']");

    public void changeFirstName(String name) {
        $(firstName).click();
        $(firstName).setValue(name);
    }

    public void changeLastName(String surname) {
        $(lastName).click();
        $(lastName).setValue(surname);
    }

    public void changeEmail(String mail) {
        $(email).click();
        $(email).setValue(mail);
    }

    public void changePhoneNumber(String phone) {
        $(phoneNumber).click();
        $(phoneNumber).setValue(phone);
    }

    public void backButton() {
        $(backButton).click();
    }

    public void continueButton() {
        $(continueButton).click();
    }
}
