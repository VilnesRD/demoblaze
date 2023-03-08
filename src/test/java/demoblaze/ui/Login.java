package demoblaze.ui;

import demoblaze.TestBase;
import demoblaze.ui.pageObject.LoginObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Login extends TestBase {
@Test
@DisplayName("Проверка логина с корректными данными пользователя")
    void successfulLogin () {
    step("Открываем главную страницу", () -> {
        open("https://www.demoblaze.com/");});
    step("Открываем окно login", () -> {
        new LoginObject()
                .openLoginWindow();});
    step("Вводим корректные данные пользователя и нажимаем кнопку login", () -> {
        new LoginObject()
                .setUsername("test_qa_16")
                .setPassword("xswqaz123")
                .clickToLogin();});
    step("Проверяем, что на странице отображается информация об аккаунте ", () -> {
        new LoginObject()
                .checkResultSuccessfulLogin();});
    }


    @Test
    @DisplayName("Проверка логина с не корректными данными пользователя")
    void unSuccessfulLogin () {
        open("https://www.demoblaze.com/");
        step("Открываем окно login", () -> {
            new LoginObject()
                    .openLoginWindow();});
        step("Вводим не корректные данные пользователя и нажимаем кнопку login", () -> {
            new LoginObject()
                    .setUsername("12333")
                .setPassword("1233333")
                .clickToLogin();});
        step("Проверяем, что повявилось уведомление об ошибке", () -> {
            new LoginObject()
                .checkResultUnsuccessfulLogin();});

    }
}
