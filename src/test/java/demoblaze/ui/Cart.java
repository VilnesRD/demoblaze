package demoblaze.ui;

import com.github.javafaker.Faker;
import demoblaze.ui.pageObject.CartObject;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;


public class Cart extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    String name = faker.name().firstName(),
            country = faker.country().name(),
            city = faker.country().capital(),
            card = faker.finance().creditCard();


    @Test
    void addItemToCart() {
        open("https://www.demoblaze.com/");
        new CartObject()
                .addItemToCart()
                .goToCart()
                .startPlaceAnOrder()
                .setName(name)
                .setCountry(country)
                .setCity(city)
                .setCard(card)
                .setMonth("01")
                .setYear("1999")
                .finishPlaceAnOrder()
                .checkResultsForAddItem(name, card);
    }

    @Test
    void deleteItemFromCart() {
        open("https://www.demoblaze.com/");
        new CartObject()
                .addItemToCart()
                .goToCart()
                .deleteItemFrom()
                .checkResultDeleteItem();
    }
}