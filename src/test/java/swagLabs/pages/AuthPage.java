package swagLabs.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage {
    public SelenideElement textLogo(){
        return $x("//div[contains(text(), \"Swag Labs\")]").as("Текст логотипа, заголовок страницы авторизации");
    }
    public SelenideElement userNameField(){
        return $x("//input[contains(@id, \"user-name\")]").as("Поле для ввода логина");
    }
    public SelenideElement passwordField(){
        return $x("//input[contains(@id, \"password\")]").as("Поле для ввода пароля");
    }
    public SelenideElement buttonLogin(){
        return $x("//input[contains(@id, \"login-button\")]").as("Кнопка для входа");
    }
}
