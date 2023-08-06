package utils;

import common.constants.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchDriver {

    public static void getDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Executables\\chromedriver.exe");
                    Constants.WEBDRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Executables\\geckodriver.exe");
                Constants.WEBDRIVER = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src\\test\\resources\\Executables\\msedgedriver.exe");
                Constants.WEBDRIVER = new EdgeDriver();
                break;
        }

        Constants.WEBDRIVER.manage().window().maximize();
    }
}
