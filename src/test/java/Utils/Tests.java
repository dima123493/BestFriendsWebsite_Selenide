package Utils;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class Tests {

    @Test
    public void openRegistrationPage() {
        open("http://opencart.qatestlab.net");
        $(By.xpath("//span[contains(text(),'My Account')]")).click();
        $(By.xpath("//a[normalize-space()='Register']")).click();
        String result = $(By.xpath("//h1[normalize-space()='Register Account']")).getText();
        assertEquals(result, "Register Account");
    }

    @Test
    public void registrationOfUser() {
        Generator generator = new Generator();
        String password = generator.nameGenerator();
        open("http://opencart.qatestlab.net/index.php?route=account/register");
        $(By.id("input-firstname")).setValue(generator.nameGenerator());
        executeJavaScript("document.getElementById('input-lastname').setAttribute('type', 'string');", "");
        $(By.id("input-lastname")).setValue(generator.nameGenerator());
        $(By.id("input-email")).setValue(generator.nameGenerator() + "@test.com");
        $(By.id("input-telephone")).setValue("+" + generator.numberGenerator());
        $(By.id("input-password")).setValue(password);
        $(By.id("input-confirm")).setValue(password);
        $(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]")).hover().click();
        $(By.xpath("//input[@name='agree']")).hover().click();
        $(By.cssSelector("input[value='Continue']")).hover().click();
        String result = $(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
        assertEquals(result, "Your Account Has Been Created!");
    }


}