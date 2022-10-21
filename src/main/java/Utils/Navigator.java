package Utils;

public class Navigator extends BrowserManager {
    static final String baseUrl = "http://opencart.qatestlab.net";

    public static void openMainPage() {
        openBrowser(baseUrl);
    }

    public static void openRegistrationPage() {
        openBrowser(baseUrl + "/index.php?route=account/register");
    }

    public static void openLoginPage() {
        openBrowser(baseUrl + "/index.php?route=account/login");
    }

    public static void openForgetPasswordPage() {
        openBrowser(baseUrl + "/index.php?route=account/forgotten");
    }
}
