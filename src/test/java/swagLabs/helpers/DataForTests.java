package swagLabs.helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DataForTests {
    private static final String password = "secret_sauce";
    public final String getPassword() {
        return password;
    }
    private final String urlShopPage = "https://www.saucedemo.com/inventory.html";
    private final String urlAuthPage = "https://www.saucedemo.com";
    private final List<String> logins = List.of(
            "visual_user","standard_user"
    );
    private final List<String> items = List.of(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie"
    );
    public List<String> getItems(){
        return items;
    }

    public static Stream<Arguments> getNamesItems() {
        return Stream.of(
                Arguments.of("Sauce Labs Backpack"),
                Arguments.of("Sauce Labs Bike Light"),
                Arguments.of("Sauce Labs Bolt T-Shirt"),
                Arguments.of("Sauce Labs Fleece Jacket"),
                Arguments.of("Sauce Labs Onesie")
        );
    }
    public String getUrlShop() {
        return urlShopPage;
    }
    public String getUrlAuth() {
        return urlAuthPage;
    }
    public List<String> getLogins(){
        return logins;
    }
    public Date getExpiresDateForCookie(){
        Date expires = new Date();
        expires.setTime(expires.getTime() + (10000 * 10000));
        return expires;
    }
}
