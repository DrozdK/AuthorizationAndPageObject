package tests;

import com.codeborne.selenide.Selenide;
import enums.Usernames;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static enums.Passwords.SELENIUM_PASSWORD;
import static enums.Usernames.WRONG_USERNAME;
import static helpers.Helper.*;
import static helpers.LoginPageHelper.*;

public class LoginPageTest {

    @BeforeEach
    public void setUp(){
        setConfiguration();
        Selenide.open(getUrl());
    }

    @Test
    public void shouldButtonBeInactiveWithoutEnterInformation(){
        //then
        SUBMIT.shouldHave(attribute("disabled"));
    }

    @Test
    public void shouldButtonBeInactiveWhenOnlyUsernameEnter(){
        //when
        setUsername(Usernames.MAIN_USERNAME.getUsername());
        //then
        SUBMIT.shouldHave(attribute("disabled"));
    }

    @Test
    public void shouldButtonBeInactiveWhenOnlyPasswordEnter(){
        //when
        setPassword(SELENIUM_PASSWORD.getPassword());
        //then
        SUBMIT.shouldHave(attribute("disabled"));
    }

    @Test
    public void shouldSuccessLogin() {
        //when
        login();
        //then
        MAIN_PAGE.shouldBe(visible);
    }

    @Test
    public void shouldFailedLogin() {
        //when
        login(WRONG_USERNAME.getUsername(), SELENIUM_PASSWORD.getPassword());
        //then
        FAILED_MESSAGE.shouldBe(visible);
    }

    @Test
    public void shouldLogout() {
        //when
        login();
        LOGOUT.click();
        //then
        SUBMIT.shouldBe(visible);
    }

    @AfterEach
    public void tearDown(){
        closeBrowser();
    }
}
