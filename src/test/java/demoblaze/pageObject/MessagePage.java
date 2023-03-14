package demoblaze.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class MessagePage {

    private final SelenideElement
    contactUsButton = $$("ul.navbar-nav li").get(1),
    setEmail = $("#recipient-email"),
    setName = $("#recipient-name"),
    textArea =  $("#message-text"),
            submitButton = $("button[onclick='send()']");

    public MessagePage clickToContactUs () {
        contactUsButton.click();

        return this;
    }

    public MessagePage setEmail (String email) {
        setEmail.shouldBe(visible).setValue(email);

        return this;
    }

    public MessagePage setName (String name) {
        setName.setValue(name);

        return this;
    }

    public MessagePage addText (String text) {
        textArea.setValue(text);

        return this;
    }

    public MessagePage clickSubmit () {
        submitButton.click();

        return this;
    }

    public MessagePage checkResult () {
        String alertText = switchTo().alert().getText();
        String expectedText = "Thanks for the message!!";
        assertTrue(alertText.contains(expectedText));

        return this;
    }

}
