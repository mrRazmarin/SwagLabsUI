package swagLabs.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import swagLabs.config.SelenideConfiguration;
import swagLabs.helpers.HelpersMethod;

import java.util.List;

@ExtendWith(SelenideConfiguration.class)
@DisplayName("Tests for shop page")
public class ShopTests {
    private final String password = HelpersMethod.getPassword();
    private final List<String> listLogins = HelpersMethod.getLogins();


}
