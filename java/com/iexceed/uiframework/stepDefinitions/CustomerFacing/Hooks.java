package com.iexceed.uiframework.stepDefinitions.CustomerFacing;

import com.iexceed.uiframework.core.TestBase;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;
import static com.iexceed.uiframework.runners.TestRunnerCustomer.multiPlatform;

public class Hooks extends TestBase {


    @Before()
    public  void init(){
        System.out.println("Starting scenario");

    }
    @BeforeStep()
    public  void bf(){
        System.out.println("Before scenario");

    }
    @AfterStep()
    public  void af(Scenario scenario) throws IOException {
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            File src = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            scenario.attach(fileContent, "image/png", "screenshot");
        } else {
            File src = ((TakesScreenshot) webdriver.get()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

    @After()
    public void teardown(Scenario scenario) throws Exception {
        if (multiPlatform.equalsIgnoreCase("web")){
            webdriver.get().quit();
        }else{
            System.out.println("No needed browser close");
        }
    }


}
