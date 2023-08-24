package utils;

import common.Log;
import common.constants.Constants;

import java.io.File;

import drive.DriverUtilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Enum.Browser;

public class BaseTest {
    @BeforeMethod
    @Parameters(value={"browser"})
    public void beforeMethod(@Optional Browser browser){
        Log.info("Pre-Condition");
        DriverUtilities.getBrowser(browser);
        DriverUtilities.openURL(Constants.INTERNET_URL);
    }
    @AfterMethod
    public void afterMethod() {
        Log.info("Post-Condition");
        DriverUtilities.closeBrowserAndDriver();
    }

    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public WebDriver getDriver() {
        return Constants.WEBDRIVER;
    }
}
