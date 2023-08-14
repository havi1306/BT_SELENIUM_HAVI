package testcases;

import common.Log;
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
    public void TC01() {

        HomePage homePage = new HomePage();
        FileDownloaderPage fileDownloaderPage = new FileDownloaderPage();
        SoftAssert softassert = new SoftAssert();

        DriverUtils.open();

        Log.info("1. Click on File Download link");
        homePage.clickFileDownloadLink();

        Log.info("Verify that user is on File Downloader page");
        String act_title = fileDownloaderPage.getTitleForFileDownloader();
        softassert.assertEquals(act_title, "File Downloader");

        Log.info("VP: Verify that total download-able files are 25");
        int act_number = fileDownloaderPage.getNumberOfDownloadFiles();
        softassert.assertEquals(act_number, 25);

        Log.info("2. Click on a file");
        fileDownloaderPage.clickDownloadFiles(5);

        Log.info("Verify that the file has been downloaded successfully to your local machine with correct file name");
        String fileName = fileDownloaderPage.getDownloadFileName(5);
        softassert.assertTrue(DriverUtils.isFileDownloaded(fileName));

        softassert.assertAll();
    }
}
