package com.iexceed.uiframework.stepDefinitions.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.BankFacing.DashboardActions;
import com.iexceed.uiframework.steps.BankFacing.UserCreationAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.BankFacing.Web.UserCreation;

import java.util.Map;

import static com.iexceed.uiframework.runners.TestRunner.multiPlatform;

public class dashboardPageStepDef extends TestBase {

    private static Logger LOGGER = LogManager.getLogger(dashboardPageStepDef.class);

    @When("^admin clicks on the User Management link from LHS (.+)$")
    public void admin_clicks_on_the_user_management_link_from_lhs(String testcase) throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        LOGGER.debug("user in dashboard page");
        dashboardActions.navigateUserMngMntPage();
    }

    @Then("^admin lands on the User Management summary page$")
    public void admin_lands_on_the_user_management_summary_page() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.isUserDetailsPage();
    }


    @And("^super admin is navigated to the User Management summary screen$")
    public void super_admin_is_navigated_to_the_user_management_summary_screen(){
        LOGGER.debug("super admin is navigated to the User Management summary screen");
    }

    @And("^clicks on Add button from User Management summary screen$")
    public void clicks_on_add_button_from_user_management_summary_screen() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        LOGGER.debug("user in dashboard page");
        dashboardActions.navigateUserMngMntPage();
    }

    @Then("^lands on User addition screen$")
    public void lands_on_user_addition_screen() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.isUserDetailsPage();
    }

    @And("^Previously entered data should get cleared from the User details section$")
    public void previously_entered_data_should_get_cleared_from_the_user_details_section(){
        LOGGER.debug("Previously entered data should get cleared from the User details section");
    }


    @When("^super admin clicks on logout$")
    public void super_admin_clicks_on_logout() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.logout_icon_validations();
    }
    @Then("^displayed with logout pop up$")
    public void displayed_with_logout_pop_up() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.is_logoutMsg_displayed();
    }

    @When("^clicks on Cancel$")
    public void clicks_on_cancel() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.click_cancel_btn();
    }

    @When("^clicks on Ok$")
    public void clicks_on_ok() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.click_ok_btn();
    }

    @When("^admin clicks on the User Management link from LHS$")
    public void admin_clicks_on_the_user_management_link_from_lhs() throws Exception {
        LOGGER.debug("user in dashboard page");
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.navigateUserMngMntPage();
    }

    @Then("^lands on User Management screen$")
    public void lands_on_user_management_screen() throws Exception{
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.isUserDetailsPage();
    }

    @When("^admin clicks on Add button from User Management summary screen$")
    public void admin_clicks_on_add_button_from_user_management_summary_screen() throws Exception{
        LOGGER.debug("admin clicks on the Add button");

    }
    @And("^bank admin is navigated to the User Management summary screen$")
    public void bank_admin_is_navigated_to_the_user_management_summary_screen(){
        LOGGER.debug("bank admin is navigated to the User Management summary screen");

    }

}