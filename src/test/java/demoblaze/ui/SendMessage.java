package demoblaze.ui;

import com.github.javafaker.Faker;
import demoblaze.TestBase;
import demoblaze.ui.pageObject.MessageObject;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SendMessage extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    String email =faker.internet().emailAddress(),
    name = faker.name().firstName(),
    text = faker.lorem().sentence();
    @Owner("Rodichev")
    @Test
    @DisplayName("Проверка отправки сообщения через форму")
    void sendMessage () {
        step("Открываем главную страницу", () -> {
            open(baseUrl);});
        step("Открываем формы для связи", () -> {
            new MessageObject().clickToContactUs();});
        step("Вводим email, имя, текст сообщения", () -> {
            new MessageObject()
                    .setEmail(email)
                    .setName(name)
                    .addText(text)
                    .clickSubmit();});
        step("Проверяем, что появилось сообщение об успешной отправке обращения", () -> {
            new MessageObject().checkResult();});
        }
    }

