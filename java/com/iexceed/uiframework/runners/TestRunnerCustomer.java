package com.iexceed.uiframework.runners;

import com.iexceed.uiframework.stepDefinitions.CustomerFacing.Hooks;
import io.cucumber.testng.*;
import org.testng.annotations.*;
import uiframework.DomainObjects.MultiPlatformConnection;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

@CucumberOptions(
        features = "src/test/resources/feature/Corporate/2FA_TRUE/",
        glue = {"com.iexceed.uiframework.stepDefinitions.CustomerFacing"},
        tags= "@DB-TC-38",
        plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/jsonReports/cucumber-reports.json","html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }
)
// @DB-TC-46 or
public class TestRunnerCustomer extends Hooks {
    private TestNGCucumberRunner testNGCucumberRunner;

    public static String multiPlatform;
    public static String appLanguage;

    @BeforeMethod()
    @Parameters({"platform","application","language"})
    public static void platform_set(String platform,String application,String language) throws Exception {
        multiPlatform = platform;
        appLanguage = language;
        System.out.println("PLATFORM : "+platform);
        System.out.println("Application : "+application);
        System.out.println("Language : "+language);
        MultiPlatformConnection mc = new MultiPlatformConnection();
        mc.platformConnection(platform,application);
        System.out.println("Browser Initialized");
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(PickleWrapper eventwrapper, FeatureWrapper cucumberFeature) throws Throwable {
        //testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runScenario(eventwrapper.getPickle());
    }

    @DataProvider//(parallel=true)
    public Object[][] features() {
        // return testNGCucumberRunner.provideFeatures();
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass()  {
        testNGCucumberRunner.finish();
    }

    @AfterTest()
    public void closeBrowser(){
        if (multiPlatform.equalsIgnoreCase("web")){
            webdriver.get().quit();
        }else{
            System.out.println("No needed browser close");
        }
    }
}
