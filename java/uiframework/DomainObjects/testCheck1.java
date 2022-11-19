package uiframework.DomainObjects;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class testCheck1 extends TestBase {

    private static final Logger log = LogManager.getLogger(testCheck1.class);

    @FindBy(xpath = "//*[@text='While using the app']")
    MobileElement accessPopup;
    @FindBy(xpath = "//*[@text='Allow']")
    MobileElement allowBtn;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__userId']")
    MobileElement emailId;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__pswd']")
    MobileElement password;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__element_button_1']")
    MobileElement loginBtn;

    public static CommonElements commonElements;
    public static CommonDriver commonDriver;
    public static TextBoxControls textBoxControls;
    public static WaitUtility waitUtility;
    public static WindowHandling windowHandling;
    public static ScreenshotControl screenshotControl;
    public static JavaScriptControls javaScriptControls;
    public static AppiumDriver<MobileElement> Driver;


    public testCheck1() {
        androidConnection();
        PageFactory.initElements(Driver, this);
    }


    public void enterUserName() throws Exception {
        waitUtility.waitForSeconds(5);
        commonElements.click(accessPopup);
        commonElements.click(allowBtn);
        waitUtility.waitTillElementVisible(Driver, emailId, 3);
        textBoxControls.clearText(emailId);
        textBoxControls.setText(emailId, "divya");
    }

    public void enterPassword() throws Exception {
        textBoxControls.clearText(password);
        textBoxControls.setText(password, "passWord");
    }

    public void ClickLoginButton() throws Exception {
        commonElements.click(loginBtn);
    }



    public static void androidConnection() {
        List<String> list = new ArrayList<>();
        list.add("SAMSUNG_GalaxyTabS6_Android_11.0.0_383e3");
        list.add("SAMSUNG_GalaxyTabS5e_Android_11.0.0_cb1ca");
        list.add("SAMSUNG_GalaxyTabS4_Android_10.0.0_2133b");
        list.add("SAMSUNG_GalaxyTabS6_Android_9.0.0_16c48");
        list.add("LENOVO_M10Plus_Android_10.0.0_2ba36");
        list.add("SAMSUNG_GalaxyTabS6Lite_Android_10.0.0_5ffce");

        for (String appName : list) {

            if (Driver == null) {
                try {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("pCloudy_Username", "sriganesh.d@i-exceed.com");
                    capabilities.setCapability("pCloudy_ApiKey", "7bdrrbks9fdv68qrxgcg3b3w");
                    capabilities.setCapability("pCloudy_DurationInMinutes", 600);
                    capabilities.setCapability("newCommandTimeout", 600);
                    capabilities.setCapability("launchTimeout", 90000);
                    capabilities.setCapability("wdaStartupRetries", "5");
//                    capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
                    capabilities.setCapability("webviewConnectTimeout", 15000);
                    capabilities.setCapability("webviewConnectRetries", "20");
                    capabilities.setCapability("pCloudy_DeviceFullName", appName);
                    capabilities.setCapability("platformVersion", "11.0.0");
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("automationName", "uiautomator2");
                    capabilities.setCapability("pCloudy_ApplicationName", "Automation-1-0-22-17-3-2022-1654605873.apk");
                    capabilities.setCapability("appPackage", "com.iexceed.assistedonboardingapp.qa");
                    capabilities.setCapability("appActivity", "com.iexceed.assistedonboardingapp.assistedonboarding.AssistedOnboardingActivity");
                    capabilities.setCapability("pCloudy_WildNet", "true");
                    capabilities.setCapability("pCloudy_EnableVideo", "true");
                    capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
                    capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
                    Driver = new AndroidDriver<>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
                    log.debug(" driver connceted using Device:{}", appName);

                } catch (Exception e) {
                    log.debug(e);
                }
            } else {
                log.debug("driver is not null,its running ");
            }

        }
    }


}
