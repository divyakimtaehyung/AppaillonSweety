package uiframework.DomainObjects;

import com.iexceed.uiframework.appium.PcloudyConnection;
import com.iexceed.uiframework.core.TestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import uiframework.MobileUtility.IOSUtility;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class MultiPlatformConnection extends TestBase {

    public static Properties mobileProps = new Properties();
    private static Logger LOGGER = LogManager.getLogger(MultiPlatformConnection.class);

    IOSUtility iosUtility;
    public static String deviceName;

    PcloudyConnection mobileConnection;
    TestBase testBase;

    By targetCompanyName = By.xpath("//XCUIElementTypeCell[@name='i-exceed technology solutions private limited']");
    By trustCompanyName = By.xpath("//XCUIElementTypeStaticText[@name='Trust ?i-exceed technology solutions private limited?']");
    By trustBtn = By.xpath("//XCUIElementTypeButton[@name='Trust']");

    public MultiPlatformConnection() {
        FileInputStream ip;
        try {
            ip = new FileInputStream(new File("src/main/resources/mobileConnection.properties"));
            mobileProps.load(ip);
            LOGGER.info("Mobile Properties Loaded");
        } catch (Exception e) {
            LOGGER.error("Error in Loading Mobile Properties");
        }
        testBase = new TestBase();
        mobileConnection = new PcloudyConnection();
    }

    public void platformConnection(String platform,String application) throws Exception {
        if (platform.equalsIgnoreCase("android") || platform.equalsIgnoreCase("ios")){
            if (application.equalsIgnoreCase("bank")){
                DynamicDeviceAllocation(platform.toLowerCase(),mobileProps.getProperty("bank_androidApplicationName"), mobileProps.getProperty("bank_androidActivity"), mobileProps.getProperty("bank_androidPackage"),mobileProps.getProperty("bank_iosApplicationName"),mobileProps.getProperty("bank_bundleID"));
            }else if (application.equalsIgnoreCase("customer")){
                DynamicDeviceAllocation(platform.toLowerCase(),mobileProps.getProperty("customer_androidApplicationName"), mobileProps.getProperty("customer_androidActivity"), mobileProps.getProperty("customer_androidPackage"),mobileProps.getProperty("customer_iosApplicationName"),mobileProps.getProperty("customer_bundleID"));
            }else {
                Assert.fail("Please provide valid testNG parameter");
            }
        }else if (platform.equalsIgnoreCase("web")){
            if (application.equalsIgnoreCase("bank")){
                browserInitialization(props.getProperty("bank_url"));
            }else if (application.equalsIgnoreCase("customer")){
                browserInitialization(props.getProperty("corporateUrl"));
            }else {
                Assert.fail("Please provide valid testNG parameter");
            }
        }else {
            Assert.fail("Please provide valid testNG parameter");
        }
    }

    private void browserInitialization(String url) throws Exception {
        TestBase.initialization(props.getProperty("browser"));
        TestBase.getDriver().get(url);
        TestBase.getDriver().manage().deleteAllCookies();
        TestBase.getDriver().manage().window().maximize();
        TestBase.getDriver().navigate().refresh();
        LOGGER.info("Browser Started");
    }

    private void DynamicDeviceAllocation(String platform,String androidApplicationName,String activityName, String packageName,String iosApplicationName,String bundleName) throws Exception {
        if (mobileProps.getProperty("real_device").equalsIgnoreCase("true")) {
            mobileConnection.setRealDeviceCapabilities(platform, mobileProps.getProperty("android_realDeviceName"), "appium", mobileProps.getProperty("android_apk_location"), activityName, packageName, mobileProps.getProperty("appium_url"), mobileProps.getProperty("noReset"), mobileProps.getProperty("orientation"));
        } else {
            for (int i = 1; i <= Integer.parseInt(mobileProps.getProperty("no_devices")); i++) {
                String applicationName, automatorName, version;
                if (platform.equalsIgnoreCase("ios")) {
                    deviceName = mobileProps.getProperty("ios_device" + i);
                    applicationName = iosApplicationName;
                    automatorName = mobileProps.getProperty("ios_automatorName");
                    version = "";
                    if (appiumDriver == null) {
                        mobileConnection.set_Hybrid_PcloudyDeviceCapabilities(mobileProps.getProperty("pcloudyUsername"), mobileProps.getProperty("pcloudyApikey"), platform, version, deviceName, automatorName, applicationName, activityName, packageName, bundleName, mobileProps.getProperty("maxDuration"), mobileProps.getProperty("deviceURL"), mobileProps.getProperty("orientation"), Boolean.valueOf(mobileProps.getProperty("isTrustedDevice")), targetCompanyName, trustCompanyName, trustBtn);
                    }else {
                        mobileConnection.set_Hybrid_PcloudyDeviceCapabilities(mobileProps.getProperty("pcloudyUsername"), mobileProps.getProperty("pcloudyApikey"), platform, version, deviceName, automatorName, mobileProps.getProperty("customer_pcloudyAppLocation"), activityName, packageName, bundleName, mobileProps.getProperty("maxDuration"), mobileProps.getProperty("deviceURL"), mobileProps.getProperty("orientation"), Boolean.valueOf(mobileProps.getProperty("isTrustedDevice")), targetCompanyName, trustCompanyName, trustBtn);
                    }
                } else {
                    deviceName = mobileProps.getProperty("android_device" + i);
                    applicationName = androidApplicationName;
                    automatorName = mobileProps.getProperty("android_automatorName");
                    version = mobileProps.getProperty("android_device_version");
                    mobileConnection.setRemoteDeviceCapabilities(mobileProps.getProperty("pcloudyUsername"), mobileProps.getProperty("pcloudyApikey"), platform, version, deviceName, automatorName, applicationName, activityName, packageName, bundleName,
                            mobileProps.getProperty("maxDuration"), mobileProps.getProperty("deviceURL"), mobileProps.getProperty("orientation"), Boolean.valueOf(mobileProps.getProperty("isTrustedDevice")), targetCompanyName, trustCompanyName, trustBtn);
                }
                System.out.println(deviceName);
                if (appiumDriver != null) {
                    break;
                }
            }
        }
        if (appiumDriver == null) {
            Assert.fail("Devices are failed to connect");
        } else {
            System.out.println("Device connected");
        }
        TestBase.setDriver(appiumDriver);
    }

    public static void main(String[] args) throws Exception {
        MultiPlatformConnection multiPlatformConnection = new MultiPlatformConnection();
        multiPlatformConnection.IOSconnection();
    }
    public void IOSconnection() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "sweety.r@i-exceed.com");
        capabilities.setCapability("pCloudy_ApiKey", "snvpt3jvspnjzcgcbh9q3r5m");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
//        capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPad9.7(5thGen)_iOS_14.2.0_b2772");
//        capabilities.setCapability("platformVersion", "14.2.0");
        capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPadPro9.7_iOS_15.5.0_56431");
        capabilities.setCapability("platformVersion", "15.5.0");
//        capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPad9.7_iOS_14.4.0_a1d17");
//        capabilities.setCapability("platformVersion", "14.4.0");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("acceptAlerts", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("pCloudy_ApplicationName", "BankFacingApp-deve.ipa");
        capabilities.setCapability("bundleId", "com.iexceed.dbbankapp");
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("orientation", "LANDSCAPE");
//        capabilities.setCapability("orientation", "PORTRAIT");

//        capabilities.setCapability("wdaStartupRetries", "5");
        capabilities.setCapability("autoWebview", true);
//        capabilities.setCapability("pCloudy_EnableVideo", "true");
//        capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
//        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        capabilities.setCapability("webviewConnectTimeout", 15000);
//        capabilities.setCapability("webviewConnectRetries", "20");
        capabilities.setCapability("ensureWebviewsHavePages",true);

        appiumDriver =new IOSDriver<WebElement>(new URL("https://us.pcloudy.com/appiumcloud/wd/hub"), capabilities);

        TestBase.setDriver(appiumDriver);

        iosUtility = new IOSUtility();

        Thread.sleep(5);
        try {
            appiumDriver.findElement(By.xpath("//*[@name='Allow Once']")).click();
        }catch (Exception e){
            iosUtility.screenshot("no permission");
        }

        iosUtility.screenshot("permission");

//        iosUtility.webViewConverter();
        String title;

        try {
            title = TestBase.getDriver().findElement(By.id("bfplog__Login__element_button_1")).getText();
        }catch (Exception e){
            System.out.println(e);
            title ="Native : "+ appiumDriver.findElement(By.xpath("//*[@name='Hyperlink']")).getText();
        }

        System.out.println("Title : "+title);

        TestBase.setDriver(appiumDriver);

//        appiumDriver.findElementByName("Allow").click();

    }



}