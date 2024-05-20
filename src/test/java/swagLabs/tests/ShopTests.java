package swagLabs.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    @Test
    @DisplayName("Add single item from general page to cart")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    void addOnceItemToCart() {
        shopSteps.addSingleProductToCart(dataForTests.getNameSingleItem());
        shopSteps.openCart();
        shopSteps.checkHaveItemInCart(dataForTests.getNameSingleItem());
    }

    @Test
    @DisplayName("Add multiple item from general page to cart")
    @Epic("UI")
    @Story("ShopPage")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("Shop")
    public void addMultipleItem() {

    }
}
