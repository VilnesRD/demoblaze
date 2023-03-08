package demoblaze.ui;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoblaze.ui.pageObject.RegistrationObject;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class Registration extends TestBase{
    Faker faker = new Faker(new Locale("en"));
    String login =faker.name().firstName(),
            password = faker.funnyName().name();
    @Test
    void successfulRegistration () {
        open("https://www.demoblaze.com/");
        new RegistrationObject()
                .goToRegistrationForm()
                .setLogin(login)
                .setPassword(password)
                .clickToSubmitsBottom()
                .checkResults();
    }
}
