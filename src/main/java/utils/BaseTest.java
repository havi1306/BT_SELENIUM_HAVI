package utils;

import common.Log;
import common.constants.Constants;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters(value={"browser"})
    public void beforeMethod(){
        Log.info("Pre-Condition");
        LaunchDriver.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod() {
        Log.info("Post-Condition");
        Constants.WEBDRIVER.quit();
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
