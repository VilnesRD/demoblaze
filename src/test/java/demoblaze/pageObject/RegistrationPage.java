package demoblaze.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.AssertJUnit.assertTrue;

public class RegistrationPage {

    private final SelenideElement
    clickToRegistrationButton =  $("#signin2"),
    setName = $("#sign-username"),
    setPassword = $("#sign-password"),
    registerButton = $("button[onclick='register()']");

    public RegistrationPage goToRegistrationForm () {
        clickToRegistrationButton.click();

        return this;
    }

    public RegistrationPage setLogin (String login) {
        setName.shouldBe(visible).setValue(login);

        return this;
    }

    public RegistrationPage setPassword (String password) {
        setPassword.shouldBe(visible).setValue(password);

        return this;
    }

    public RegistrationPage clickToSubmitsBottom() {
        registerButton.click();

        return this;
    }

    public RegistrationPage checkResults () {
        String successfulRegistrationText = switchTo().alert().getText();
        String expectedText = "Sign up successful.";
        assertTrue(successfulRegistrationText.contains(expectedText));

        return this;
    }
}
