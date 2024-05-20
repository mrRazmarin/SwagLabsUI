package swagLabs.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swagLabs.config.AuthConfiguration;
import swagLabs.helpers.DataForTests;
import swagLabs.steps.AuthSteps;

import java.util.List;

@ExtendWith(AuthConfiguration.class)
@DisplayName("Tests authorizations")
public class AuthTests {
    private final String password = DataForTests.getPassword();
    private final List<String> logins = DataForTests.getLogins();
    private final String urlOnPageShop = "https://www.saucedemo.com/inventory.html";
    AuthSteps authCorrectSteps = new AuthSteps();

    /***
     * Check auth on site with all logins
     * Steps:
     * 1. Input login;
     * 2. Input password;
     * 3. Click 'Login';
     * 4. Click on sidebar;
     * 5. Click on button 'Logout';
     * 6. Retry from 1 on 5 steps with all logins
     ***/
    @Test
    @DisplayName("Checker correct authorization multiple users")
    @Epic("UI")
    @Story("Authentication")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("AUTH-all")
    public void checkAuthWithAllLogins() {
        int countLogins = logins.size();
        while (countLogins > 0) {
            authCorrectSteps.inputLogin(logins.get(countLogins - 1));
            authCorrectSteps.inputPassword(password);
            authCorrectSteps.clickLoginButton();
            authCorrectSteps.clickSideBar();
            authCorrectSteps.clickLogoutButton();
            countLogins--;
            System.out.println("Count logins: " + countLogins);
        }
    }

    @Test
    @DisplayName("Checker correct authorization 'standard' user")
    @Epic("UI")
    @Story("Authentication")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail Salnikov")
    @Issue("AUTH-standardUser")
    void checkCorrectAuth() {
        authCorrectSteps.inputLogin(logins.stream()
                .filter(x -> x.equals("standard_user"))
                .findFirst()
                .get()
        );
        authCorrectSteps.inputPassword(password);
        authCorrectSteps.clickLoginButton();
        authCorrectSteps.checkRedirectOnShopPage(urlOnPageShop);
    }
}
