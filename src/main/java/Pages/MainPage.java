package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    By myAccountButton = By.xpath("//span[contains(text(),'My Account')]");
    By registerButton = By.xpath("//a[normalize-space()='Register']");
    By result = By.xpath("//h1[normalize-space()='Register Account']");

    public void goToRegistrationPage() {
        $(myAccountButton).click();
        $(registerButton).click();
    }

    public String getResultText() {
       return $(result).getText();
    }

}