package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    By myAccountButton = By.xpath("//*[@id=\"top-links\"]/ul/li/span/span");
    By registerButton = By.xpath("//*[@id=\"top-links\"]//li[1]/a");
    By result = By.xpath("//h1[normalize-space()='Register Account']");
    By newsLetterSubscriptionField = By.id("input-zemez-newsletter-email");
    By newsLetterSubscriptionButton = By.id("zemez-newsletter-button");
    By successSubscription = By.xpath("//*[@id=\"zemez-newsletter_success\"]");
    By failedSubscription = By.xpath("//*[@id=\"zemez-newsletter_error\"]");

    public void myAccountButton() {
        $(myAccountButton).click();
    }

    public void registerButton() {
        $(registerButton).click();
    }

    public String getResultText() {
        return $(result).getText();
    }

    public void newsLetterSubscriptionField(String email) {
        $(newsLetterSubscriptionField).click();
        $(newsLetterSubscriptionField).setValue(email);
    }

    public void newsLetterSubscriptionButton() {
        $(newsLetterSubscriptionButton).click();
    }

    public String successSubscriptionTitle() {
        return $(successSubscription).shouldBe(Condition.visible).getText();
    }

    public String failedSubscriptionTitle() {
        return $(failedSubscription).shouldBe(Condition.visible).getText();
    }
}