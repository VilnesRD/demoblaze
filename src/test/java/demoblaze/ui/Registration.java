package demoblaze.ui;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Registration extends TestBase{
    Faker faker = new Faker(new Locale("en"));
    String login =faker.name().firstName(),
            password = faker.funnyName().name();
    @Test
    void successfulRegistration () {
        open("https://www.demoblaze.com/");
        $("#signin2").click();
        $("#sign-username").setValue(login);
        $("#sign-password").setValue(password);
        $("button[onclick='register()']").click();
    }
}
