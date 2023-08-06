package report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import common.constants.Constants;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import java.sql.DriverManager;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

//    public static void setAllureEnvironmentInformation() {
//        AllureEnvironmentWriter.allureEnvironmentWriter(
//                ImmutableMap.<String, String>builder().
//                        put("Target execution", "Local").
//                        put("Global timeout", "10").
//                        put("Faker locale", "us").
//                        build(), System.getProperty("user.dir")
//                        + "/target/allure-results/");
//    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) Constants.WEBDRIVER).getScreenshotAs(BYTES);
    }
}
