package utils;

import common.constants.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

    public static void hardWait(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) Constants.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", webElement);
        hardWait(500);
    }

    public static void waitForVisibilityOfElement(WebElement webElement) {
        WebDriverWait waitElement = new WebDriverWait(Constants.WEBDRIVER, Constants.TIMEOUT_IN_SECONDS);
        waitElement.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static String getPageTitle() {
        return Constants.WEBDRIVER.getTitle();
    }

    public static void open(){
        Constants.WEBDRIVER.navigate().to(Constants.INTERNET_URL);
    }

    public static void clickOkOnConfirmationMessage() {
        Constants.WEBDRIVER.switchTo().alert().accept();
    }
}
