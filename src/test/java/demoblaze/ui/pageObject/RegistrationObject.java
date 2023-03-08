package demoblaze.ui.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.AssertJUnit.assertTrue;

public class RegistrationObject {

    private SelenideElement
    clickToRegistrationButton =  $("#signin2"),
    setName = $("#sign-username"),
    setPassword = $("#sign-password"),
    registerButton = $("button[onclick='register()']");

    public RegistrationObject goToRegistrationForm () {
        clickToRegistrationButton.click();

        return this;
    }

    public RegistrationObject setLogin (String login) {
        setName.setValue(login);

        return this;
    }

    public RegistrationObject setPassword (String password) {
        setPassword.setValue(password);

        return this;
    }

    public RegistrationObject clickToSubmitsBottom() {
        registerButton.click();

        return this;
    }

    public RegistrationObject checkResults () {
        String successfulRegistrationText = switchTo().alert().getText();
        String expectedText = "Sign up successful.";
        assertTrue(successfulRegistrationText.contains(expectedText));

        return this;
    }
}
