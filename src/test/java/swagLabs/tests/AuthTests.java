package swagLabs.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swagLabs.config.SelenideConfiguration;
import swagLabs.helpers.HelpersMethod;
import swagLabs.steps.AuthCorrectSteps;

import java.util.List;

@ExtendWith(SelenideConfiguration.class)
@DisplayName("Тесты авторизации")
public class AuthTests{
    private final String password = HelpersMethod.getPassword();
    private final List<String> logins = HelpersMethod.getLogins();
    private final String urlOnPageShop = "https://www.saucedemo.com/inventory.html";
    AuthCorrectSteps authCorrectSteps = new AuthCorrectSteps();

    /***
     * Check auth on site with all logins
     * Steps:
     * 1. Input login(loop);
     * 2. Input password;
     * 3. Click 'Login';
     * 4. Retry from 1 on 3 steps with all
     ***/
    @Test
    @DisplayName("Проверка корректной авторизации всех пользователей")
    @Epic("UI")
    @Story("Authentication")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("AUTH-all")
    public void checkCorrectAuth(){
        int countLogins = logins.size();
        while(countLogins > 0){
            authCorrectSteps.inputLogin(logins.get(countLogins - 1));
            authCorrectSteps.inputPassword(password);
            authCorrectSteps.clickLoginButton();
            authCorrectSteps.clickSideBar();
            authCorrectSteps.clickLogoutButton();
            countLogins--;
            System.out.println("Count logins: " + countLogins);
        }
    }
}
