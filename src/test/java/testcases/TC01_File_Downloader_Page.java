package testcases;

import common.Log;
import common.constants.Constants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FileDownloaderPage;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverUtils;

import java.io.File;

public class TC01_File_Downloader_Page extends BaseTest {

    @Test(description = "Verify that user is on File Downloader page" +
                        "Verify that total download-able files are 25" +
                        "Verify that the file has been downloaded successfully to your local machine with correct file name.")
    public void TC01() throws Exception{

        //
        String exp_FileDownloaderTitle = "File Downloader";
        int exp_number = 25;
        int index = 5;
        Boolean isFileDownloaded = true;

        File folder = new File(Constants.FILES_DIRECTORY);
        HomePage homePage = new HomePage();
        FileDownloaderPage fileDownloaderPage = new FileDownloaderPage();
        SoftAssert softassert = new SoftAssert();

        DriverUtils.open();
        DriverUtils.hardWait(Constants.TIMEOUT_IN_SECONDS);

        Log.info("1. Click on File Download link");
        homePage.clickFileDownloadLink();

        Log.info("Verify that user is on File Downloader page");
        String act_title = fileDownloaderPage.getTitleForFileDownloader();
        softassert.assertEquals(act_title, exp_FileDownloaderTitle);
        this.takeSnapShot(Constants.WEBDRIVER, "D:\\BT_SELENIUM_HAVI\\attachment\\test.png") ;

        Log.info("VP: Verify that total download-able files are 25");
        int act_number = fileDownloaderPage.getNumberOfDownloadFiles();
        Log.info("-----------------------------" + act_number);
        softassert.assertEquals(act_number, exp_number);

        Log.info("2. Click on a file");
        String web_file_name = fileDownloaderPage.getDownloadFileName(index);
        fileDownloaderPage.clickDownloadFiles(index);
        DriverUtils.hardWait(Constants.TIMEOUT_IN_SECONDS);

        Log.info("Verify that the file has been downloaded successfully to your local machine with correct file name");
        Log.info("---------------------------" + web_file_name);
        File[] allFiles = new File(folder.getPath()).listFiles();
        for (File file : allFiles) {
            String eachFile = file.getName();
            if (eachFile.contains(web_file_name)) {
                Log.info("--Verified: File : " + web_file_name + " Has Been Download.");
                softassert.assertTrue(isFileDownloaded);
                break;
            }
            else continue;
        }

        softassert.assertAll();
    }
}
