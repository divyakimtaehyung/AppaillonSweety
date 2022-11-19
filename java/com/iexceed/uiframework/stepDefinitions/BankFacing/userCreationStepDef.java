package com.iexceed.uiframework.stepDefinitions.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.BankFacing.DashboardActions;
import com.iexceed.uiframework.steps.BankFacing.LoginPageActions;
import com.iexceed.uiframework.steps.BankFacing.UserCreationAction;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import com.iexceed.uiframework.utilites.readexcel.TestDataHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.DomainObjects.Mailinator.EmailVerification;
import uiframework.DomainObjects.Mailinator.MailAutomation;
import uiframework.DomainObjects.RandomGeneratorUtility;
import uiframework.DataBaseUtillity.DB_get_payload;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.iexceed.uiframework.appium.PcloudyConnection.reStartAppAndroid;
import static com.iexceed.uiframework.runners.TestRunner.appLanguage;
import static com.iexceed.uiframework.runners.TestRunner.multiPlatform;
import static uiframework.DataBaseUtillity.DB_get_payload.Password;


public class userCreationStepDef extends TestBase {

    private static Logger LOGGER = LogManager.getLogger(userCreationStepDef.class);
    public static Map<String, String> dataList;
    TestDataHandler testdata = new TestDataHandler();
    public static Map<String, String> dataRead;
    RandomGeneratorUtility random = new RandomGeneratorUtility();
    public String generatedPassword;
    MailAutomation mail = new MailAutomation();

    @When("^admin clicks on the Add button$")
    public void admin_clicks_on_the_add_button() throws Exception {
        LOGGER.debug("admin clicks on the Add button");
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.create_new_user();

    }

    @And("^enters all the mandatory and optional fields (.+)$")
    public void enters_all_the_mandatory_and_optional_fields(String testcase) throws Exception {
        admin_clicks_on_the_add_button();
        LOGGER.debug("enters all the mandatory and optional fields ");
        String userName = "bankadmn" + random.getNumber(2);
        String mailId = "bankadmn" + random.getTimeStamp() + "@mailinator.com";
        String mobileNum = "7" + random.getNumber(9);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName1", userName, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId1", mailId, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum1", mobileNum, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId1"), dataRead.get("mobileCode1"), dataRead.get("mobNum1"), dataRead.get("roleID"));
        testdata.setTestDataInMap(dataRead);
    }

    @Then("^create new user by admin (.+)$")
    public void create_new_user_by_admin(String testcase) throws Exception {
        dashboardPageStepDef dashboardPageStepDef = new dashboardPageStepDef();
        dashboardPageStepDef.admin_clicks_on_the_user_management_link_from_lhs();
        dashboardPageStepDef.lands_on_user_management_screen();
        dashboardPageStepDef.lands_on_user_addition_screen();
        enters_all_the_mandatory_and_optional_fields(testcase);
        clicks_on_confirm_button();
        new_bank_admin_is_initiated_successfully();
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.debug("bank admin is created successfully");
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(4000);
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }

    }

    @And("^create new bank admin (.+)$")
    public void create_new_bank_admin(String testcase) throws Exception {
        loginPageStepDef loginPageStepDef = new loginPageStepDef();
        dashboardPageStepDef dashboardPageStepDef = new dashboardPageStepDef();
        loginPageStepDef.super_admin_enters_a_valid_email_id_and_password(testcase);
        loginPageStepDef.clicks_on_the_login_button();
        dashboardPageStepDef.admin_clicks_on_the_user_management_link_from_lhs();
        dashboardPageStepDef.admin_lands_on_the_user_management_summary_page();
        enters_all_the_mandatory_and_optional_fields(testcase);
        clicks_on_confirm_button();
//        userCreationAction.clickSubmitBtn();
        bank_admin_is_created_successfully();
    }

    @Then("^bank admin record of search match will be displayed in the result$")
    public void bank_admin_record_of_search_match_will_be_displayed_in_the_result() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.is_SearchResultPresent();
    }

    @When("^select Bank Application in Application Name search criteria and click search$")
    public void select_bank_application_in_application_name_search_criteria_and_click_search() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.Search_criteria_BankFaceApplication();
    }

    @When("^select authorized in Status search criteria and click search$")
    public void select_authorized_in_status_search_criteria_and_click_search() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.Authorized_Search_record_check();
    }

    @Then("^all authorized bank admin records will be displayed in the result$")
    public void all_authorized_bank_admin_records_will_be_displayed_in_the_result() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.User_SummaryRecord_Present();
    }

    @Then("^all bank admin records of Bank Application will be displayed in the result$")
    public void all_bank_admin_records_of_bank_application_will_be_displayed_in_the_result() {
        LOGGER.info("all bank admin records of Bank Application will be displayed in the result");
    }

    @When("^select Unauthorized in Status search criteria and click search$")
    public void select_unauthorized_in_status_search_criteria_and_click_search() {
        LOGGER.info("select Unauthorized in Status search criteria and click search");
    }

    @When("^clicks on one unauthorized record$")
    public void clicks_on_one_unauthorized_record() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clickUnauthorizedRecord();
    }

    @And("^super admin lands on confirmation screen and clicks on approve button$")
    public void super_admin_lands_on_confirmation_screen_and_clicks_on_approve_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clicAuthorizeBtn();
    }

    @And("^bank admin lands on confirmation screen and clicks on approve button$")
    public void bank_admin_lands_on_confirmation_screen_and_clicks_on_approve_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clicAuthorizeBtn();
    }

    @And("^super admin lands on confirmation screen and clicks on reject button$")
    public void super_admin_lands_on_confirmation_screen_and_clicks_on_reject_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clicRejectBtn();
    }

    @But("^enters no data in Email ID field$")
    public void enters_no_data_in_email_id_field() throws Exception {
        LOGGER.info("enters no data in Email ID field");
    }

    @And("^clicks on save button$")
    public void clicks_on_save_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.click_confirm_btn();
    }

    @And("^clicks on Confirm button$")
    public void clicks_on_confirm_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clickSaveBtn();

    }

    @Then("bank admin is created successfully$")
    public void bank_admin_is_created_successfully() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.isUserSuccesssgPresent();
        userCreationAction.clickOkBtn();
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.debug("bank admin is created successfully");
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(4000);
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }

    }

    @Then("^bank admin is creation is rejected successfully message is displayed$")
    public void bank_admin_is_creation_is_rejected_successfully_message_is_displayed() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.isUserRejectPresent();
        userCreationAction.clickOkBtn();
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.debug("bank admin is created successfully");
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
//            TestBase.getDriver().navigate().refresh();
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
    }

    @And("^new bank admin should receive an email with the login password (.+)$")
    public void new_bank_admin_should_receive_an_email_with_the_login_passworD(String testcase) throws Exception {
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "SystemGeneratedPassword", Password, testcase);
        EmailVerification emailVerification = new EmailVerification();
        Thread.sleep(2000);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            generatedPassword = String.valueOf(emailVerification.readPassWordforAppium(dataRead.get("emailId1")));
        } else {
            generatedPassword = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
        }
        testdata.setTestDataInMap(dataRead);

    }

    @Then("^click add new user button$")
    public void click_add_new_user_button() throws Exception {
        admin_clicks_on_the_add_button();
    }


    @But("^enters no data in Full Name field (.+)$")
    public void enters_no_data_in_full_name_field(String testcase) throws Exception {
        LOGGER.debug("enters no data in Full Name field");
        LOGGER.debug("enters all the mandatory and optional fields ");
        String userName = "bankadmn" + random.getNumber(2);
        String mailId = "bankadmn" + random.getTimeStamp() + "@mailinator.com";
        String mobileNum = "7" + random.getNumber(9);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName1", userName, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId1", mailId, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum1", mobileNum, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.enterUserDetails("", dataRead.get("emailId1"), dataRead.get("mobileCode1"), dataRead.get("mobNum1"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();

    }


    @Then("^system should highlight the Full Name field in red color$")
    public void System_Should_highlight_the_full_name_field_in_red_color() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        LOGGER.debug("system should highlight the Full Name field in red color");
        userCreationAction.invaliduserName_Check();
    }

    @And("^system should not allow to enter more than 250 characters in Full Name field (.+)$")
    public void system_should_not_allow_to_enter_more_than_250_characters_in_full_name_field(String testcase) throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        String userId = random.getString(256);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName2", userId, testcase);
        testdata.setTestDataInMap(dataRead);
        userCreationAction.enterUserDetails(dataRead.get("userName2"), dataRead.get("emailId2"), dataRead.get("mobileCode"), dataRead.get("mobNum2"), dataRead.get("roleID"));
        userCreationAction.clickSaveBtn();
        userCreationAction.clickOkBtn();
        LOGGER.debug("system should not allow to enter more than 250 characters in Full Name field");
    }

    @And("^system should not allow to enter special characters in Full Name field (.+)$")
    public void system_should_not_allow_to_enter_special_characters_in_full_name_field(String testcase) throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        String userId = random.getSpecialCharactersString(8);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName3", userId, testcase);
        testdata.setTestDataInMap(dataRead);
        dashboardActions.navigateUserMngMntPage();
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName3"), dataRead.get("emailId3"), dataRead.get("mobileCode"), dataRead.get("mobNum3"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();
        LOGGER.debug("system should not allow to enter special characters in Full Name field");
    }

    @And("^system should not allow to enter numbers in Full Name field (.+)$")
    public void system_should_not_allow_to_enter_numbers_in_full_name_field(String testcase) throws Exception {
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        String userId = random.getString(3) + random.getNumber(8);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName4", userId, testcase);
        testdata.setTestDataInMap(dataRead);
        dashboardActions.navigateUserMngMntPage();
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName4"), dataRead.get("emailId4"), dataRead.get("mobileCode"), dataRead.get("mobNum4"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();
        LOGGER.debug("system should not allow to enter numbers in Full Name field");
    }

    @Then("^system should highlight the EmailID field in red color$")
    public void system_should_highlight_the_emailid_field_in_red_color() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.InvalidEmailId_Check();
    }

    @But("^enters no data in Email ID field (.+)$")
    public void enters_no_data_in_email_id_field(String testcase) throws Exception {
        String userName = "bankadmn" + random.getNumber(2);
        String mailId = "bankadmn" + random.getTimeStamp() + "@mailinator.com";
        String mobileNum = "7" + random.getNumber(9);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName1", userName, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId1", mailId, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum1", mobileNum, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.enterUserDetails(dataRead.get("userName1"), "", dataRead.get("mobileCode1"), dataRead.get("mobNum1"), dataRead.get("roleID"));

    }

    @And("^system should not allow to enter more than 250 characters in Email ID field (.+)$")
    public void system_should_not_allow_to_enter_more_than_250_characters_in_email_id_field(String testcase) throws Exception {
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        String emailID = "bankadmn" + random.getTimeStamp() + random.getString(250) + "@mailinator.com";
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId2", emailID, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dashboardActions.navigateUserMngMntPage();
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId2"), dataRead.get("mobileCode"), dataRead.get("mobNum1"), dataRead.get("roleID"));
        testdata.setTestDataInMap(dataRead);
        userCreationAction.click_confirm_btn();
        LOGGER.debug("system should not allow to enter more than 250 characters in Email ID field");
    }

    @And("^system should not allow to enter special characters in Email ID field (.+)$")
    public void system_should_not_allow_to_enter_special_characters_in_email_id_field(String testcase) throws Exception {
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        String emailID = "bankadmn " + random.getTimeStamp() + random.getSpecialCharactersString(3) + "@mailinator.com";
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId3", emailID, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dashboardActions.navigateUserMngMntPage();
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId3"), dataRead.get("mobileCode"), dataRead.get("mobNum1"), dataRead.get("roleID"));
        testdata.setTestDataInMap(dataRead);
        userCreationAction.click_confirm_btn();
        LOGGER.debug("system should not allow to enter special characters in Email ID field");
    }


    @But("^enters no data in Mobile Number field (.+)$")
    public void enters_no_data_in_mobile_number_field(String testcase) throws Exception {
        String userName = "bankadmn" + random.getNumber(2);
        String mailId = "bankadmn" + random.getTimeStamp() + "@mailinator.com";
        String mobileNum = "";
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "userName1", userName, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "emailId1", mailId, testcase);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum1", mobileNum, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId1"), dataRead.get("mobileCode1"), dataRead.get("mobNum1"), dataRead.get("roleID"));
        LOGGER.debug("enters no data in Mobile Number field");
    }

    @Then("^system should highlight the MobileNumber field in red color$")
    public void system_should_highlight_the_mobilenumber_field_in_red_color() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.invalidMobileNumber();
    }

    @And("^system should not allow to enter more than 15 characters in Mobile Number field (.+)$")
    public void system_should_not_allow_to_enter_more_than_15_characters_in_mobile_number_field(String testcase) throws Exception {
        String MobileNumber = random.getNumber(19);
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum2", MobileNumber, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        dashboardActions.navigateUserMngMntPage();
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId1"), dataRead.get("mobileCode"), dataRead.get("mobNum2"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();
        LOGGER.debug("system should not allow to enter more than 15 characters in Mobile Number field");
    }

    @And("^system should not allow to spaces Mobile Number field (.+)$")
    public void system_should_not_allow_to_spaces_mobile_number_field(String testcase) throws Exception {
        String MobileNumber = random.getSpecialCharactersString(5) + "  ";
        ExcelHandler.UpdateTestDataToExcel(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), "mobNum3", MobileNumber, testcase);
        testdata.setTestDataInMap(dataRead);
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        dashboardActions.navigateUserMngMntPage();
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId1"), dataRead.get("mobileCode"), dataRead.get("mobNum3"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();
        testdata.setTestDataInMap(dataRead);
        LOGGER.debug("system should not allow to spaces Mobile Number field");
    }


    @And("^system should display an error message as User already exists in the system when entered an already registered mobile number$")
    public void system_should_display_an_error_message_as_user_already_exists_in_the_system_when_entered_an_already_registered_mobile_number() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("android") || multiPlatform.equalsIgnoreCase("ios")) {
//            click_add_new_user_button();
        }
        userCreationAction.enterUserDetails(dataRead.get("userName1"), dataRead.get("emailId1"), dataRead.get("mobileCode"), dataRead.get("mobNum4"), dataRead.get("roleID"));
        userCreationAction.click_confirm_btn();
        testdata.setTestDataInMap(dataRead);
        LOGGER.debug("system should display an error message as User already exists in the system when entered an already registered mobile number");
    }

    @But("^uploads invalid file format in User Photo field$")
    public void uploads_invalid_file_format_in_user_photo_field() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.upload_file();
    }

    @Then("^error message should be displayed$")
    public void error_message_should_be_displayed() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.upload_error_msg();
    }

    @And("^clicks on Cancel button$")
    public void clicks_on_cancel_button() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.clickCancel();
    }

    @But("^predefined Application name should be present$")
    public void predefined_application_name_should_be_present() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.is_applicationName_preDefined_value_present();
    }

    @But("^predefined Country Code should be present$")
    public void predefined_country_code_should_be_present() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.is_countryCode_value_present();
    }

    @But("^predefined Role ID should be present$")
    public void predefined_role_id_should_be_present() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        userCreationAction.is_roleID_value_present();
    }

    @Then("^new bank admin is initiated successfully$")
    public void new_bank_admin_is_initiated_successfully() throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        LOGGER.debug("bank admin is created successfully");
        userCreationAction.isUserSuccesssgPresent();

    }
}