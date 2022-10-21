package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgetPasswordPage {
    By email = By.id("input-email");
    By submitButton = By.xpath("//input[@value='Continue']");

    public void email(String emailValue) {
        $(email).setValue(emailValue);
    }

    public void submitButton() {
        $(submitButton).click();
    }
}
