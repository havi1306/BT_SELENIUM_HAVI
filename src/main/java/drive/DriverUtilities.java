package drive;

import common.Log;
import Enum.Browser;
import org.openqa.selenium.WebDriver;

public class DriverUtilities extends DriverManagerFactory   {
    public static void getBrowser(Browser browser) {
        DriverManagerFactory.setDriverManager(browser);
    }

    public static WebDriver getWebDriver() {
        return getDriverManager().getDriver();
    }

    public static void openURL(String urlValue) {
        getDriverManager().getDriver().navigate().to(urlValue);
    }

    public static void closeBrowserAndDriver() {
        try {
            if (getDriverManager().getDriver() != null) {
                getDriverManager().getDriver().quit();
            }
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    public static String getPageTitle() {
        return getDriverManager().getDriver().getTitle();
    }
}
