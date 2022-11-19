package com.iexceed.uiframework.stepDefinitions.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.BankFacing.DashboardActions;
import com.iexceed.uiframework.steps.BankFacing.WorkFlowMngMntActions;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.iexceed.uiframework.runners.TestRunner.multiPlatform;

public class workFlowPageStepDef extends TestBase {

    public static Map<String, String> dataRead;
    private static Logger LOGGER = LogManager.getLogger(workFlowPageStepDef.class);
    WorkFlowMngMntActions workFlowMngMntActions=new WorkFlowMngMntActions(multiPlatform);
    @When("^clicks on workflow management from LHS Menu$")
    public void clicks_on_workflow_management_from_lhs_menu() throws Exception {
        DashboardActions dashboardActions=new DashboardActions(multiPlatform);
        dashboardActions.navigateWorkFlow();
    }

    @Then("^lands on workflow management summary screen$")
    public void lands_on_workflow_management_summary_screen() throws Exception {
        workFlowMngMntActions.is_workflow_managementScreen_displayed();
    }
    @When("^admin clicks on add button(.+)$")
    public void admin_clicks_on_add_button(String testcase) throws Exception {
        workFlowMngMntActions.click_add_button();
    }
    @Then("^system lands on Workflow Management add initiate screen$")
    public void system_lands_on_workflow_management_add_initiate_screen() throws Exception {
        workFlowMngMntActions.workFlow_initiate_Screen_dispalyed();
    }
    @When("^enters valid details in all the mandatory fields and clicks on Save button(.+)$")
    public void enters_valid_details_in_all_the_mandatory_fields_and_clicks_on_save_button(String testcase) throws Exception {
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        workFlowMngMntActions.enerWorkFlowDetails(dataRead.get("CorporateType"),dataRead.get("WorkFlowType"));
        workFlowMngMntActions.click_save_Btn();
    }
    @Then("^admin lands on confirmation screen$")
    public void admin_lands_on_confirmation_screen() throws Exception {
       LOGGER.info("admin lands on confirmation screen");
    }
    @When("^admin clicks confirm$")
    public void admin_clicks_confirm() throws Exception {
        workFlowMngMntActions.click_confirmBtn();
    }

}