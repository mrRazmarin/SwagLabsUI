package swagLabs.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ShopPage {
    public SelenideElement sideBarElement(){
        return $("#react-burger-menu-btn")
                .as("Левое меню страницы");
    }

    public SelenideElement logoutButton(){
        return $("#logout_sidebar_link").as("Кнопка \'logout\'");
    }
}
