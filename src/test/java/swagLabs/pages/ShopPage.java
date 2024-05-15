package swagLabs.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ShopPage {
    public SelenideElement headingShop(){
        return $x("//div[contains(@class, \"app_logo\")]")
                .as("Заголовок страницы");
    }
    public SelenideElement nameCategory(){
        return $x("//div/span[contains(@class, \"title\")]")
                .as("Наименование категории");
    }
    public SelenideElement filter(){
        return $x("//div/span[contains(@class, \"select_container\")]")
                .as("Фильтр");
    }
    public ElementsCollection filterObjects(){
        return $$x("//select/option")
                .as("Элементы фильтра");
    }
    public ElementsCollection itemObjects(){
        return $$x("//div[contains(@class, \"inventory_list\")]/div")
                .as("Объект товара");
    }
    public ElementsCollection nameProducts(){
        return $$x("//div[contains(@class, \"inventory_item\")]/a[contains(@id, \"title_link\")]")
                .as("Наименования товаров");
    }
}
