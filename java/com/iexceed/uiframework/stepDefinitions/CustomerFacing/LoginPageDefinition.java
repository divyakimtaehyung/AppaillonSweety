package com.iexceed.uiframework.stepDefinitions.CustomerFacing;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.steps.CustomerFacing.DashboardAction;
import com.iexceed.uiframework.steps.CustomerFacing.LoginPageAction;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import uiframework.DomainObjects.FileUtilities.ExcelFileData;
import uiframework.DomainObjects.Mailinator.MailAutomation;
import uiframework.DomainObjects.RandomGeneratorUtility;
import uiframework.DataBaseUtillity.*;

import java.io.IOException;
import java.util.Map;

import static com.iexceed.uiframework.runners.TestRunnerCustomer.appLanguage;
import static com.iexceed.uiframework.runners.TestRunnerCustomer.multiPlatform;


public class LoginPageDefinition extends TestBase{
    private static final Logger LOGGER = LogManager.getLogger(LoginPageDefinition.class);
    public static Map<String,String> dataList;

    RandomGeneratorUtility rg = new RandomGeneratorUtility();

    MailAutomation mail;

    //Password and OTP getting from MailAutomation
    public String testcase, generatedPassword = "",generatedOTP ="";

    // otp timer should get from OTP DB
    public int otpTimer=5;
    LoginPageAction  loginPageAction ;

    private String testEmail = rg.getLowerCase(10)+"@"+ rg.getLowerCase(8)+"."+rg.getLowerCase(5);
    private String testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);
    private String testMobileNumber = rg.getNumber(10);
    private final String testMobileCode = "+91";
    private String messageCode="";
    private String messageSheetName="";

    //Dynamic locator change for IOS page objects
    private String changePasswordButtonStatus ="";


    @Given("^a valid corporate application$")
    public void a_valid_corporate_application() throws Exception {
        LOGGER.info("Customer application Launched");
        loginPageAction = new LoginPageAction(multiPlatform);
        loginPageAction.acceptPermissionMessages();
        loginPageAction.verifyLoginPage();
        loginPageAction.selectLanguage(appLanguage);
        if (appLanguage.equalsIgnoreCase("english")){
            messageSheetName = props.getProperty("messageSheet");
        }else {
            messageSheetName = props.getProperty("messageSheetArabic");
        }
    }

    public void readOTP() throws Exception {
        if (!(multiPlatform.equalsIgnoreCase("web"))) {
            TestBase.initialization("chrome");
            mail = new MailAutomation();
            generatedOTP = String.valueOf(mail.readOTPMobileAutomation(testEmail));
            TestBase.getDriver().quit();
        }else{
            mail = new MailAutomation();
            generatedOTP = String.valueOf(mail.readOTP(testEmail));
        }
    }

    private void readPasswordFromEmail() throws Exception {
        if (!(multiPlatform.equalsIgnoreCase("web"))) {
            TestBase.initialization("chrome");
            mail = new MailAutomation();
            generatedPassword = String.valueOf(mail.readPassWordMobileAutomation(testEmail));
            TestBase.getDriver().quit();
        }else {
            mail = new MailAutomation();
            generatedPassword = mail.readPassWord(testEmail);
        }
    }

    public void verifyEmailReceived() throws Exception {
        if (!(multiPlatform.equalsIgnoreCase("web"))) {
            TestBase.initialization("chrome");
            mail = new MailAutomation();
            mail.verifyPasswordChangedMailReceivedMobileAutomation(testEmail);
            TestBase.getDriver().quit();
        }else {
            mail = new MailAutomation();
            mail.verifyPasswordChangedMailReceived(testEmail);
        }
    }

    public void update2FA(){
        DB_update2FAFalse.update2FA(testEmail);
    }

    @Then("^proper error pop-up message should display (.+)$")
    public void system_should_display_a_proper_error_message(String messageCode) throws Exception {
        this.messageCode = messageCode;
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }

    @Then("^error message should display (.+)$")
    public void system_should_display_an_error_message(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }

    @Then("^resend otp limit reached message should display (.+)$")
    public void  resend_limit_reached_message_should_display(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }

    @Then("^max otp retries reached message should display (.+)$")
    public void  user_blocked_message_should_display(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }


    @Then("^proper error message should display under the all fields \"([^\\\"]*)\\\" and \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
    public void system_should_display_a_proper_error_message_on_the_all_fields(String messageCode1,String messageCode2,String messageCode3) throws Exception {
        String message1 = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode1).get("MessageBody");
        String message2 = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode2).get("MessageBody");
        String message3 = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode3).get("MessageBody");
        loginPageAction.validateMessageOldPassword(message1);
        loginPageAction.validateMessageNewPassword(message2);
        loginPageAction.validateMessageConfirmPassword(message3);
    }


    @Then("^old password field under error message should display (.*)$")
    public void system_should_display_an_error_message_on_the_old_fields(String messageCode) throws Exception {
        String message1 = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateInvalidOldPasswordMessage(message1);
    }

    @Then("^confirm password field under error message should display (.*)$")
    public void system_should_display_an_error_message_on_the_confirm_fields(String messageCode) throws Exception {
        String message3 = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validateInvalidConfirmPassword(message3);
    }


    @Then("^password policies should indicate failed cases (.*)$")
    public void password_policies_should_indicate_failed_cases(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode).get("MessageBody");
        loginPageAction.validatePasswordPoliciesOfUpperCase("error");
        loginPageAction.validateErrorMessage(message);
    }
    @Then("^user should not allowed to change Old password as New Password message should appear (.*)$")
    public void password_should_fail(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }



    @When("^user clicks on the Sign Up link$")
    public void user_clicks_on_the_sign_up_link() throws Exception {
        loginPageAction.clickSignUpLink();
    }


    @When("^user enters the OTP$")
    public void user_enters_the_otp() throws Exception {
        loginPageAction.enterOtp(generatedOTP);
    }


    @Then("^user is created successfully (.*)$")
    public void user_is_created_successfully(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim().trim()).get("MessageBody");
        loginPageAction.validateSuccessMessage(message);
    }

    @And("^enters a valid Email ID and Country code & Mobile number (.*)$")
    public void enters_a_valid_email_id_and_country_code_mobile_number(String testcase) throws Exception {
        testEmail = "corporate_"+rg.getTimeStamp()+"@mailinator.com";
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        loginPageAction.enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
        ExcelFileData.UpdateTestDataToExcel(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase,"Email",testEmail);
        ExcelFileData.UpdateTestDataToExcel(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase,"MobileNumber",testMobileNumber);
        ExcelFileData.UpdateTestDataToExcel(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase,"MobileCode",testMobileCode);
    }

    @And("^clicks on the Sign Up button$")
    public void clicks_on_the_sign_up_button() throws Exception {
        loginPageAction.clickSignUpButton();
    }

    @And("^user should receive an email with the OTP$")
    public void user_should_receive_an_email_with_the_otp() throws Exception {
        readOTP();
    }


    @And("^clicks on the Verify button$")
    public void clicks_on_the_verify_button() throws Exception {
        loginPageAction.clickOTPVerifyButton();
    }

    @When("^a newly created user enters valid Email ID and Password (.+)$")
    public void new_user_enters_valid_email_id_and_password(String testcase) throws Exception {
        this.testcase = testcase;
        mail = new MailAutomation();
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        System.out.println(testEmail);
        readPasswordFromEmail();
        loginPageAction.enterEmailAndPassword(testEmail, generatedPassword);
    }

    @When("^opted out user enters valid Email ID and Password (.+)$")
    public void user_enters_valid_email_id_and_password(String testcase) throws Exception {
        this.testcase = testcase;
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        testPassword = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Password");
        update2FA();
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
    }


    @When("^user enters valid Email ID and Password (.+)$")
    public void user_enters_valid_opted_user_email_id_and_password(String testcase) throws Exception {
        this.testcase = testcase;
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        testPassword = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Password");
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
    }

    @When("^user enters valid Old password, New password and Confirm password$")
    public void user_enters_valid_old_password_new_password_and_confirm_password() throws Exception {
        testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);
        String oldPassword = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Password");
        loginPageAction.enterOldPasswordConfirmPassword(oldPassword,testPassword);
        ExcelFileData.UpdateTestDataToExcel(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase"),"Password",testPassword);
    }

    @When("^user enters valid Generated password, New password and Confirm password$")
    public void user_enters_valid_generated_password_new_password_and_confirm_password() throws Exception {
        changePasswordButtonStatus ="valid data";
        testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);
        loginPageAction.enterOldPasswordConfirmPassword(generatedPassword,testPassword);
        ExcelFileData.UpdateTestDataToExcel(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase"),"Password",testPassword);
    }


    @When("^user logs into the application with valid email ID and password$")
    public void user_logs_into_the_application_with_valid_email_id_and_password() throws Exception {
//        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        testPassword = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Password");
        System.out.println(testEmail);
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
        loginPageAction.clickLoginInButton();
    }

    @Then("^system should navigate the user to the Change Password screen$")
    public void system_should_navigate_the_user_to_the_change_password_screen() throws IOException {
        loginPageAction.verifyChangePasswordScreen();
    }

    @Then("^user lands on OTP screen$")
    public void user_lands_on_otp_screen() {
        loginPageAction.verifyOTPScreen();
    }

    @Then("^system should display a success message (.*)$")
    public void system_should_display_a_success_message(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateSuccessMessage(message);
    }


    @And("^clicks on Login button$")
    public void clicks_on_the_sign_in_button() throws Exception {
        loginPageAction.clickLoginInButton();
    }


    @And("^user does not enters the data in mandatory fields$")
    public void user_does_not_enters_the_data_in_mandatory_fields() throws Throwable {
        changePasswordButtonStatus = "no data";
    }

    @And("^clicks on the Change Password Button$")
    public void clicks_on_the_change_password_button() throws Exception {
        loginPageAction.clickChangePassword();
    }

    @And("^OTP sent message should appear (.*)$")
    public void click_ok_in_the_success_message(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateSuccessMessage(message);
    }

    @And("^OTP sent to Email and Mobile message should appear (.*)$")
    public void otp_message_should_appear(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateSuccessMessage(message);
    }

    @And("^user is navigated to the Login screen$")
    public void user_is_navigated_to_the_login_screen() throws Exception {
        loginPageAction.verifyLoginPage();
    }


    @And("^user receives a password changed email$")
    public void user_receives_a_password_changed_email() throws Exception {
        verifyEmailReceived();
    }

    @When("^user in Login screen$")
    public void user_is_in_login_screen() throws Exception {
        loginPageAction.verifyLoginPage();
    }

    @And("^user enters invalid data in Email (.*)$")
    public void user_enters_invalid_data_in_email(String testcase) throws Exception {
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"), props.getProperty("loginSheetName"),"TestCase_ID",testcase.trim());
        testEmail =rg.getLowerCase(5)+"@"+ rg.getLowerCase(4)+"."+rg.getLowerCase(3);
        testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
    }

    @And("^user enters registered Email ID and invalid password (.+)$")
    public void user_enters_registered_email_id_and_invalid_password(String testcase) throws Exception {
        this.testcase = testcase;
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        testPassword = rg.getOneUpperCaseOneSpecialCharOneLowerCaseOneNumber(8);
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
    }


    @And("^user repeats the 2nd and 3rd step for n times$")
    public void user_repeats_the_2nd_and_3rd_step_for_n_times() throws Exception {
        int invalidPasswordLimit = DB_get_RetriveCount.retriveCount("cfpapp");
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        for (int i = 2; i< invalidPasswordLimit; i++){
            System.out.println("Invalid password retry "+i);
            user_enters_registered_email_id_and_invalid_password(testcase);
            clicks_on_the_sign_in_button();
            loginPageAction.validateErrorMessage(message);
        }
        user_enters_registered_email_id_and_invalid_password(testcase);
        clicks_on_the_sign_in_button();
    }

    @When("^clicks on Resend OTP after timer becomes zero$")
    public void clicks_on_the_resend_otp_after_timer_becomes_zero() throws Exception {
//        Thread.sleep(300000);
        Thread.sleep((long)1000*60*otpTimer);
        // wait for the time
        loginPageAction.clickResendOTP();
    }

    @Then("^system should send OTP to registered mobile number and email ID (.*)$")
    public void system_should_send_otp_to_the_registered_mobile_number_and_email_id(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateSuccessMessage(message);
        readOTP();
    }

    @When("^clicks on Resend OTP link for n times (.*)$")
    public void clicks_on_the_resend_otp_link_for_n_times(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        int resendOtpLimit = DB_get_resendOTPCount.retriveCount("cfpapp");
        for (int i = 0; i< resendOtpLimit; i++){
            System.out.println(" Resending OTP "+(i+1));
            loginPageAction.verifyOTPScreen();
            Thread.sleep((long)1000*60*otpTimer);
            loginPageAction.clickResendOTP();
            loginPageAction.validateSuccessMessage(message);
        }
        loginPageAction.verifyOTPScreen();
        Thread.sleep((long)1000*60*otpTimer);
        loginPageAction.clickResendOTP();
    }

    @When("^user enters invalid OTP for n times (.*)$")
    public void enters_invalid_otp_for_n_times(String messageCode) throws Exception {
        String otp = rg.getNumber(6);
        int invalidOtpLimit = DB_get_InvalidOTPCount.retriveCount("cfpapp");
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        for (int i = 0; i< invalidOtpLimit; i++){
            System.out.println("Invalid OTP Retires "+(i+1));
            loginPageAction.enterOtp(otp);
            loginPageAction.clickOTPVerifyButton();
            loginPageAction.validateErrorMessage(message);
            loginPageAction.verifyOTPScreen();
            otp = rg.getNumber(6);
        }
        loginPageAction.enterOtp(otp);
    }


    @When("^user enters generated password in Old Password$")
    public void user_enters_generated_password_in_old_password() throws Exception {
        loginPageAction.enterOldPassword(generatedPassword);
    }

    @And("^enters invalid password in New Password and Confirm password$")
    public void enters_invalid_password_in_new_password_and_confirm_password() throws Exception {
        testPassword = rg.getLowerCase(3)+rg.getSpeicalCharacters(2)+rg.getNumber(5);
        loginPageAction.enterNewConfirmPassword(testPassword);
    }

    @And("^enters same generated password in New Password and confirm password$")
    public void enters_same_generated_password_in_new_password_and_confirm_password() throws Exception {
        loginPageAction.enterNewConfirmPassword(generatedPassword);
    }

    @When("^user enters invalid Old Password$")
    public void user_enters_invalid_old_password() throws Exception {
        testPassword = rg.getString(8);
        loginPageAction.enterOldPassword(testPassword);
    }

    @And("^enters a valid New Password and distinct in Confirm Password field$")
    public void enters_a_valid_new_password_and_distinct_in_confirm_password_field() throws Exception {
        changePasswordButtonStatus = "valid data";
        testPassword = rg.getString(8);
        loginPageAction.enterNewDistinctConfirmPassword(testPassword,rg.getString(8));
    }

    @When("^expired user enters the Email ID & Password (.+)$")
    public void expired_user_enters_the_email_id_password(String testcase) throws Exception {
        this.testcase = testcase;
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        testPassword = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Password");
        System.out.println(testEmail);
        DB_dateExpiry db = new DB_dateExpiry("cfpapp",testEmail);
        loginPageAction.enterEmailAndPassword(testEmail,testPassword);
    }


    @And("^user lands on Sign Up page$")
    public void user_lands_on_sign_up_page() throws IOException {
        loginPageAction.verifySignUpPage();
    }

    @Then("^system should highlight the Email ID field (.*)$")
    public void system_should_highlight_the_email_id_field(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }


    public void enterSignUpDetails(String email, String mobileCode, String mobileNumber) throws Exception {
        loginPageAction.enterSignUpDetails(email,mobileCode,mobileNumber);
        loginPageAction.clickSignUpButton();
    }


    @Then("^system should highlight the Mobile Number field (.*)$")
    public void system_should_highlight_the_mobile_number_field(String messageCode) throws Exception {
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }

    @And("^system should not accept more than 100 characters in Email ID field$")
    public void system_should_not_accept_more_than_250_characters_in_email_id_field() throws Exception {
        testEmail = rg.getLowerCase(50)+"@"+ rg.getLowerCase(30)+"."+rg.getLowerCase(30);
        loginPageAction.enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
        Assert.assertFalse(loginPageAction.validateEmailId(testEmail));
    }

    @And("^system should allow invalid special characters to enter in Email ID field (.*)$")
    public void system_should_allow_valid_special_characters_to_enter_in_email_id_field(String messageCode) throws Exception {
        testEmail = rg.getSpeicalCharacters(5)+ rg.getLowerCase(8)+rg.getSpeicalCharacters(5)+"@"+ rg.getLowerCase(8)+"."+rg.getLowerCase(5);
        System.out.println(testEmail);
        enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
//        Assert.assertFalse(loginPageAction.validateEmailId(testEmail));
        String message = ExcelFileData.getByColumnTestDataInMap(props.getProperty("messageSheetPath"), messageSheetName,"MessageCode",messageCode.trim()).get("MessageBody");
        loginPageAction.validateErrorMessage(message);
    }

    @And("^user enters all the mandatory and optional fields (.+)$")
    public void user_enters_all_the_mandatory_and_optional_fields(String testcase) throws Exception {
        this.testcase = testcase;
        dataList = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",testcase);
        loginPageAction.enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
    }

    @And("^system should not accept more than 15 characters in Mobile Number field$")
    public void system_should_not_accept_more_than_15_characters_in_mobile_number_field() throws Exception {
        testMobileNumber = rg.getNumber(50);
        loginPageAction.enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
        System.out.println("Number "+testMobileNumber);
        Assert.assertFalse(loginPageAction.validateMobileNumber(testMobileNumber));
    }

    @And("^system should not accept spaces Mobile Number field$")
    public void system_should_not_accept_spaces_mobile_number_field() throws Exception {
        testMobileNumber = rg.getNumber(5)+" "+rg.getNumber(5);
        loginPageAction.enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
        Assert.assertFalse(loginPageAction.validateMobileNumber(testMobileNumber));
    }

    @And("^user enters already registered Mobile Number$")
    public void error_message_should_display_as_user_already_exists_in_the_system_when_entered_an_already_registered_mobile_number() throws Exception {
        testMobileNumber = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("MobileNumber");
        enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
    }

    @And("^user enters already registered Email ID$")
    public void error_message_should_display_as_user_already_exists_in_the_system_when_entered_an_already_registered_email_id() throws Throwable {
        testEmail = ExcelFileData.getByColumnTestDataInMap(props.getProperty("corporateTestCaseSheet"),props.getProperty("loginSheetName"),"TestCase_ID",dataList.get("LoginTestCase")).get("Email");
        enterSignUpDetails(testEmail,testMobileCode,testMobileNumber);
    }

    @But("^user enter no data Email ID field$")
    public void user_enter_no_data_email_id_field()  {
        testEmail = "";
    }

    @But("^predefined Country Codes should be present$")
    public void predefined_country_codes_should_be_present() throws Exception {
        Assert.assertTrue(loginPageAction.validateCountryCode(testMobileCode));
    }

    @But("^user enters no data in Mobile Number field$")
    public void user_enters_no_data_in_mobile_number_field()  {
        testMobileNumber = "";
    }

}