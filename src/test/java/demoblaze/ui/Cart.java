package demoblaze.ui;

import com.github.javafaker.Faker;
import demoblaze.TestBase;
import demoblaze.ui.pageObject.CartObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class Cart extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    String name = faker.name().firstName(),
            country = faker.country().name(),
            city = faker.country().capital(),
            card = faker.finance().creditCard();


    @Test
    @DisplayName("Проверка добавления товара в корзину с оформлением заказа")
    void addItemToCart() {
        step("Открываем главную страницу", () -> {
            open("https://www.demoblaze.com/");
        });
        step("Открываем главную страницу и переходим в корзину", () -> {
            new CartObject()
                    .addItemToCart()
                    .goToCart();
        });
        step("Переходим к оформлению заказа", () -> {
            new CartObject().startPlaceAnOrder();
        });
        step("Заполняем поля имя, страна, номер кредитной карты, дату", () -> {
            new CartObject()
                    .setName(name)
                    .setCountry(country)
                    .setCity(city)
                    .setCard(card)
                    .setMonth("01")
                    .setYear("1999");
        });
        step("Проверяем что появилось окно подтверждающее создание заказа", () -> {
            new CartObject()
                    .finishPlaceAnOrder()
                    .checkResultsForAddItem(name, card);
        });
    }


    @Test
    @DisplayName("Проверка удаления добавленного товара из корзины")
    void deleteItemFromCart() {
        step("Открываем главную страницу", () -> {
            open("https://www.demoblaze.com/");});
        step("Добавляем товар в коризну", () -> {
            new CartObject()
                    .addItemToCart()
                    .goToCart();});
        step("Удаляем товар из корзины", () -> {
            new CartObject().deleteItemFrom();});
        step("Проверяем что выбранный товар удален из корзины", () -> {
            new CartObject().checkResultDeleteItem();});

    }
}
