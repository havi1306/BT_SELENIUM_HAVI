package drive;

import common.Log;

import Enum.Browser;

public class DriverManagerFactory {
    protected static ThreadLocal<DriverManager> DRIVERS = new InheritableThreadLocal<>();

    public static void setDriverManager(Browser browserName) {
        switch (browserName) {
            case CHROME_LOCAL:
                DRIVERS = ThreadLocal.withInitial(()-> new ChromeDriverManager());
                break;
            case FIREFOX_LOCAL:
                DRIVERS = ThreadLocal.withInitial(()-> new FirefoxDriverManager());
                break;
            default: Log.info("Browser is not supported");
        }
    }

    public static DriverManager getDriverManager() {
        return DRIVERS.get();
    }
}
