package com.iexceed.uiframework.stepDefinitions.CustomerFacing;

import com.iexceed.uiframework.steps.CustomerFacing.DashboardAction;
import io.cucumber.java.en.Then;

import static com.iexceed.uiframework.runners.TestRunnerCustomer.multiPlatform;


public class DashboardDefinitions {

    DashboardAction dashboardAction;

    @Then("^user lands on the Dashboard page$")
    public void user_lands_on_the_dashboard_page() throws Exception {
        dashboardAction = new DashboardAction(multiPlatform);
        dashboardAction.verifyDashboard();
    }
}
