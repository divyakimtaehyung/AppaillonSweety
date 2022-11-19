package com.iexceed.uiframework.runners;
import com.iexceed.uiframework.stepDefinitions.CustomerFacing.Hooks;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/Bank/2FA_TRUE/2_UM_BankadminCreation_byBankadmin.feature",
        glue = {"com.iexceed.uiframework.stepDefinitions.BankFacing"},
        tags= "@2",
        plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/jsonReports/cucumber-reports.json", "html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }

)


public class TestRunner extends Hooks {
    private TestNGCucumberRunner testNGCucumberRunner;
    public static String multiPlatform;
    public static String Application;
    public static String appLanguage;

    @BeforeMethod()
    @Parameters({"platform", "application","language"})
    public static void platform_set(String platform, String application,String language) throws Exception {
        multiPlatform = platform;
        Application=application;
        appLanguage = language;
        System.out.println("PLATFORM : " + platform);
        System.out.println("Application : " + application);
        System.out.println("Language : "+language);
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


}