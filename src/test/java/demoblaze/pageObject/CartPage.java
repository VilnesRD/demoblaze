package demoblaze.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class CartPage {

    private final SelenideElement
            selectCategory = $$("#itemc").first(),
            selectItem = $("a[href='prod.html?idp_=1']"),
            successButton = $(".btn-success"),
            goToCard = $$("#navbarExample li").get(3),
            setName = $("#name"),
            setCountry = $("#country"),
            setCity = $("#city"),
            setCard = $("#card"),
            setMonth = $("#month"),
            setYear = $("#year"),
            purchaseOrder = $("button[onclick='purchaseOrder()']"),
            deleteButton = $$("a[href='#']").get(7);

    public CartPage addItemToCart() {
        selectCategory.click();
        selectItem.click();
        successButton.click();
        switchTo().alert().accept();

        return this;
    }

    public CartPage goToCart() {
        goToCard.click();

        return this;

    }

    public CartPage startPlaceAnOrder() {
        successButton.click();

        return this;
    }

    public CartPage setName(String value) {
        setName.setValue(value);

        return this;
    }

    public CartPage setCountry(String value) {
        setCountry.setValue(value);

        return this;
    }

    public CartPage setCity(String value) {
        setCity.setValue(value);

        return this;
    }

    public CartPage setCard(String value) {
        setCard.setValue(value);

        return this;
    }

    public CartPage setMonth(String value) {
        setMonth.setValue(value);

        return this;
    }

    public CartPage setYear(String value) {
        setYear.setValue(value);

        return this;
    }

    public CartPage finishPlaceAnOrder() {
        purchaseOrder.click();

        return this;
    }

    public CartPage checkResultsForAddItem(String name, String card) {
        $(".sweet-alert").shouldBe(visible);
        String orderConfirmText = $("p.lead").getText();
        String expectedText = "360 USD";
        assertTrue(orderConfirmText.contains(expectedText));
        assertTrue(orderConfirmText.contains(name));
        assertTrue(orderConfirmText.contains(card));

        return this;
    }

    public CartPage deleteItemFrom() {
        deleteButton.click();

        return this;
    }

    public CartPage checkResultDeleteItem() {
        $("tr.success").shouldNotBe(visible);

        return this;
    }

}
