package pages.header;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LanguageChanger {
    By changeLanguageTo = By.id("form-language");
    By english = By.xpath("//button[@name='en-gb']");
    By russian = By.xpath("//button[@name='ru-ru']");
    By german = By.xpath("//button[@name='de-DE']");

    public void changeLanguageToEnglish() {
        $(changeLanguageTo).click();
        $(english).click();
    }
    public void changeLanguageToRussian() {
        $(changeLanguageTo).click();
        $(russian).click();
    }
    public void changeLanguageToGerman() {
        $(changeLanguageTo).click();
        $(german).click();
    }
}
