package swagLabs.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GeneralShopPage {
    public SelenideElement sideBarElement(){
        return $("#react-burger-menu-btn")
                .as("Левое меню страницы");
    }
    public SelenideElement logoutButton(){
        return $("#logout_sidebar_link").as("Кнопка \'logout\'");
    }
    public ElementsCollection addToCartButton(){
        return $$x("//button[contains(@id, \"add-to-cart\")]")
                .as("Коллекция кнопок 'Add to cart'");
    }
    public SelenideElement cartButton(){
        return $x("//a[contains(@class, \"shopping_cart_link\")]")
                .as("Кнопка корзины");
    }
    public ElementsCollection removeFromCartButton(){
        return $$x("//button[contains(@id, \"remove-sauce-labs\")]")
                .as("Коллекция кнопок 'Remove'");
    }
    public ElementsCollection nameItems(){
        return $$x("//div[contains(@class, \"inventory_item_name\")]")
                .as("Наименование товаров");
    }
    public ElementsCollection descriptionItems(){
        return $$x("//div[@class = \"inventory_item_desc\"]")
                .as("Описание товаров");
    }
    public ElementsCollection fullBlockOnceProduct(){
        return $$x("//div[@class = \"inventory_item_description\"]")
                .as("Блок с информацией о товаре");
    }
    public ElementsCollection itemsInCart(){
        return $$x("//div[@class = \"inventory_item_name\"]")
                .as("Продукты в корзине");
    }
}
