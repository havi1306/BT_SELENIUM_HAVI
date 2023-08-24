//package utils;
//
//import common.constants.Constants;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class LaunchDriver {
//
//    public static void getDriver(String browser) {
//        switch (browser) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                break;
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                break;
//        }
//
//        Constants.WEBDRIVER.manage().window().maximize();
//    }
//}
