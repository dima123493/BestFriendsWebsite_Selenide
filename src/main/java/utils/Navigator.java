package utils;

import static com.codeborne.selenide.Selenide.open;

public class Navigator {
    public static final String baseUrl = "http://opencart.qatestlab.net";

    public static void openMainPage() {
        open(baseUrl);
    }

    public static void openRegistrationPage() {
        open(baseUrl + "/index.php?route=account/register");
    }

    public static void openLoginPage() {
        open(baseUrl + "/index.php?route=account/login");
    }

    public static void openForgetPasswordPage() {
        open(baseUrl + "/index.php?route=account/forgotten");
    }

    public static void openEditAccountInformationPage() {
        open(baseUrl + "/index.php?route=account/edit");
    }
}
