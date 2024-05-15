package swagLabs.helpers;

import com.codeborne.selenide.Selenide;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HelpersMethod {
    public static void sleepSelenide(int seconds){
        Selenide.sleep(TimeUnit.MILLISECONDS.convert(seconds, TimeUnit.SECONDS));
    }
    private static String password = "secret_sauce";

    public static String getPassword() {
        return password;
    }

    private static Map<String, String> logins = Map.of(
            "unlocked_user","standard_user",
            "locked_user", "locked_out_user"
    );
    public static Map<String, String> getLogins(){
        return logins;
    }

    public static String getLogin(String tagLogin){
        return logins.get(tagLogin);
    }
}
