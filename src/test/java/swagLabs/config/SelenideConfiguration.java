package swagLabs.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class SelenideConfiguration implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browser = "chrome";
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
