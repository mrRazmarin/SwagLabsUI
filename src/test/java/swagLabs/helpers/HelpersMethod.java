package swagLabs.helpers;

import com.codeborne.selenide.Selenide;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HelpersMethod {
    public static void sleepSelenide(int seconds){
        Selenide.sleep(TimeUnit.MILLISECONDS.convert(seconds, TimeUnit.SECONDS));
    }
    private static final String password = "secret_sauce";

    public static String getPassword() {
        return password;
    }

    private static final List<String> logins = List.of(
            "visual_user","standard_user"
    );
    public static List<String> getLogins(){
        return logins;
    }
}
