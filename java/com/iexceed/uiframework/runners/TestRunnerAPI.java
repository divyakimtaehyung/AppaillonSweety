package com.iexceed.uiframework.runners;
import com.iexceed.uiframework.stepDefinitions.CustomerFacing.Hooks;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/API/Workflow_Management_API.feature",
        glue = {"com.iexceed.uiframework.stepDefinitions.API"},
        tags= "@83",
        plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/jsonReports/cucumber-reports.json", "html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }

)


public class TestRunnerAPI extends Hooks {
    private TestNGCucumberRunner testNGCucumberRunner;



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
