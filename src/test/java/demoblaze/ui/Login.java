package demoblaze.ui;

import demoblaze.TestBase;
import demoblaze.pageObject.LoginPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Login extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Owner("Rodichev")
    @Test
    @DisplayName("Проверка логина с корректными данными пользователя")
    void successfulLogin () {
    step("Открываем главную страницу", () -> {
        open(baseUrl);});
    step("Открываем окно login", () -> {
        loginPage
                .openLoginWindow();});
    step("Вводим корректные данные пользователя и нажимаем кнопку login", () -> {
        loginPage
                .setUsername("test_qa_16")
                .setPassword("xswqaz123")
                .clickToLogin();});
    step("Проверяем, что на странице отображается информация об аккаунте ", () -> {
        loginPage
                .checkResultSuccessfulLogin();});
    }

    @Owner("Rodichev")
    @Test
    @DisplayName("Проверка логина с не корректными данными пользователя")
    void unSuccessfulLogin () {
        open(baseUrl);
        step("Открываем окно login", () -> {
            loginPage
                    .openLoginWindow();});
        step("Вводим не корректные данные пользователя и нажимаем кнопку login", () -> {
            loginPage
                    .setUsername("12333")
                .setPassword("1233333")
                .clickToLogin();});
        step("Проверяем, что повявилось уведомление об ошибке", () -> {
            loginPage
                .checkResultUnsuccessfulLogin();});

    }
}
