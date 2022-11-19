package com.iexceed.uiframework.stepDefinitions.BankFacing;


import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.BankFacing.DashboardActions;
import com.iexceed.uiframework.steps.BankFacing.LoginPageActions;
import com.iexceed.uiframework.steps.BankFacing.UserCreationAction;
import com.iexceed.uiframework.utilites.readexcel.ExcelHandler;
import com.iexceed.uiframework.utilites.readexcel.TestDataHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.DomainObjects.FileUtilities.ExcelFileData;
import uiframework.DomainObjects.Mailinator.EmailVerification;
import uiframework.DomainObjects.Mailinator.MailAutomation;
import uiframework.DomainObjects.MultiPlatformConnection;
import uiframework.DomainObjects.RandomGeneratorUtility;
import uiframework.DomainObjects.Utility;
import uiframework.DataBaseUtillity.*;

import java.util.Map;

import static com.iexceed.uiframework.appium.PcloudyConnection.reStartAppAndroid;
import static com.iexceed.uiframework.runners.TestRunner.*;

public class loginPageStepDef extends TestBase {

    private static Logger LOGGER = LogManager.getLogger(loginPageStepDef.class);
    static TestDataHandler testdata = new TestDataHandler();
    public static Map<String, String> dataList;
    public static Map<String, String> msgList;
    public static Map<String, String> dataListB;
    DB_get_failedCount db_get_faildCount;
    public static String Testcase;
    DB_get_payload payload;
    DB_dateExpiry db_dateExpiry;
    public static String password, NewPassword = "Divya@123";
    public static Map<String, String> dataRead;
    public static String language = "عربي";
    MailAutomation mail = new MailAutomation();
    RandomGeneratorUtility rg = new RandomGeneratorUtility();
    public String testcase, generatedPassword = "", generatedOTP = "";
    public int otpTimer = 4;
    private final int resendOtpLimit = DB_get_resendOTPCount.retriveCount("bfpapp");
    private final int invalidOtpLimit = DB_get_InvalidOTPCount.retriveCount("bfpapp");
    private String testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);


    @Given("^a valid bank application$")
    public static void a_valid_bank_application() throws Exception {
        MultiPlatformConnection mc = new MultiPlatformConnection();
        mc.platformConnection(multiPlatform, Application);
        System.out.println("Browser Initialized");
        LOGGER.debug("Application is launched");
        Thread.sleep(5000);
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.verifyLoginPage();
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
    }


    @When("^admin enters the Old Password, New Password and Confirm Password and click change password Button$")
    public void admin_enters_the_old_password_new_password_and_confirm_password_and_click_change_password_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("admin enters the Old Password");
//        payload = new DB_get_payload(dataListB.get("emailId1"));
        loginPageActions.enterSystemGenetaredPsd(generatedPassword);
        loginPageActions.enterNewPswd(NewPassword);
        loginPageActions.enterConfirmPsd(NewPassword);
        loginPageActions.clickChangePasswordButton();

    }

    @When("^admin enters the expiray Password, New Password and Confirm Password and click change password Button$")
    public void admin_enters_the_expiray_password_new_password_and_confirm_password_and_click_change_password_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("admin enters the expiray Password, New Password and Confirm Password and click change password");
        loginPageActions.enterSystemGenetaredPsd(generatedPassword);
        loginPageActions.enterNewPswd(NewPassword);
        loginPageActions.enterConfirmPsd(NewPassword);
        loginPageActions.clickChangePasswordButton();
    }

    @Then("^Admin lands on OTP screen$")
    public void Admin_lands_on_otp_screen() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
//        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), props.getProperty("messageSheet"), "MessageCode", dataList.get("MessageCode1")).get("MessageBody");
//        loginPageActions.validateMessageBox(message);
        loginPageActions.is_otpScreen_launched();

    }

    @Then("^bank admin is created successfully message$")
    public void bank_admin_is_created_successfully_message() throws Exception {
        LOGGER.info("bank admin is created successfully message");
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(5000);
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
    }

    @When("^enters bank admin UnAuthorized user Email Id search criteria and click search (.+)$")
    public void enters_bank_admin_unauthorized_user_email_id_search_criteria_and_click_search(String testcase) throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.Enter_UnauthorizedRecord_Details(dataRead.get("emailId1"), "Unauthorized");
    }

    @When("^enters bank admin Email Id in Email Id search criteria and click search (.+)$")
    public void enters_bank_admin_email_id_in_email_id_search_criteria_and_click_search(String testcase) throws Exception {
        UserCreationAction userCreationAction = new UserCreationAction(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        userCreationAction.Search_criteria_Check(dataRead.get("emailId1"));
    }


    @And("^bank authorizer is navigated to the UserManagement summary screen(.+)$")
    public void bank_authorizer_is_navigated_to_the_usermanagement_summary_screen(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataListB = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName1"), "TestCase_02");
        loginPageActions.EnterLogincredentials(dataListB.get("UserId"), dataListB.get("Password"));
        bank_admin_lands_on_the_dashboard_page();

    }

    @And("^bank admin is navigated to the UserManagement summary screen(.+)$")
    public void bank_admin_is_navigated_to_the_usermanagement_summary_screen(String testcase) throws Exception {
        bank_admin_logs_into_the_application_with_valid_email_id_and_password(testcase);
        bank_admin_lands_on_the_dashboard_page();

    }

    @And("^superadmin is navigated to the UserManagement summary screen(.+)$")
    public void superadmin_is_navigated_to_the_usermanagement_summary_screen(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("search application using date in my Applications tab");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName"), props.getProperty("superAdmin"));
        loginPageActions.EnterLoginCredentials(dataList.get("UserId"), dataList.get("Password"));
        clicks_on_the_login_button();
//        Admin_lands_on_otp_screen();
//        User_should_receive_an_email_with_the_otp();
//        User_enters_the_otp();
//        clicks_on_the_verify_Button();
        DashboardActions dashboardActions = new DashboardActions(multiPlatform);
        dashboardActions.navigateUserMngMntPage();

    }

    @And("^new bank admin receive an email with the login password$")
    public void new_bank_admin_receive_an_email_with_the_login_password() {
        LOGGER.info("new bank admin receive an email with the login password");
    }

    @When("^Admin enters OTP and clicks verify (.+)$")
    public void admin_enters_otp_and_clicks_verify(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }

        a_newly_created_bank_admin_enters_the_email_id_and_password(testcase);
        clicks_on_the_login_button();
        system_should_navigate_the_admin_to_the_change_password_screen();
        admin_enters_the_old_password_new_password_and_confirm_password_and_click_change_password_button();
        Admin_lands_on_otp_screen();
        User_should_receive_an_email_with_the_otp();
        User_enters_the_otp();
        clicks_on_the_verify_Button();
        click_ok_it_wil_land_on_login_page();
        admin_logs_into_the_application_with_valid_email_id_and_password();
//        Admin_lands_on_otp_screen();
//        User_should_receive_an_email_with_the_otp();
//        User_enters_the_otp();
//        clicks_on_the_verify_Button();
//        bank_admin_lands_on_the_dashboard_page();
//

    }

    @And("^click ok in the success message$")
    public void click_ok_in_the_success_message() {
        LOGGER.debug("click ok in the success message");
    }

    @When("^clicks on the Resend OTP after timer becomes zero$")
    public void clicks_on_the_resend_otp_after_timer_becomes_zero() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        Thread.sleep((long) 1000 * 60 * otpTimer);
        loginPageActions.clickResendOTP();
    }

    @Then("^system should send OTP to the registered mobile number and email ID$")
    public void system_should_send_otp_to_the_registered_mobile_number_and_email_id() {
        LOGGER.debug("system should send OTP to the registered mobile number and email ID");
    }

    @When("^clicks on the Resend OTP link for n times$")
    public void clicks_on_the_resend_otp_link_for_n_times() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        String message = "";
        for (int i = 0; i < resendOtpLimit; i++) {
            System.out.println(" Resending OTP " + (i + 1));
            Thread.sleep((long) 1000 * 60 * otpTimer);
            loginPageActions.clickResendOTP();
            loginPageActions.validateMessageBox(message);
        }
        loginPageActions.clickResendOTP();
    }


    @Then("^system should display an OTP error message")
    public void system_should_display_an_otp_error_message() throws Exception {
        LOGGER.debug("system should display an OTP error message");

    }

    @When("^enters invalid OTP for n times (.+)$")
    public void enters_invalid_otp_for_n_times(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        String otp = rg.getNumber(7);
        String message = "";
        for (int i = 0; i < invalidOtpLimit; i++) {
            System.out.println("Invalid OTP Retires " + (i + 1));
            loginPageActions.enterOtp(otp);
            loginPageActions.clickOTPVerifyButton();
            loginPageActions.validateMessageBox(message);
            otp = rg.getNumber(7);
        }
        loginPageActions.enterOtp(otp);
        loginPageActions.clickOTPVerifyButton();

    }

    @And("^enters valid OTP and clicks on the Verify button$")
    public void enters_valid_otp_and_clicks_on_the_verify_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enter_validOtp();
    }

    @And("^clicks on the Verify button system should display an error message$")
    public void clicks_on_the_verify_button_system_should_display_an_error_message() {
        LOGGER.debug("clicks on the Verify button system should display an error message");
    }

    @Then("^admin lands on Login screen$")
    public void admin_lands_on_login_screen() {
        LOGGER.debug("admin lands on Login screen");
    }

    @And("^clicks ok$")
    public void clicks_ok() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.debug("clicks ok");

    }

    @When("^super admin enters a valid email ID and password (.+)$")
    public void super_admin_enters_a_valid_email_id_and_password(String caseId) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("search application using date in my Applications tab");
        dataList = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName"), props.getProperty("superAdmin"));
        loginPageActions.EnterLoginCredentials(dataList.get("UserId"), dataList.get("Password"));
    }

    @Then("^system should show change password successfull message$")
    public void system_should_show_change_password_successfull_message() {
        LOGGER.debug("system should show change password successfull message");
    }

    @Then("^click ok it wil land on login page$")
    public void click_ok_it_wil_land_on_login_page() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickOk_button();
    }

    @And("^clicks on the Login button$")
    public void clicks_on_the_login_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickLoginButton();
    }

    @And("^click OK button$")
    public void click_OK_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickOkButton();
    }

    @Then("^user lands on Login page$")
    public void user_lands_on_login_page() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.is_loginpage_displayed();
    }

    @When("^a newly created bank admin enters the Email ID and Password (.+)$")
    public void a_newly_created_bank_admin_enters_the_email_id_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            EmailVerification emailVerification = new EmailVerification();
            generatedPassword = String.valueOf(emailVerification.readPassWordforAppium(dataRead.get("emailId1")));
            System.out.println(generatedPassword);
        } else {
            generatedPassword = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
        }
        loginPageActions.enterEmailAndPassword(dataRead.get("emailId1"), generatedPassword);
        testdata.setTestDataInMap(dataRead);
    }

    @When("^admin logs into the application with valid email ID and new password$")
    public void admin_logs_into_the_application_with_valid_email_id_and_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(3000);
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
        loginPageActions.enterEmailAndPassword(dataRead.get("emailId1"), NewPassword);
        loginPageActions.clickLoginInButton();
    }

    @Then("^super admin lands on the Dashboard page$")
    public void super_admin_lands_on_the_dashboard_page() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.isDashboardDisplayed();
    }

    @Then("^admin lands on the Dashboard page$")
    public void admin_lands_on_the_dashboard_page() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.isDashboardDisplayed();
    }

    @Then("^system should navigate the admin to the Change Password screen$")
    public void system_should_navigate_the_admin_to_the_change_password_screen() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
        loginPageActions.isChangePasswordScreenDisplayed();

    }

    @When("^admin enters wrong Old Password$")
    public void admin_enters_wrong_old_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        testPassword = rg.getString(8);
        loginPageActions.enterOldPassword(testPassword);
    }

    @When("^admin clicks on the Change Password button$")
    public void admin_clicks_on_the_change_password_button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickChangePasswordButton();
    }

    @When("^admin enters the Old Password$")
    public void admin_enters_the_old_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("admin enters the Old Password");
        System.out.println(generatedPassword);
        loginPageActions.enterOldPassword(generatedPassword);

    }

    @And("^enters a New Password$")
    public void enters_a_new_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterNewPswd(NewPassword);
    }

    @Then("^system should display an error message$")
    public void system_should_display_an_error_message() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.checkErrorMsg();
    }

    @Then("^system should display an invalid error message$")
    public void system_should_display_an_invalid_error_message() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.checkValidationErrorMsg();
    }

    @And("^enters a wrong password in Confirm Password field$")
    public void enters_a_wrong_password_in_confirm_password_field() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterConfirmPsd(NewPassword + "jk");
    }

    @Then("^system should display confirm password an error message$")
    public void system_should_display_confirm_password_an_error_message() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.confirm_error_Msg_Displayed();
    }

    @And("^clicks on the Change Password button$")
    public void clicks_on_the_change_password_button() throws Exception {
        LOGGER.info("clicks on the Change Password button");
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickChangePasswordConfirmButton();
    }


    @When("^bank admin enters invalid email ID and password (.+)$")
    public void bank_admin_enters_invalid_email_id_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("enters invalid email ID and password");
        Utility utils = new Utility();
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        EmailVerification email = new EmailVerification();
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            password = email.readPassWordforAppium(dataRead.get("emailId1")) + utils.randomString();
        }
        loginPageActions.EnterLoginCredentials(dataRead.get("emailId1"), password + "jk");
    }


    @When("^admin enters a valid email ID and invalid password for N-1 th time (.+)$")
    public void admin_enters_a_valid_email_id_and_invalid_password_for_n1_th_time(String testcase) throws Exception {
        Testcase = testcase;
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("enters invalid email ID and password");
        Utility utils = new Utility();
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        EmailVerification email = new EmailVerification();
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            password = email.readPassWordforAppium(dataRead.get("emailId1")) + utils.randomString();
        } else {
            password = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
            if (appLanguage.equalsIgnoreCase("arabic")) {
                loginPageActions.choose_language("عربي");
            }
        }
        loginPageActions.EnterLoginCredentials(dataRead.get("emailId1"), password + "jk");
        testdata.setTestDataInMap(dataRead);


    }

    @Then("^system should display a proper error message$")
    public void system_should_display_a_proper_error_message() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.isLoginErrorMsgDisplayed();
    }

    @And("^failed count should increase for the admin in the database$")
    public void failed_count_should_increase_for_the_admin_in_the_database() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        db_get_faildCount = new DB_get_failedCount(dataRead.get("UserId"));
        int RetriveCount = DB_get_RetriveCount.retriveCount("bfpapp");
        for (int i = 2; i < RetriveCount; i++) {
            System.out.println("values: " + i);
            if (multiPlatform.equalsIgnoreCase("web")) {
                TestBase.getDriver().navigate().refresh();
                Thread.sleep(15);
            }
            admin_enters_a_valid_email_id_and_invalid_password_for_n1_th_time(Testcase);
            clicks_on_the_login_button();
            system_should_display_a_proper_error_message();

        }

    }

    @When("^admin enters a valid email ID and password (.+)$")
    public void admin_enters_a_valid_email_id_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
            if (appLanguage.equalsIgnoreCase("arabic")) {
                loginPageActions.choose_language("عربي");
            }
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(10);
        }
        Thread.sleep(15);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
        LOGGER.info("admin enters a valid email ID and password");
        loginPageActions.EnterLoginCredentials(dataRead.get("emailId1"), password);

    }


    @Then("^admin should login successfully$")
    public void admin_should_login_successfully() {
        LOGGER.debug("admin should login successfully");
    }


    @When("^admin enters a valid email ID and invalid password for Nth time (.+)$")
    public void admin_enters_a_valid_email_id_and_invalid_password_for_nth_time(String testcase) throws Throwable {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
            if (appLanguage.equalsIgnoreCase("arabic")) {
                loginPageActions.choose_language("عربي");
            }
        } else {
            TestBase.getDriver().navigate().refresh();

        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
        Thread.sleep(15);
        LOGGER.info("admin enters a valid email ID and invalid password for Nth time ");
        Utility utils = new Utility();
        loginPageActions.EnterLoginCredentials(dataRead.get("emailId1"), password + utils.randomString());


    }

    @Then("^system should display an user locked error message$")
    public void system_should_display_an_user_locked_error_message() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.is_lock_user_msg_displayed();
    }


    @Then("^bank admin lands on the Dashboard page$")
    public void bank_admin_lands_on_the_dashboard_page() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.isDashboardDisplayed();
    }

    @Then("^login with bankadmin$")
    public void login_with_bankadmin() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            reStartAppAndroid();
        } else {
            TestBase.getDriver().navigate().refresh();
            Thread.sleep(5000);
        }
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
    }

    @When("^bank admin logs into the application with valid email ID and password (.+)$")
    public void bank_admin_logs_into_the_application_with_valid_email_id_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataListB = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName1"), "TestCase_01");
        if (appLanguage.equalsIgnoreCase("arabic")) {
            loginPageActions.choose_language("عربي");
        }
        loginPageActions.EnterLogincredentials(dataListB.get("UserId"), dataListB.get("Password"));
    }

    @And("^admin enters registered Email and password (.+)$")
    public void admin_enters_registered_email_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        DB_update2FAFalse.update2FA(dataRead.get("UserId"));
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            EmailVerification emailVerification = new EmailVerification();
            generatedPassword = String.valueOf(emailVerification.readPassWordforAppium(dataRead.get("emailId1")));
            System.out.println(generatedPassword);

        } else {
            generatedPassword = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
        }
        loginPageActions.enterEmailAndPassword(dataRead.get("emailId1"), generatedPassword);
        loginPageActions.clickLoginInButton();
        testdata.setTestDataInMap(dataRead);
    }

    @When("^bank admin enters the Email ID and Password (.+)$")
    public void bank_admin_enters_the_email_id_and_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        loginPageActions.EnterLogincredentials(dataRead.get("emailId1"), NewPassword);
    }

    @When("^admin enters the Old Password, New Password and Confirm Password and click change password Button for 2FA_False$")
    public void admin_enters_the_old_password_new_password_and_confirm_password_and_click_change_password_button_for_2fafalse() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        loginPageActions.enterSystemGenetaredPsd(generatedPassword);
        loginPageActions.enterNewPswd(NewPassword);
        loginPageActions.enterConfirmPsd(NewPassword);
        loginPageActions.clickChangePasswordButton();

    }

    public void readPassWord() throws Exception {
        EmailVerification emailVerification = new EmailVerification();
        generatedPassword = String.valueOf(emailVerification.readPassWord(dataListB.get("UserId"), ""));
        System.out.println(generatedPassword);

    }

    @And("^admin enters registered Email and newly changed password (.+)$")
    public void admin_enters_registered_email_and_newly_changed_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataListB = ExcelHandler.getTestDataInMap(props.getProperty("appSheetPath"), props.getProperty("appSheetName1"), testcase);
        payload = new DB_get_payload(dataListB.get("UserId1"));
        loginPageActions.EnterLogincredentials(dataListB.get("UserId1"), "Divya@1234");
    }


    @When("^expired 2FA_False bank admin enters the Email ID & Password  (.+)$")
    public void expired_2fafalse_bank_admin_enters_the_email_id_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        DB_update2FAFalse.update2FA(dataRead.get("UserId"));
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            EmailVerification emailVerification = new EmailVerification();
            generatedPassword = String.valueOf(emailVerification.readPassWordforAppium(dataRead.get("emailId1")));
            System.out.println(generatedPassword);
        } else {
            generatedPassword = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
        }
        db_dateExpiry = new DB_dateExpiry("bfpapp", dataRead.get("emailId1"));
        loginPageActions.EnterLogincredentials(dataRead.get("emailId1"), generatedPassword);
    }

    @When("^expired bank admin enters the Email ID & Password (.+)$")
    public void expired_bank_admin_enters_the_email_id_password(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        LOGGER.info("bank admin logs into the application with valid email ID and password");
        dataRead = ExcelHandler.getTestDataInMap(props.getProperty("dataSheetPath"), props.getProperty("dataSheetName"), testcase);
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            EmailVerification emailVerification = new EmailVerification();
            generatedPassword = String.valueOf(emailVerification.readPassWordforAppium(dataRead.get("emailId1")));
            System.out.println(generatedPassword);
        } else {
            generatedPassword = String.valueOf(mail.readPassWord(dataRead.get("emailId1")));
        }
        db_dateExpiry = new DB_dateExpiry("bfpapp", dataRead.get("emailId1"));
//        payload = new DB_get_payload(dataListB.get("emailId1"));
        loginPageActions.EnterLogincredentials(dataRead.get("emailId1"), generatedPassword);

    }


    @When("^admin enters current password in Old Password$")
    public void admin_enters_current_password_in_old_password() throws Exception {
        LOGGER.debug("admin enters current password in Old Password");
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterOldPassword(generatedPassword);
    }

    @And("^enters invalid password in New Password and confirm password$")
    public void enters_invalid_password_in_new_password_and_confirm_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterNewConfirmPassword(NewPassword + rg.getLowerCase(3), NewPassword + rg.getLowerCase(2));
    }

    @And("^enters same current password in New Password and confirm password$")
    public void enters_same_current_password_in_new_password_and_confirm_password() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterNewConfirmPassword(generatedPassword, generatedPassword);

    }

    @Then("^system should display policy error message (.+)$")
    public void system_should_display_policy_error_message(String testcase) throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.check_password_poclicy(msgList.get("Failed_password_Validations"));
    }

    @When("admin is in Login screen$")
    public void admin_is_in_login_screen() {
        LOGGER.debug("admin is in Login scree");
    }

    @When("^User enters the OTP$")
    public void User_enters_the_otp() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.enterOtp(generatedOTP);
    }

    @And("^clicks on the Verify Button$")
    public void clicks_on_the_verify_Button() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        loginPageActions.clickOTPVerifyButton();
    }

    public void readOTP() throws Exception {
        EmailVerification emailVerification = new EmailVerification();
        generatedOTP = String.valueOf(emailVerification.readOTP(dataListB.get("emailId1"), multiPlatform));
    }

    @And("^User should receive an email with the OTP$")
    public void User_should_receive_an_email_with_the_otp() throws Exception {
        EmailVerification emailVerification = new EmailVerification();
        if (multiPlatform.equalsIgnoreCase("Android") || multiPlatform.equalsIgnoreCase("IOS")) {
            generatedOTP = String.valueOf(emailVerification.readOTPForAppium(dataRead.get("emailId1")));
            System.out.println(generatedOTP);
        } else {
            generatedOTP = String.valueOf(emailVerification.readOTP(dataRead.get("emailId1"), multiPlatform));
        }

    }

    @And("^OTP sent to Email and Mobile Message should appear$")
    public void otp_message_should_appear() throws Exception {
        LoginPageActions loginPageActions = new LoginPageActions(multiPlatform);
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), props.getProperty("messageSheet"), "MessageCode", dataList.get("MessageCode3")).get("MessageBody");
        loginPageActions.validateMessageBox(message);
    }
}


