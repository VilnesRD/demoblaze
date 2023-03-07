package demoblaze.ui;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class SendMessage {
    Faker faker = new Faker(new Locale("en"));
    String email =faker.internet().emailAddress(),
    name = faker.name().firstName(),
    text = faker.lorem().sentence();
    @Test
    void sendMessage () {
        open("https://www.demoblaze.com/");
        $$("ul.navbar-nav li").get(1).click();
        $("#recipient-email").setValue(email);
        $("#recipient-name").setValue(name);
        $("#message-text").setValue(text);
        $("button[onclick='send()']").click();
        String alertText = switchTo().alert().getText();
        String expectedText = "Thanks for the message!!";
        assertTrue(alertText.contains(expectedText));
        Configuration.holdBrowserOpen = true;


    }
}
