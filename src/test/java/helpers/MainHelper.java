package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.LoginPageHelper.login;

public class MainHelper {

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

    public static void openDropDown(String name){
        $x("//div[text()='"+name+"']/..//deltix-ng-autocomplete/div").click();
    }

    public static void selectByValue(String name, String value) {
        openDropDown(name);
        $x("//div[@class='autocomplete-dropdown-menu-wrapper']//ul//li[@title='"+value+"']").click();
    }

    public static void getDropDownTitle(String value) {
        $x("//input[@title='"+value+"']").shouldBe(visible);
    }

    public static void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
        Selenide.closeWebDriver();
    }
}
