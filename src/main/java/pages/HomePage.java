package pages;

import common.constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class HomePage extends GeneralPage {

    //Locators
    private final By linkFileDownload = By.xpath("//a[text()='File Download']");

    // Elements
    private WebElement getFileDownloadLink(){
        return Constants.WEBDRIVER.findElement(linkFileDownload);
    }

    // Method
    @Step("Click File Download Link")
    public void clickFileDownloadLink (){
        DriverUtils.scrollToElement(getFileDownloadLink());
        this.getFileDownloadLink().click();
    }

}
