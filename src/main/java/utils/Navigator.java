package utils;

import static com.codeborne.selenide.Selenide.open;

public class Navigator {
    public static final String BASE_URL = "http://opencart.qatestlab.net";

    public static void openMainPage() {
        open(BASE_URL);
    }

    public static void openRegistrationPage() {
        open(BASE_URL + "/index.php?route=account/register");
    }

    public static void openLoginPage() {
        open(BASE_URL + "/index.php?route=account/login");
    }

    public static void openForgetPasswordPage() {
        open(BASE_URL + "/index.php?route=account/forgotten");
    }

    public static void openEditAccountInformationPage() {
        open(BASE_URL + "/index.php?route=account/edit");
    }

    public static void openNewsletterSubscriptionPage() {
        open(BASE_URL + "/index.php?route=account/newsletter");
    }
}
