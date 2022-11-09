package pages.header;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CurrencyChanger {
    By currencyDropdown = By.id("form-currency");
    By euro = By.xpath("//button[@name='EUR']");
    By pound = By.xpath("//button[@name='GBP']");
    By dollar = By.xpath("//button[@name='USD']");

    public void changeCurrencyToEuro() {
        $(currencyDropdown).click();
        $(euro).click();
    }

    public void changeCurrencyToPounds() {
        $(currencyDropdown).click();
        $(pound).click();
    }

    public void changeCurrencyToDollars() {
        $(currencyDropdown).click();
        $(dollar).click();
    }
}
