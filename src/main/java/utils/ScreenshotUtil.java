package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenshotUtil {

    public void takeScreenShot(String methodName, WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs((OutputType.FILE));
            String dest = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + randNum() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int randNum() throws IOException {

        Random ran = new Random();
        int num = ran.nextInt(2000);
        return num;

    }

}
