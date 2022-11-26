package pages.myAccount;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Newsletter {

    By subscribeYes = By.xpath("//label[@for='newsletter1']");
    By subscribeNo = By.xpath("//label[@for='newsletter0']");
    By continueButton = By.xpath("//input[@type='submit']");
    By backButton = By.xpath("//a[@class='btn btn-default']");

    public void subscribeYes() {
        $(subscribeYes).click();
        $(continueButton).click();
    }

    public void subscribeNo() {
        $(subscribeNo).click();
        $(continueButton).click();
    }

    public void backButton() {
        $(backButton).click();
    }

    public boolean subscribeYesCheck() {
       return $(subscribeYes).isSelected();
    }

    public boolean subscribeNoCheck() {
       return $(subscribeNo).isSelected();
    }
}
