package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class LoginPageHelper {

    public static final SelenideElement USERNAME = $x("//input[@formcontrolname='username']");
    public static final SelenideElement PASSWORD = $x("//input[@formcontrolname='password']");
    public static final SelenideElement SUBMIT = $x("//button[@type='submit']");
    public static final SelenideElement LOGOUT = $x("//a[contains(@title,'Sign')]");
    public static final SelenideElement MAIN_PAGE = $x("//div[contains(@title, 'Benchmark')]/../../../../../../../..");
    public static final SelenideElement FAILED_MESSAGE = $x("//div[@role='alert']/..");

    public static void setUsername(String username) {
        USERNAME.sendKeys(username);
    }

    public static void setPassword(String password) {
        USERNAME.sendKeys(password);
    }

    public static void login(String username, String password) {
        USERNAME.sendKeys(username);
        PASSWORD.sendKeys(password);
        SUBMIT.click();
    }

    public static void login() {
        USERNAME.sendKeys("selenium_chrome");
        PASSWORD.sendKeys("Axa@Demo");
        SUBMIT.click();
    }
}
