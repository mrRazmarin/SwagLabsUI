package swagLabs.tests;


import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swagLabs.config.SelenideConfiguration;
import swagLabs.helpers.HelpersMethod;
import swagLabs.steps.AuthCorrectSteps;

import java.util.Map;

import static swagLabs.helpers.HelpersMethod.getLogin;

@ExtendWith(SelenideConfiguration.class)
@DisplayName("Тесты авторизации")
public class AuthTests{
    private String password = HelpersMethod.getPassword();
    private final String urlOnPageShop = "https://www.saucedemo.com/inventory.html";
    AuthCorrectSteps authCorrectSteps = new AuthCorrectSteps();

    /**
     * Scenario AuthCorrect
     * Steps:
     * 1. Input login;
     * 2. Input password;
     * 3. Click on login-button
     *
     * ER: Redirect on shop-page
     */
    @Test
    @DisplayName("Проверка корректной авторизации")
    @Epic("UI")
    @Story("Authentication")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("AUTH-1")
    public void checkCorrectAuth(){
        authCorrectSteps.inputLogin(getLogin("unlocked_user"));
        authCorrectSteps.inputPassword(password);
        authCorrectSteps.checkInputLogin(getLogin("unlocked_user"));
        authCorrectSteps.checkInputPassword(password);
        authCorrectSteps.clickLoginButton();
        authCorrectSteps.checkRedirectOnShopPage(urlOnPageShop);
    }
}
