package swagLabs.steps;

import io.qameta.allure.Step;
import swagLabs.pages.GeneralShopPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.*;

public class ShopSteps {
    private final GeneralShopPage shopPage = new GeneralShopPage();

    @Step
    //Добавление продукта в корзину
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
    @Step
    //Добавление нескольких продуктов в корзину
    public void addMultipleProductsToCart(List<String> productNames) {
        int counter = productNames.size();

        while (counter > 0){
            shopPage.fullBlockOnceProduct()
                    .filter(cssClass("inventory_item_name"))
                    .findBy(exactText(productNames.get(counter - 1)));
            String productName = productNames.get(counter - 1)
                    .replace(" ", "-")
                    .toLowerCase();
            shopPage.addToCartButton()
                    .findBy(attribute("name", "add-to-cart" + "-" + productName))
                    .click();
            counter--;
        }
    }
    @Step
    //Открытие корзины
    public void openCart() {
        shopPage.cartButton().click();
    }
    @Step
    //Проверка наличия продукта в корзине
    public void checkHaveItemInCart(String itemName) {
        shopPage.itemsInCart()
                .findBy(attribute("class"))
                .shouldHave(exactText(itemName));
    }
    @Step
    //Проверка наличия продуктов в корзине
    public void checkHaveItemInCart(List<String> itemNames) {
        shopPage.itemsInCart()
                .shouldHave(containExactTextsCaseSensitive(itemNames));
    }
}
