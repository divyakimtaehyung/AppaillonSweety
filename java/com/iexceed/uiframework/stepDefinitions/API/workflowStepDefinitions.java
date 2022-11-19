package com.iexceed.uiframework.stepDefinitions.API;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.API.workFlowActions;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import com.iexceed.uiframework.utilites.readexcel.TestDataHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.DataBaseUtillity.qaWorkFlow_get_version;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class workflowStepDefinitions extends TestBase {
    public static Map<String, String> dataList;
    private static Logger LOGGER = LogManager.getLogger(workflowStepDefinitions.class);
    TestDataHandler testdata = new TestDataHandler();
    workFlowActions workFlowActions = new workFlowActions();
    public static String tenetID;
    public static int corpID;


    @Given("set API URI and headers (.+)$")
    public void set_api_uri_and_headers_db_tc(String testcase) throws Exception {
        LOGGER.info("a party-onboarding POST API endpoint");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"), "application/json");
        testdata.setTestDataInMap(dataList);
    }

    @Then("^a POST API endpoint for workflow mapping (.+)$")
    public void a_post_api_endpoint_for_workflow_mapping(String testcase) {
        LOGGER.info("POST API endpoint for workflow mapping");
    }


    @When("^user sets the header params with record having ADDINT as status and sends DELETE request(.+)$")
    public void user_sets_the_header_params_with_record_having_addint_as_status_and_sends_delete_request(String testcase) throws Throwable {
        LOGGER.info("PUT API endpoint for workflow mapping");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        //creating record
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();
        //authozing the record
        addauth_authorize_the_record();
        //initiating delete record
        enters_delint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body();
        workFlowActions.getStatusCode(200);
    }

    @And("^sets the header params with record having ADDAUT as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_addaut_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having ADDREJ as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_addrej_as_status_and_sends_delete_request(String testcase) throws Throwable {

        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having MODINT as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_modint_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having MODAUT as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_modaut_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having MODREJ as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_modrej_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having DELAUT as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_delaut_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @And("^sets the header params with record having DELREJ as status and sends DELETE request(.+)$")
    public void sets_the_header_params_with_record_having_delrej_as_status_and_sends_delete_request(String testcase) throws Throwable {

        //initiating delete record
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

//passing invalid actons in delete request
        workFlowActions.getStatusCode(400);
        int version2 = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version2, dataList.get("remarks"));

    }

    @Given("^a PUT API endpoint for workflow mapping (.+)$")
    public void a_put_api_endpoint_for_workflow_mapping(String testcase) throws Exception {
        LOGGER.info("PUT API endpoint for workflow mapping");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();
    }

    @Given("^a DELETE API endpoint for Intiate workflow mapping (.+)$")
    public void a_delete_api_endpoint_for_intiate_workflow_mapping(String testcase) throws Exception {
        LOGGER.info("PUT API endpoint for workflow mapping");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        //creating record
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();
        //authozing the record
        addauth_authorize_the_record();
        //initiating delete record
//        enters_delint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body();
//        workFlowActions.getStatusCode(200);

    }

    @Given("^a DELETE API endpoint for workflow mapping (.+)$")
    public void a_delete_api_endpoint_for_workflow_mapping(String testcase) throws Exception {
        LOGGER.info("PUT API endpoint for workflow mapping");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        //creating record
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();
        //authozing the record
        addauth_authorize_the_record();
        //initiating delete record
        enters_delint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body();
        workFlowActions.getStatusCode(200);
    }

    @And("^enters Bank Admin Initiator in actionBy and valid details in other headers$")
    public void enters_bank_admin_initiator_in_actionby_and_valid_details_in_other_headers() {
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
    }

    @And("^enters Bank Admin authorizer unfit with the entered tenant in actionBy and valid details in other headers$")
    public void enters_bank_admin_authorizer_unfit_with_the_entered_tenant_in_actionby_and_valid_details_in_other_headers() {
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version, dataList.get("remarks"));

    }


    @And("^enters modify initiated workflow in id and valid details in other headers$")
    public void enters_modify_initiated_workflow_in_id_and_valid_details_in_other_headers() {
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version, dataList.get("remarks"));

    }


    @And("^enters valid details in all headers _DELETE$")
    public void enters_valid_details_in_all_headers_delete() {
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version, dataList.get("remarks"));

    }

    @And("^enters add initiated workflow in id and valid details in other headers$")
    public void enters_add_initiated_workflow_in_id_and_valid_details_in_other_headers() {
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.set_DELETE_QueryParams(String.valueOf(corpID), tenetID, dataList.get("actionBy_Delete"), version, dataList.get("remarks"));
        workFlowActions.delete_workflow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID + "9", dataList.get("actionBy_Delete"), version, dataList.get("remarks"));

    }

    @And("^sends DELETE request$")
    public void sends_delete_request() {

    }

    @Then("^ADDAUTH authorize the record$")
    public void addauth_authorize_the_record() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
        workFlowActions.getStatusCode(200);
    }

    @Then("^ADDAUTH and DELINT the record$")
    public void addauth_and_delint_the_record() {
        addauth_authorize_the_record();
        enters_delint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body();
        workFlowActions.getStatusCode(200);
    }

    @Then("^ADDAUTH and MODINT the record$")
    public void addauth_and_modint_the_record() {
        addauth_authorize_the_record();
        enters_modint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body();
        workFlowActions.getStatusCode(200);
    }

    @And("^enters MODAUT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_modaut_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODAUT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_modaut_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODAUT in action and Bank Admin authorizer Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_modaut_in_action_and_bank_admin_authorizer_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODAUT in action and super admin in actionBy and fill valid details in other fields of request body$")
    public void enters_modaut_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODREJ in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_modrej_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }


    @And("^enters MODREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_modrej_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODREJ in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_modrej_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODREJ in action and super admin in actionBy and fill valid details in other fields of request body$")
    public void enters_modrej_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters DELINT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_delint_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters DELINT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_delint_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters DELINT in action and Bank Admin initiator Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_delint_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters DELINT in action and super admin in actionBy and fill valid details in other fields of request body$")
    public void enters_delint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters DELREJ in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_delrej_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters DELREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_delrej_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters DELREJ in action and Bank Admin Initiator authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_delrej_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters DELREJ in action and Super Admin in actionBy and fill valid details in other fields of request body$")
    public void enters_delrej_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid code in request body(.+)$")
    public void enters_invalid_code_in_request_body(String testcase) {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters invalid id in request body (.+)$")
    public void enters_invalid_id_in_request_body(String testcase) {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters invalid description in the request body$")
    public void enters_invalid_description_in_the_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters invalid workflowKey in request body$")
    public void enters_invalid_workflowkey_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters valid data in code and other fields in request body$")
    public void enters_valid_data_in_code_and_other_fields_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters valid id which is not linked with the given code in request body$")
    public void enters_valid_id_which_is_not_linked_with_the_given_code_in_request_body() {
        LOGGER.info("enters valid id which is not linked with the given code in request body");
    }

    @And("^And enters valid data in request body$")
    public void and_enters_valid_data_in_request_body() {
        LOGGER.info("And enters valid data in request body");
    }

    @And("^enters valid tenant_Y in request body$")
    public void enters_valid_tenanty_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters valid bank admin authorizer in actionBy field and valid data in other fields$")
    public void enters_valid_bank_admin_authorizer_in_actionby_field_and_valid_data_in_other_fields() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters valid Bank Admin Initiator and Authorizer in actionBy field and valid data in request body$")
    public void enters_valid_bank_admin_initiator_and_authorizer_in_actionby_field_and_valid_data_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters invalid tenant in request body$")
    public void enters_invalid_tenant_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters invalid actionBy in request body$")
    public void enters_invalid_actionby_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @Then("^receives 2xx HTTP success code$")
    public void receives_2xx_http_success_code() {
        LOGGER.info("receives 2xx HTTP success code");
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode")));
    }

    @Then("^system receives 2xx HTTP success code$")
    public void system_receives_2xx_http_success_code() {
        LOGGER.info("receives 2xx HTTP success code");
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode1")));
    }

    @When("^user sets the header params and invalid data in authFromDt (.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_authfromdt(String testcase) throws Exception {
        //authorizing the record-put
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode1")));
//get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_Authdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date + "123"));
        workFlowActions.get_workflowDetails_withAuthDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date + "123"));

    }

    @When("^user sets the header params and valid data in authToDt (.+)$")
    public void user_sets_the_header_params_and_valid_data_in_authtodt(String testcase) throws Exception {
        //get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_AuthorizeTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date));
        workFlowActions.get_workflowDetails_withAuthToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date));

    }

    @When("^user sets the header params and invalid data in authToDt (.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_authtodt(String testcase) throws Exception {
        //authorizing the record-put
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode1")));
//get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_AuthorizeTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf("kim" + date));
        workFlowActions.get_workflowDetails_withAuthToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf("kim" + date));

    }

    @When("^user sets the header params and valid data in authToDt,authFromDate (.+)$")
    public void user_sets_the_header_params_and_valid_data_in_authtodtauthfromdate(String testcase) throws Exception {
        //get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_AuthorizeTodate(String.valueOf(corpID), tenetID);
        Date date1 = qaWorkFlow_get_version.get_Authdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthinitiateDate_AuthteToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date), String.valueOf(date1));
        workFlowActions.get_workflowDetails_AuthInitiate_withAuthToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date), String.valueOf(date1));

    }

    @When("^user sets invalid params in the header$")
    public void user_sets_invalid_params_in_the_header() {
        //get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language") + "1234", dataList.get("accept") + "5657", dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status);
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status);

    }

    @When("^user sets valid params in the header(.+)$")
    public void user_sets_valid_params_in_the_header(String testcase) throws Exception {

        //get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status);
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status);

    }

    @When("^user sets the header params and invalid data in authToDt,authFromDate (.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_authtodtauthfromdate(String testcase) throws Exception {
        //authorizing the record-put
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode1")));

        //get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_AuthorizeTodate(String.valueOf(corpID), tenetID);
        Date date1 = qaWorkFlow_get_version.get_Authdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthinitiateDate_AuthteToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf("kim" + date), String.valueOf("kim" + date1));
        workFlowActions.get_workflowDetails_AuthInitiate_withAuthToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf("kim" + date), String.valueOf("kim" + date1));

    }

    @When("^user sets the header params and valid data in authFromDt (.+)$")
    public void user_sets_the_header_params_and_valid_data_in_authfromdt(String testcase) throws Exception {

//get record details
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_Authdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_AuthDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date));
        workFlowActions.get_workflowDetails_withAuthDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date));

    }

    @When("^user sets the header params and invalid data in initFromDt(.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_initfromdt(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_fromdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date + "123"));
        workFlowActions.get_workflowDetails_withInitaiteDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date + "123"));

    }

    @When("^user sets the header params and invalid data in initToDt(.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_inittodt(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Timestamp date = qaWorkFlow_get_version.get_InitiatedTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date + "123"));
        workFlowActions.get_workflowDetails_withInitaiteDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date + "123"));

    }

    @When("^user sets the header params and invalid data initFromDt and initToDt (.+)$")
    public void user_sets_the_header_params_and_invalid_data_initfromdt_and_inittodt(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_fromdate(String.valueOf(corpID), tenetID);
        Timestamp date1 = qaWorkFlow_get_version.get_InitiatedTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_initiateToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date + "123"), String.valueOf(date1));
        workFlowActions.get_workflowDetails_withInitaiteDate_InitiateToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date + "123"), String.valueOf(date1 + "123"));

    }

    @When("^user sets the header params and valid data initFromDt and initToDt (.+)$")
    public void user_sets_the_header_params_and_valid_data_initfromdt_and_inittodt(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_fromdate(String.valueOf(corpID), tenetID);
        Timestamp date1 = qaWorkFlow_get_version.get_InitiatedTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_initiateToDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date), String.valueOf(date1));
        workFlowActions.get_workflowDetails_withInitaiteDate_InitiateToDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date), String.valueOf(date1));

    }

    @When("^user sets the header params and valid data in initToDt(.+)$")
    public void user_sets_the_header_params_and_valid_data_in_inittodt(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Timestamp date = qaWorkFlow_get_version.get_InitiatedTodate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date));
        workFlowActions.get_workflowDetails_withInitaiteDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date));

    }

    @When("^user sets the header params and valid data in initFromDt(.+)$")
    public void user_sets_the_header_params_and_valid_data_in_initfromdt(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        Date date = qaWorkFlow_get_version.get_fromdate(String.valueOf(corpID), tenetID);
        workFlowActions.set_initiateDate_QueryParams(String.valueOf(corpID), tenetID, String.valueOf(date));
        workFlowActions.get_workflowDetails_withInitaiteDate(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, String.valueOf(date));

    }

    @Then("^system receives 2xx HTTP success code _DELETE$")
    public void system_receives_2xx_http_success_code_delete() {
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("Expectedresponse2")));
    }

    @And("^receives a valid workflow keys as response$")
    public void receives_a_valid_workflow_keys_as_response() {
        workFlowActions.getResponse();
    }

    @And("^enters valid Super Admin in actionBy field and valid data in other fields request body$")
    public void enters_valid_super_admin_in_actionby_field_and_valid_data_in_other_fields_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^enters deleted workflow in tenant and valid data in other fields of request body$")
    public void enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
        corpID = Integer.valueOf(dataList.get("id"));
        tenetID = dataList.get("tenant");
    }

    @And("^enters invalid description in request body _PUT$")
    public void enters_invalid_description_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), "", dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid workflowKey in request body _PUT$")
    public void enters_invalid_workflowkey_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), "jackJAck", "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid action in request body _PUT$")
    public void enters_invalid_action_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), "jackJAck", "$%4",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid actionBy in request body _PUT$")
    public void enters_invalid_actionby_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), "jackJAck", "ADDAUT",
                "jackRipper", Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid version in request body _PUT$")
    public void enters_invalid_version_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), "jackJAck", "ADDAUT",
                dataList.get("actionBy"), 4, dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid remarks in request body _PUT$")
    public void enters_invalid_remarks_in_request_body_put() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), "jackJAck", "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), " (*)", String.valueOf(corpID), tenetID);

    }

    @And("^enters invalid action in request body$")
    public void enters_invalid_action_in_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDAUTH in action and Bank Admin authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_addauth_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @When("^user sets the header params with record having ADDINT as status$")
    public void user_sets_the_header_params_with_record_having_addint_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDINT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODINT in action in of request body and sends PUT request$")
    public void enters_modint_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODINT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODAUT in action in of request body and sends PUT request$")
    public void enters_modaut_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @When("^user sets the header params with record having ADDAUT as status$")
    public void user_sets_the_header_params_with_record_having_addaut_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @When("^user sets the header params with record having DELREJ as status$")
    public void user_sets_the_header_params_with_record_having_delrej_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters ADDAUT in action in of request body and sends PUT request$")
    public void enters_addaut_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }


    @When("^user sets the header params with record having DELINT as status$")
    public void user_sets_the_header_params_with_record_having_delint_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @When("^user sets the header params with record having MODAUT as status$")
    public void user_sets_the_header_params_with_record_having_modaut_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODAUT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @When("^user sets the header params with record having MODINT as status$")
    public void user_sets_the_header_params_with_record_having_modint_as_status() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODINT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDREJ in action in of request body and sends PUT request$")
    public void enters_addrej_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "ADDREJ",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters MODREJ in action in of request body and sends PUT request$")
    public void enters_modrej_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODREJ",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }


    @When("^user sets the header params with record having ADDINT as status and sends POST request(.+)$")
    public void user_sets_the_header_params_with_record_having_addint_as_status_and_sends_post_request(String testcase) throws Throwable {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();
    }


    @And("^enters DELINT in action in of request body and sends PUT request$")
    public void enters_delint_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELINT",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters DELREJ in action in of request body and sends PUT request$")
    public void enters_delrej_in_action_in_of_request_body_and_sends_put_request() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "DELREJ",
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDAUTH in action and Bank Admin Initiator in actionBy and valid details in other fields of request body$")
    public void enters_addauth_in_action_and_bank_admin_initiator_in_actionby_and_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDAUTH in action and super admin in actionBy and fill valid details in other fields of request body$")
    public void enters_addauth_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters ADDREJ in action and super admin in actionBy and fill valid details in other fields of request body$")
    public void enters_addrej_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_addrej_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters ADDREJ in action and Bank Admin authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_addrej_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters ADDREJ in action and Bank Admin initiator authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_addrej_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODINT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body$")
    public void enters_modint_in_action_and_bank_admin_initiator_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODINT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_modint_in_action_and_bank_admin_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODINT in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_modint_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters MODINT in action and Super Admin in actionBy and fill valid details in other fields of request body$")
    public void enters_modint_in_action_and_super_admin_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        int version = qaWorkFlow_get_version.getVersion(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), "MODINT",
                dataList.get("actionBy_PUT"), version, dataList.get("remarks"), String.valueOf(corpID), tenetID);
    }

    @And("^enters ADDAUTH in action and Bank Admin initiator authorizer in actionBy and fill valid details in other fields of request body$")
    public void enters_addauth_in_action_and_bank_admin_initiator_authorizer_in_actionby_and_fill_valid_details_in_other_fields_of_request_body() {
        workFlowActions.setPathParams(String.valueOf(corpID), tenetID);
        workFlowActions.Put_updateWorkFlow(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), dataList.get("description"), dataList.get("workflowKey"), dataList.get("action"),
                dataList.get("actionBy"), Integer.valueOf(dataList.get("version")), dataList.get("remarks"), String.valueOf(corpID), tenetID);

    }

    @And("^enters existing workflow in tenant and valid data in other fields of request body$")
    public void enters_existing_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @Given("^a GET API endpoint for workflow mapping (.+)$")
    public void a_get_api_endpoint_for_workflow_mapping(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        workFlowActions.getStatusCode(201);
    }

    @Given("^a GET API endpoint sets header params and invalid data in prodDesc for workflow mapping (.+)$")
    public void a_get_api_endpoint_sets_header_params_and_invalid_data_in_proddesc_for_workflow_mapping(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String desc = qaWorkFlow_get_version.getDescription(String.valueOf(corpID), tenetID);
        workFlowActions.set_Description_QueryParams(String.valueOf(corpID), tenetID, desc + "kim");
        workFlowActions.get_workflowDetails_withDesc(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, desc + "kim");

    }

    @When("^user sets the header params and invalid data in status (.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_status(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status + "kim");
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status + "kim");

    }

    @When("^user sets the header params and valid data in status(.+)$")
    public void user_sets_the_header_params_and_valid_data_in_status(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status);
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status);

    }

    @When("^user sets the header params and invalid data in code (.+)$")
    public void user_sets_the_header_params_and_invalid_data_in_code(String testcase) throws Exception {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status + "kim");
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status + "kim");

    }

    @When("^user sets the header params and valid data in code (.+)$")
    public void user_sets_the_header_params_and_valid_data_in_code(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String status = qaWorkFlow_get_version.get_Status(String.valueOf(corpID), tenetID);
        workFlowActions.set_Status_QueryParams(String.valueOf(corpID), tenetID, status);
        workFlowActions.get_workflowDetails_withStatus(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, status);

    }

    @When("^user sets the header params and valid data in prodDesc _GET (.+)$")
    public void user_sets_the_header_params_and_valid_data_in_proddesc_get(String testcase) throws Exception {
        set_api_uri_and_headers_db_tc(testcase);
        //creating api using post
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        enters_deleted_workflow_in_tenant_and_valid_data_in_other_fields_of_request_body();
        receives_2xx_http_success_code();

        //get response
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        String desc = qaWorkFlow_get_version.getDescription(String.valueOf(corpID), tenetID);
        workFlowActions.set_Description_QueryParams(String.valueOf(corpID), tenetID, desc);
        workFlowActions.get_workflowDetails_withDesc(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID, desc);


    }

    @When("^user sends the GET request$")
    public void user_sends_the_get_request() {
        workFlowActions.setEndpoint(props.getProperty("BaseURI"), props.getProperty("EndPoint"));
        workFlowActions.setHeaders_GETAPICALL(dataList.get("Accept-Language"), dataList.get("accept"), dataList.get("X-REQUEST-ID"));
        workFlowActions.setQueryParams(String.valueOf(corpID), tenetID);
        workFlowActions.get_workflowDetails(props.getProperty("BaseURI"), props.getProperty("EndPoint"), props.getProperty("Path"), corpID, tenetID);
    }

    @When("^user sends prodDesc the GET request$")
    public void user_sends_proddesc_the_get_request() {

    }

    @And("^enters valid bank admin initiator in actionBy field and valid data in request body$")
    public void enters_valid_bank_admin_initiator_in_actionby_field_and_valid_data_in_request_body() {
        workFlowActions.Post_createNewWorkFlow(props.getProperty("Path"), dataList.get("CorporateType"), Integer.valueOf(dataList.get("id")), dataList.get("description"), dataList.get("workflowKey"), dataList.get("tenant"), dataList.get("actionBy"));
    }

    @And("^sends POST request(.+)$")
    public void sends_post_request(String testcase) {
        LOGGER.info("sends POST request");
    }

    @And("^sends PUT request$")
    public void sends_put_request() {
        LOGGER.info("sends PUT request");
    }

    @Then("^system receives 4xx HTTP error code$")
    public void system_receives_4xx_http_error_code() {
        LOGGER.info("system receives 4xx HTTP error code");
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode")));
    }

    @Then("^receives 4xx HTTP error code$")
    public void receives_4xx_http_error_code() {
        LOGGER.info("system receives 4xx HTTP error code");
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode1")));
    }

    @Then("^Delete receives 4xx HTTP error code$")
    public void delete_receives_4xx_http_error_code() {
        workFlowActions.getStatusCode(Integer.parseInt(dataList.get("Expectedresponse2")));
    }

    @And("^receives a valid application error response$")
    public void receives_a_valid_application_error_response() {
        LOGGER.info("receives a valid application error response");
    }

    @And("^receives a valid application success response$")
    public void receives_a_valid_application_success_response() {
        LOGGER.info("receives a valid application success response");
    }
}

