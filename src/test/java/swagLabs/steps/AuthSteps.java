package swagLabs.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import swagLabs.pages.AuthPage;
import swagLabs.pages.GeneralShopPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AuthSteps {
    private final AuthPage authPage = new AuthPage();
    private final GeneralShopPage shopPage = new GeneralShopPage();

    @Step("Input login")
    public void inputLogin(String login){
        authPage.userNameField().click();
        authPage.userNameField().setValue(login);
    }
    @Step("Input password")
    public void inputPassword(String password){
        authPage.passwordField().click();
        authPage.passwordField().setValue(password);
    }
    @Step("Click on login-button")
    public void clickLoginButton(){
        authPage.buttonLogin().click();
    }
    @Step("Проверить введен ли логин в поле \"username\"")
    public void checkInputLogin(String login){
        String getAttributeValue = authPage.userNameField().getAttribute("value");
        Assertions.assertEquals(login, getAttributeValue);
    }
    @Step("Проверить введен ли пароль в поле \"password\"")
    public void checkInputPassword(String password){
        String getAttributeValue = authPage.passwordField().getAttribute("value");
        Assertions.assertEquals(password, getAttributeValue);
    }
    @Step("Проверка редиректа после авторизации")
    public void checkRedirectOnShopPage(String redirectLink){
        //HelpersMethod.sleepSelenide(5);
        webdriver().shouldHave(url(redirectLink));
    }
    @Step
    public void clickSideBar(){
        shopPage.sideBarElement().click();
    }
    @Step
    public void clickLogoutButton(){
        shopPage.logoutButton().click();
    }
}
