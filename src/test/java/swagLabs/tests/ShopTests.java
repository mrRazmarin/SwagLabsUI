package swagLabs.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import swagLabs.config.ShopPageConfiguration;
import swagLabs.helpers.DataForTests;
import swagLabs.steps.ShopSteps;

import java.util.Random;

@ExtendWith(ShopPageConfiguration.class)
@DisplayName("Tests for shop page")
public class ShopTests {
    private ShopSteps shopSteps = new ShopSteps();
    private DataForTests dataForTests = new DataForTests();
    private Random rand = new Random();

    /***
     * Preliminary condition:
     * - Log in and go to the product page
     * Steps:
     * 1. Open shop page;
     * 2. Add item;
     * 3. Open cart;
     * 4. Check have item.
     */
    @MethodSource("swagLabs.helpers.DataForTests#getNamesItems")
    @ParameterizedTest(name = "Adding single item '{0}' and checking him in the cart")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    void addOnceItemToCart(String nameProduct) {
        shopSteps.addSingleProductToCart(nameProduct);
        shopSteps.openCart();
        shopSteps.checkHaveItemInCart(nameProduct);
    }

    /***
     * Preliminary condition:
     * - Log in and go to the product page
     * Steps:
     * 1. Adding multiple items;
     * 2. Open Cart;
     * 3. Check having items in the cart.
     */
    @Test()
    @DisplayName("Adding multiple items and checking them in the cart")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    public void addMultipleItem() {
        shopSteps.addMultipleProductsToCart(dataForTests.getItems());
        shopSteps.openCart();
        shopSteps.checkHaveItemInCart(dataForTests.getItems());
    }
    /***
     * Preliminary condition:
     * - Log in and go to the product page
     * Steps:
     * 1. Click on button 'Add to cart';
     * 2. Check icons 'Cart';
     * 3. Delete to added item in the cart;
     * 4. Checking what cart is empty.
     */
    @Test
    @DisplayName("Checking work remove button on product")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    public void checkWorkingRemoveButton(){
        String nameProductFromList = dataForTests.getItems()
                .get(rand.nextInt(dataForTests.getItems().size()));
        shopSteps.addSingleProductToCart(nameProductFromList);
        shopSteps.checkCountItemsInCart(1);
        shopSteps.deleteItemFromShopPage(nameProductFromList);
        shopSteps.checkCountItemsInCart(0);
    }
    /***
     * Preliminary condition:
     * - Log in and go to the product page
     * Steps:
     * 1. Click on button 'Add to cart';
     * 2. Check icons 'Cart';
     * 3. Enter in cart;
     * 4. Checking name item, what adding item equals to the current one
     */
    @MethodSource("swagLabs.helpers.DataForTests#getNamesItems")
    @ParameterizedTest(name = "Checking adding '{0}' on shop page and name in the cart page")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    public void checkItemNameOnPageAndInCart(String nameProduct) {
        shopSteps.addSingleProductToCart(nameProduct);
        shopSteps.checkCountItemsInCart(1);
        shopSteps.openCart();
        shopSteps.checkHaveItemInCart(nameProduct);
    }
}
