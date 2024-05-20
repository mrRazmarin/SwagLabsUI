package swagLabs.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import swagLabs.pages.GeneralShopPage;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class ShopSteps {
    private GeneralShopPage shopPage = new GeneralShopPage();

    @Step
    //Добавление продукта в корзину
    public void addSingleProductToCart(String productName) {
        shopPage.fullBlockOnceProduct()
                .filter(cssClass("inventory_item_name"))
                .findBy(exactText(productName));
        productName = productName.replace(" ", "-").toLowerCase();
        shopPage.addToCartButton()
                .findBy(attribute("name", "add-to-cart" + "-" + productName))
                .click();
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

    }
}
