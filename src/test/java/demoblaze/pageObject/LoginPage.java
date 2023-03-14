package demoblaze.pageObject;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {

    private final SelenideElement
    loginButton =  $("#login2"),
    setUsername = $("#loginusername"),
    setPassword = $("#loginpassword"),
    submitLoginButton = $("button[onclick='logIn()']");

    public LoginPage openLoginWindow (){
        loginButton.click();

        return this;
    }

    public LoginPage setUsername (String username) {
        setUsername.shouldBe(visible, Duration.ofSeconds(6)).setValue(username);

        return this;
    }

    public LoginPage setPassword (String password) {
        setPassword.shouldBe(visible, Duration.ofSeconds(6)).setValue(password);

        return this;
    }

    public LoginPage clickToLogin() {
        submitLoginButton.click();

        return this;
    }

    public LoginPage checkResultSuccessfulLogin (String expectedText) {
        $("#nameofuser").shouldHave(text(expectedText));

        return this;
    }

    public LoginPage checkResultUnsuccessfulLogin () {
        switchTo().alert().accept();
        $("#logInModal").shouldBe(visible);
        $("#nameofuser").shouldNotBe(visible);

        return this;

    }

}
