package swagLabs.helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DataForTests {
    private static final String password = "secret_sauce";
    public static String getPassword() {
        return password;
    }
    private static final String urlShopPage = "https://www.saucedemo.com/inventory.html";
    private static final String urlAuthPage = "https://www.saucedemo.com";
    private final String nameSingleItem = "Sauce Labs Backpack";
    private  static  final List<String> logins = List.of(
            "visual_user","standard_user"
    );
    private static final List<String> items = List.of(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie"
    );
    public static List<String> getItems(){
        return items;
    }

    public static final Stream<Arguments> getNamesItems() {
        return Stream.of(
                Arguments.of("Sauce Labs Backpack"),
                Arguments.of("Sauce Labs Bike Light"),
                Arguments.of("Sauce Labs Bolt T-Shirt"),
                Arguments.of("Sauce Labs Fleece Jacket"),
                Arguments.of("Sauce Labs Onesie")
        );
    }
    public static String getUrlShop() {
        return urlShopPage;
    }
    public static String getUrlAuth() {
        return urlAuthPage;
    }
    public static List<String> getLogins(){
        return logins;
    }
    public static Date getExpiresDateForCookie(){
        Date expires = new Date();
        expires.setTime(expires.getTime() + (10000 * 10000));
        return expires;
    }
    public  String getNameSingleItem() {
        return nameSingleItem;
    }

}
