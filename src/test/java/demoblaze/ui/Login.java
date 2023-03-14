package demoblaze.ui;

import com.codeborne.selenide.Config;
import demoblaze.TestBase;
import demoblaze.config.WebDriverConfig;
import demoblaze.pageObject.LoginPage;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Login extends TestBase {
    LoginPage loginPage = new LoginPage();
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class,System.getProperties());

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
                .setUsername(config.getUserLogin())
                .setPassword(config.userPassword())
                .clickToLogin();});
    step("Проверяем, что на странице отображается информация об аккаунте ", () -> {
        loginPage
                .checkResultSuccessfulLogin("Welcome test_qa_16");});
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
                .setUsername(config.unregisteredUserLogin())
                .setPassword(config.unregisteredUserPassword())
                .clickToLogin();});
        step("Проверяем, что повявилось уведомление об ошибке", () -> {
            loginPage
                .checkResultUnsuccessfulLogin();});

    }
}
