package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$x;
import static helpers.LoginPageHelper.login;

public class Helper {

    public static void setConfiguration() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.timeout = 60000;
    }

    public static String getUrl() {
        return "http://app.tca.deltixuat.com";
    }

    public static void goToTheMainPage() {
        setConfiguration();
        Selenide.open(getUrl());
        login();
    }

    public static void clickToTheButtonMenu(String name){
        $x("//div[@title='"+name+"']/..").click();
    }

    public static void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}
