package swagLabs.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NotFoundException;
import swagLabs.pages.ShopPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ShopSteps {
    private final ShopPage shopPage = new ShopPage();

    @Step("Добавление продукта в корзину")
    public void addSingleProductToCart(String productName) {
        //noinspection ResultOfMethodCallIgnored
        shopPage.fullBlockOnceProduct()
                .filter(cssClass("inventory_item_name"))
                .findBy(exactText(productName));
        productName = productName.replace(" ", "-").toLowerCase();
        shopPage.addToCartButton()
                .findBy(attribute("name", "add-to-cart" + "-" + productName))
                .click();
    }
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Step("Добавление нескольких продуктов в корзину")
    public void addMultipleProductsToCart(List<String> productNames) {
        int counter = productNames.size();

        while (counter > 0){
            shopPage.fullBlockOnceProduct()
                    .filter(cssClass("inventory_item_name"))
                    .findBy(exactText(productNames.get(counter - 1)));
//            String productName = productNames.get(counter - 1)
//                    .replace(" ", "-")
//                    .toLowerCase();
            String productName = new StringBuffer(productNames.get(counter - 1).replace(" ", "-"))
                    .insert(0, "add-to-cart-")
                    .toString().toLowerCase();
            shopPage.addToCartButton()
                    .findBy(attribute("name", productName))
                    .click();
            counter--;
        }
    }
    @Step("Открытие корзины")
    public void openCart() {
        shopPage.cartButton().click();
    }
    @Step("Проверка наличия продукта в корзине")
    public void checkHaveItemInCart(String itemName) {
        shopPage.itemsInCart()
                .findBy(attribute("class"))
                .shouldHave(exactText(itemName));
    }
    @Step("Проверка наличия продуктов в корзине")
    public void checkHaveItemInCart(List<String> itemNames) {
        shopPage.itemsInCart()
                .shouldHave(containExactTextsCaseSensitive(itemNames));
    }
    @Step("Проверка 1 ед. товара в корзине")
    public void checkCountItemsInCart(Integer expectedCount){
        SelenideElement countInCartElement = shopPage.countAddItemsIcon();
        Integer countInCart;
        if (countInCartElement == null){
            countInCart = 0;
        }else {
            countInCart = Integer.parseInt(countInCartElement.getText());
        }
        Assertions.assertEquals(expectedCount, countInCart);
    }
    @Step("Удаление товара из корзины, из страницы с товарами")
    public void deleteItemFromShopPage(String nameProduct) {
        String textAttributeFormat = new StringBuffer(nameProduct.replace(" ", "-").toLowerCase())
                .insert(0, "remove-").toString();
        shopPage.removeFromCartButton()
                .findBy(attribute("data-test", textAttributeFormat))
                .shouldBe(visible)
                .click();
    }
}
