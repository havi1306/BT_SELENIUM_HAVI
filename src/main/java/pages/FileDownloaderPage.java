package pages;

import common.constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FileDownloaderPage extends GeneralPage{

    // Locators
    private final By txtFileDownloaderTitle = By.xpath("//div[@id='content']//h3");
    private final By linkDownloadFiles = By.xpath("//div[@class='example']/a");

    // Elements
    private WebElement getFileDownloaderTitle(){
        return Constants.WEBDRIVER.findElement(txtFileDownloaderTitle);
    }

    private List<WebElement> getDownloadFiles(){
        return Constants.WEBDRIVER.findElements(linkDownloadFiles);
    }

    @Step("Get Title For File Downloader")
    public String getTitleForFileDownloader(){
        return this.getFileDownloaderTitle().getText();
    }

    @Step("Get Number Of Download Files")
    public int getNumberOfDownloadFiles(){
        return this.getDownloadFiles().size();
    }

    @Step("Click Download Files")
    public void clickDownloadFiles (int index){
        this.getDownloadFiles().get(index).click();
    }
    @Step("Get Download File Name ")
    public String getDownloadFileName (int index){
        String name = this.getDownloadFiles().get(index).getText();
        return name;
    }

    @Step
    public void check(SoftAssert softAssert) {
        softAssert.assertAll();
    }
}
