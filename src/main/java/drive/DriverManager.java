package drive;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    WebDriver driver;
    public abstract void createDriver();

    public WebDriver getDriver() {
        if(driver == null) {
            createDriver();
        }
        return driver;
    }
}
