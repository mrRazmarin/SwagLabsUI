package swagLabs.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import swagLabs.helpers.DataForTests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class ShopPageConfiguration implements BeforeAllCallback,
        BeforeEachCallback,
        AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Configuration.baseUrl = DataForTests.getUrlShop();
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.reportsFolder = "src/test/resources/screenshots";
        Configuration.screenshots = true;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Cookie cookie = new Cookie("session-username",
                "standard_user" ,
                "www.saucedemo.com",
                "/",
                DataForTests.getExpiresDateForCookie());
        Selenide.open(DataForTests.getUrlAuth());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open(baseUrl);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        WebDriverRunner.closeWebDriver();
    }
}
