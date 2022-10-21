package Utils;

import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BrowserManager {

    @Before
    public static void openBrowser(String url){
        open(url);
    }

    @After
    public void closeBrowser(){
        closeWebDriver();
    }

}
