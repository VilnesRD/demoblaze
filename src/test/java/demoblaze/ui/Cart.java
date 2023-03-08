package demoblaze.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class Cart extends TestBase{
    Faker faker = new Faker(new Locale("en"));
    String name =faker.name().firstName(),
            country = faker.country().name(),
            city = faker.country().capital(),
            card = faker.finance().creditCard();


    @Test
    void addItemToCart() {
        open("https://www.demoblaze.com/");
        $$("#itemc").first().click();
        $("a[href='prod.html?idp_=1']").click();
        $(".btn-success").click();
        switchTo().alert().accept();
        $$("#navbarExample li").get(3).click();
        $(".btn-success").click();
        $("#name").setValue(name);
        $("#country").setValue(country);
        $("#city").setValue(city);
        $("#card").setValue(card);
        $("#month").setValue("01");
        $("#year").setValue("1999");
        $("button[onclick='purchaseOrder()']").click();
        $(".sweet-alert").shouldBe(visible);
        String orderConfirmText = $("p.lead").getText();
        String expectedText = "360";
        assertTrue(orderConfirmText.contains(expectedText));
        assertTrue(orderConfirmText.contains(name));
        assertTrue(orderConfirmText.contains(card));

    }

    @Test
    void deleteItemFromCart () {
        open("https://www.demoblaze.com/");
        $$("#itemc").first().click();
        $("a[href='prod.html?idp_=1']").click();
        $(".btn-success").click();
        switchTo().alert().accept();
        $$("#navbarExample li").get(3).click();
        $$("a[href='#']").get(7).shouldBe(visible).click();
        $("tr.success").shouldNotBe(visible);

    }
}