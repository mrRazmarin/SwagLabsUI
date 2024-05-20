package swagLabs.helpers;

import java.util.Date;
import java.util.List;

public class DataForTests {
    private static final String password = "secret_sauce";

    public static String getPassword() {
        return password;
    }
    private static final String urlShopPage = "https://www.saucedemo.com/inventory.html";
    private static final String urlAuthPage = "https://www.saucedemo.com";
    private  final String nameSingleItem = "Sauce Labs Backpack";

    public static String getUrlShop() {
        return urlShopPage;
    }

    public static String getUrlAuth() {
        return urlAuthPage;
    }

    private static final List<String> logins = List.of(
            "visual_user","standard_user"
    );
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
