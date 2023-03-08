package demoblaze.ui.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class MessageObject {

    private SelenideElement
    contactUsButton = $$("ul.navbar-nav li").get(1),
    setEmail = $("#recipient-email"),
    setName = $("#recipient-name"),
    textArea =  $("#message-text"),
            submitButton = $("button[onclick='send()']");

    public MessageObject clickToContactUs () {
        contactUsButton.click();

        return this;
    }

    public MessageObject setEmail (String email) {
        setEmail.setValue(email);

        return this;
    }

    public MessageObject setName (String name) {
        setName.setValue(name);

        return this;
    }

    public MessageObject addText (String text) {
        textArea.setValue(text);

        return this;
    }

    public MessageObject clickSubmit () {
        submitButton.click();

        return this;
    }

    public MessageObject checkResult () {
        String alertText = switchTo().alert().getText();
        String expectedText = "Thanks for the message!!";
        assertTrue(alertText.contains(expectedText));

        return this;
    }

}
