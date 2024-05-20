package swagLabs.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.*;
import swagLabs.helpers.DataForTests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class AuthConfiguration implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.baseUrl = DataForTests.getUrlAuth();
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.reportsFolder = "src/test/resources/screenshots";
        Configuration.screenshots = true;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        open(baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriverRunner.closeWebDriver();
    }
}
