package demoblaze.ui;

import com.github.javafaker.Faker;
import demoblaze.TestBase;
import demoblaze.ui.pageObject.RegistrationObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Registration extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    String login =faker.name().firstName(),
            password = faker.funnyName().name();
    @Test
    @DisplayName("Проверка создания нового пользователя")
    void successfulRegistration () {
        step("Открываем главную страницу", () -> {
            open(baseUrl);});
        step("Открываем форму регистрации нового пользователя", () -> {
            new RegistrationObject().goToRegistrationForm();});
        step("Вводим логин и пароль", () -> {
            new RegistrationObject()
                    .setLogin(login)
                    .setPassword(password)
                    .clickToSubmitsBottom();});
        step("Проверяем, что появилось уведомление об успешной регистрации нового пользователя", () -> {
            new RegistrationObject()
                    .checkResults();});
        }
    }

