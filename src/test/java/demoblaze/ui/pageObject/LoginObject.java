package demoblaze.ui.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginObject {

    private SelenideElement
    loginButton =  $("#login2"),
    setUsername = $("#loginusername"),
    setPassword = $("#loginpassword"),
    submitLoginButton = $("button[onclick='logIn()']");

    public LoginObject openLoginWindow (){
        loginButton.click();

        return this;
    }

    public LoginObject setUsername (String username) {
        setUsername.shouldBe(visible).setValue(username);

        return this;
    }

    public LoginObject setPassword (String password) {
        setPassword.shouldBe(visible).setValue(password);

        return this;
    }

    public LoginObject clickToLogin() {
        submitLoginButton.click();

        return this;
    }

    public LoginObject checkResultSuccessfulLogin () {
        $("#nameofuser").shouldHave(text("Welcome test_qa_16"));

        return this;
    }

    public LoginObject checkResultUnsuccessfulLogin () {
        switchTo().alert().accept();
        $("#logInModal").shouldBe(visible);
        $("#nameofuser").shouldNotBe(visible);

        return this;

    }

}
