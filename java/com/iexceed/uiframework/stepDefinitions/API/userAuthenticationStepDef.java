package com.iexceed.uiframework.stepDefinitions.API;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.API.userAuthenticationActions;
import com.iexceed.uiframework.steps.API.workFlowActions;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import com.iexceed.uiframework.utilites.readexcel.TestDataHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class userAuthenticationStepDef extends TestBase {

    public static Map<String, String> dataList;
    private static Logger LOGGER = LogManager.getLogger(userAuthenticationStepDef.class);
    TestDataHandler testdata = new TestDataHandler();
    userAuthenticationActions userAuthenticationActions = new userAuthenticationActions();


    @Given("^a POST API endpoint for Authentication microservices (.+)$")
    public void a_post_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        LOGGER.info("a party-onboarding POST API endpoint");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("login_BaseURI"), props.getProperty("login_Endpoint"));
        userAuthenticationActions.setHeaders(dataList.get("Accept-Language"), dataList.get("X_TENENT_Auth"), dataList.get("Os_Type"));
        testdata.setTestDataInMap(dataList);
    }

    @Given("^a POST logout API endpoint for Authentication microservices (.+)$")
    public void a_post_logout_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("logOut_BaseURI"), props.getProperty("logOut_Endpoint"));
        userAuthenticationActions.set_logout_header(dataList.get("Accept-Language"), dataList.get("AccessToken"), dataList.get("refresh_token"), dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);
    }


    @Given("^refresh POST API endpoint for Authentication microservices (.+)$")
    public void refresh_post_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("refresh_acc_token_BaseURI"), props.getProperty("refresh_acc_token_Endpoint"));
        userAuthenticationActions.set_refresh_Header( dataList.get("refresh_token"), dataList.get("Accept-Language"),dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);

    }

    @And("^enters valid Authorization key and refresh_token of bank admin and valid data in logout request body(.+)$")
    public void enters_valid_authorization_key_and_refreshtoken_of_bank_admin_and_valid_data_in_logout_request_body(String testcase) {
        userAuthenticationActions.post_user_logout(props.getProperty("logOut_Path"));
    }


    @And("^enters invalid userId in logout post request body$")
    public void enters_invalid_userid_in_logout_post_request_body() {
        userAuthenticationActions.post_user_logout(props.getProperty("logOut_Path"));
    }

    @And("^enters invalid password in logout post request body$")
    public void enters_invalid_password_in_logout_post_request_body(){
        userAuthenticationActions.post_user_logout(props.getProperty("logOut_Path"));
    }

    @And("^enters valid OS-TYPE key of new bank admin and valid data in request body (.+)$")
    public void enters_valid_ostype_key_of_new_bank_admin_and_valid_data_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_userAuthentication_Login(props.getProperty("login_Path"), dataList.get("Username"), dataList.get("Password"));
    }

    @And("^enters valid refresh_token key of bank admin(.+)$")
    public void enters_valid_refreshtoken_key_of_bank_admin(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_Refesh_token("refresh_acc_token_Path");
    }

    @Given("^a OTP POST API endpoint for Authentication microservices (.+)$")
    public void a_otp_post_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        LOGGER.info("a party-onboarding POST API endpoint");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("OTP_BaseURI"), props.getProperty("OTP_Endpoint"));
        userAuthenticationActions.OTP_setHeaders(dataList.get("AccessToken"), dataList.get("Accept-Language"), dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);
    }

    @Given("^a OTP POST API endpoint for invalid Authentication key microservices (.+)$")
    public void a_otp_post_api_endpoint_for_invalid_authentication_key_microservices(String testcase) throws Exception {
        LOGGER.info("a party-onboarding POST API endpoint");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("OTP_BaseURI"), props.getProperty("OTP_Endpoint"));
        userAuthenticationActions.OTP_setHeaders(dataList.get("AccessToken") + "jkjk", dataList.get("Accept-Language"), dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);

    }

    @Given("^a PUT validate API endpoint for Authentication microservices (.+)$")
    public void a_put_validate_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("OTP_Validate_BaseURI"), props.getProperty("OTP_Validate_Endpoint"));
        userAuthenticationActions.OTP_setHeaders(dataList.get("AccessToken"), dataList.get("Accept-Language"), dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);

    }

    @Given("^a PUT API endpoint for Authentication microservices (.+)$")
    public void a_put_api_endpoint_for_authentication_microservices(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("apiSheetName"), testcase);
        userAuthenticationActions.setEndpoint(props.getProperty("OTP_Resent_BaseURI"), props.getProperty("OTP_Resent_Endpoint"));
        userAuthenticationActions.OTP_setHeaders(dataList.get("AccessToken"), dataList.get("Accept-Language"), dataList.get("X_TENENT_Auth"));
        testdata.setTestDataInMap(dataList);
    }

    @When("^user sends the POST login request (.+)$")
    public void user_sends_the_post_login_request(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_userAuthentication_Login(props.getProperty("login_Path"), dataList.get("Username"), dataList.get("Password"));
    }

    @Then("^system receives Http 2xx HTTP success code (.+)$")
    public void system_receives_http_2xx_http_success_code(String testcase) {
        userAuthenticationActions.getStatusCode(Integer.parseInt(dataList.get("ExpectedResponseCode")));
    }


    @And("^sends POST request$")
    public void sends_post_request() {
        LOGGER.info("sends post invalid request");
    }

    @And("^enters invalid userId in OTP request body (.+)$")
    public void enters_invalid_userid_in_otp_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId") + "jkkj", dataList.get("emailId"), dataList.get("mobileNumber"), dataList.get("appType"));
    }

    @And("^enters valid Authorization key of new bank admin and valid data in request (.+)$")
    public void enters_valid_authorization_key_of_new_bank_admin_and_valid_data_in_request(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId") + "jkkj", dataList.get("emailId"), dataList.get("mobileNumber"), dataList.get("appType"));
    }

    @And("^enters valid Authorization key of expired bank admin and valid data in request body(.+)$")
    public void enters_valid_authorization_key_of_expired_bank_admin_and_valid_data_in_request_body(String testcase) throws Throwable {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId") + "jkkj", dataList.get("emailId"), dataList.get("mobileNumber"), dataList.get("appType"));
    }

    @When("^user sets the header params$")
    public void user_sets_the_header_params() {

    }

    @And("^enters invalid userId in request body(.+)$")
    public void enters_invalid_userid_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId") + "invalid", Integer.parseInt(dataList.get("refNo")));
    }


    @And("^enters invalid refNo in request body(.+)$")
    public void enters_invalid_refno_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId"), Integer.parseInt(dataList.get("refNo") + "invalid"));
    }

    @And("^enters valid Authorization key of new bank admin and valid data in put request body(.+)$")
    public void enters_valid_authorization_key_of_new_bank_admin_and_valid_data_in_put_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId"), Integer.parseInt(dataList.get("refNo")));
    }

    @And("^enters valid Authorization key of expired bank admin and valid data in request (.+)$")
    public void enters_valid_authorization_key_of_expired_bank_admin_and_valid_data_in_request(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId"), Integer.parseInt(dataList.get("refNo")));
    }

    @And("^enters valid Authorization key of expired bank admin and valid data in resend request body(.+)$")
    public void enters_valid_authorization_key_of_expired_bank_admin_and_valid_data_in_resend_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId"), Integer.parseInt(dataList.get("refNo")));
    }

    @And("^enters invalid userId in validate request body(.+)$")
    public void enters_invalid_userid_in_validate_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId") + "jkl", dataList.get("otp"), Integer.parseInt(dataList.get("refNo")), dataList.get("requestType"), dataList.get("appType"));
    }

    @And("^enters invalid otp in request body(.+)$")
    public void enters_invalid_otp_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp") + "76", Integer.parseInt(dataList.get("refNo")), dataList.get("requestType"), dataList.get("appType"));
    }

    @And("^enters invalid refNo in put validate request body(.+)$")
    public void enters_invalid_refno_in_put_validate_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp"), Integer.parseInt(dataList.get("refNo") + "89"), dataList.get("requestType"), dataList.get("appType"));
    }

    @And("^enters invalid requestId in put validate request body(.+)$")
    public void enters_invalid_requestid_in_put_validate_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp"), Integer.parseInt(dataList.get("refNo")), dataList.get("requestType") + "io", dataList.get("appType"));
    }

    @And("^enters invalid appType in put validate request body(.+)$")
    public void enters_invalid_apptype_in_put_validate_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp"), Integer.parseInt(dataList.get("refNo")), dataList.get("requestType"), dataList.get("appType") + "jk");
    }

    @And("^enters valid Authorization key of bank admin and valid data in request body(.+)$")
    public void enters_valid_authorization_key_of_bank_admin_and_valid_data_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp"), Integer.parseInt(dataList.get("refNo")), dataList.get("requestType"), dataList.get("appType") + "jk");
    }

    @And("^enters invalid appType in request body(.+)$")
    public void enters_invalid_apptype_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_validateOtpRequest(props.getProperty("OTP_Validate_Path"), dataList.get("userId"), dataList.get("otp"), Integer.parseInt(dataList.get("refNo") + "89"), dataList.get("requestType"), dataList.get("appType"));
    }

    @And("^enters valid Authorization key of existing bank admin and valid data in request body(.+)$")
    public void enters_valid_authorization_key_of_existing_bank_admin_and_valid_data_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.put_OTPresent(props.getProperty("OTP_Resent_Path"), dataList.get("userId"), Integer.parseInt(dataList.get("refNo")));

    }

    @And("^enters invalid emailId in request body (.+)$")
    public void enters_invalid_emailid_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId"), dataList.get("emailId"), dataList.get("mobileNumber"), dataList.get("appType"));

    }

    @And("^enters invalid mobileNumber in request body (.+)$")
    public void enters_invalid_mobilenumber_in_request_body(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId"), dataList.get("emailId"), dataList.get("mobileNumber") + "kl", dataList.get("appType") + "kl");

    }

    @And("^enters invalid appType in request  (.+)$")
    public void enters_invalid_apptype_in_request(String testcase) throws Exception {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId"), dataList.get("emailId"), dataList.get("mobileNumber"), dataList.get("appType") + "kl");
    }

    @And("^enters invalid apiRequestMap in request body (.+)$")
    public void enters_invalid_apirequestmap_in_request_body(String testcase) throws Throwable {
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("apiFilePath"), props.getProperty("Authentication_apiSheetName"), testcase);
        userAuthenticationActions.Post_OTPGenerate(props.getProperty("OTP_Path"), dataList.get("userId"), dataList.get("emailId") + "jkjk", dataList.get("mobileNumber") + "kl", dataList.get("appType") + "kl");

    }

    @And("^receives a valid response$")
    public void receives_a_valid_response() {

    }

}
