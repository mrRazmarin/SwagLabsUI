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

@ExtendWith(ShopPageConfiguration.class)
@DisplayName("Tests for shop page")
public class ShopTests {
    private ShopSteps shopSteps = new ShopSteps();
    private DataForTests dataForTests = new DataForTests();

    /***
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
    void addOnceItemToCart(String product) {
        shopSteps.addSingleProductToCart(product);
        shopSteps.openCart();
        shopSteps.checkHaveItemInCart(product);
    }


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
}
