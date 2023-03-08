package demoblaze.ui;

import com.github.javafaker.Faker;
import demoblaze.ui.pageObject.MessageObject;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class SendMessage extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    String email =faker.internet().emailAddress(),
    name = faker.name().firstName(),
    text = faker.lorem().sentence();
    @Test
    void sendMessage () {
        open("https://www.demoblaze.com/");
        new MessageObject()
                .clickToContactUs()
                .setEmail(email)
                .setName(name)
                .addText(text)
                .clickSubmit()
                .checkResult();
    }
}
