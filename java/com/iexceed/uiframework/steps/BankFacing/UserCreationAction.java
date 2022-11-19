package com.iexceed.uiframework.steps.BankFacing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.BankFacing.Android.A_DashboardPage;
import uiframework.PageObjects.BankFacing.Android.A_UserCreation;
import uiframework.PageObjects.BankFacing.IOS.I_DashboardPage;
import uiframework.PageObjects.BankFacing.IOS.I_LoginPage;
import uiframework.PageObjects.BankFacing.IOS.I_UserCreation;
import uiframework.PageObjects.BankFacing.Web.DashboardPage;
import uiframework.PageObjects.BankFacing.Web.UserCreation;

import static com.iexceed.uiframework.runners.TestRunner.appLanguage;

public class UserCreationAction {
    private static Logger LOGGER = LogManager.getLogger(UserCreationAction.class);
    UserCreation userCreation;
    A_UserCreation androidUserCreation;
    I_UserCreation iosUserCreation;

    public static String AppPlatForm;

    public UserCreationAction(String appplatform) {
        AppPlatForm = appplatform;
        if (appplatform.equalsIgnoreCase("ios")) {
            iosUserCreation = new I_UserCreation();
        } else if (appplatform.equalsIgnoreCase("android")) {
            androidUserCreation = new A_UserCreation();
        } else {
            userCreation = new UserCreation();
        }
    }

    public void enterUserDetails(String username, String email, String mobCode, String mobileNum, String role) throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.enterUsername(username);
            androidUserCreation.enterEmail(email);
            androidUserCreation.selectMobCode(mobCode);
            androidUserCreation.enterMobileNumber(mobileNum);
            androidUserCreation.selectRole(role, appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.enterUsername(username);
            iosUserCreation.enterEmail(email);
            iosUserCreation.selectMobCode(mobCode);
            iosUserCreation.enterMobileNumber(mobileNum);
            iosUserCreation.selectRole(role);


        } else {
            userCreation.enterUsername(username);
            userCreation.enterEmail(email);
//            userCreation.selectMobCode(mobCode);
            userCreation.enterMobileNumber(mobileNum);
//            userCreation.selectRole(role);
        }

    }

    public void click_confirm_btn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.clickSaveBtn();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.clickSaveBtn();
        } else {

            userCreation.clickSaveBtn();
        }
    }

    public void clickSaveBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.clickSaveBtn();
            androidUserCreation.clickConfirm_Btn(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.clickSaveBtn();
            iosUserCreation.clickConfirm_Btn(appLanguage);
        } else {
            userCreation.clickSaveBtn();
            userCreation.clickConfirm_Btn(appLanguage);
        }

    }

    public void ClickOkBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {

            userCreation.clickOkBtn();
        }

    }

    public void isUserSuccesssgPresent() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.isUserCreationMsgPresent(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.isUserCreationMsgPresent(appLanguage);
        } else {
            userCreation.isUserCreationMsgPresent(appLanguage);
        }

    }

    public void clickCancel() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.clickCancel(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.clickCancel();
        } else {
            userCreation.clickCancel();
        }

    }


    public void invaliduserName_Check() throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.invalidUsername_AssertTrue();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.invalidUsername_AssertTrue();
        } else {
            userCreation.invalidUsername_AssertTrue();
        }


    }

    public void invalidEmailId_Check() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.isInvalidMailMsgDisplayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.isInvalidMailMsgDisplayed();
        } else {
            userCreation.isInvalidMailMsgDisplayed();
        }
    }

    public void invalidMobileNumber() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.invalid_mobileNum_check();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.invalid_mobileNum_check();

        } else {
            userCreation.invalid_mobileNum_check();
        }
    }

    public void upload_file() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
//            androidUserCreation.upload_photo();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            userCreation.upload_photo();
        }

    }

    public void create_new_user() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.create_new_user();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.create_new_user();
        } else {
            userCreation.create_new_user();
        }

    }

    public void upload_error_msg() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
//            androidUserCreation.upload_error_msg();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            userCreation.upload_error_msg();
        }

    }

    public void is_applicationName_preDefined_value_present() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.is_applicationName_preDefined_value_present();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.is_applicationName_preDefined_value_present();

        } else {
            userCreation.is_applicationName_preDefined_value_present();
        }
    }

    public void is_countryCode_value_present() throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.is_phoneNumber_value_present();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.is_phoneNumber_value_present();
        } else {
            userCreation.is_phoneNumber_value_present();
        }

    }

    public void is_roleID_value_present() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.is_roleID_value_present(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.is_roleID_value_present();
        } else {
            userCreation.is_roleID_value_present();
        }

    }

    public void clickOkBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.clickOk();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.clickOk();

        } else {
            userCreation.clickOk();
        }

    }

    public void InvalidEmailId_Check() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidUserCreation.isInvalidMailMsgDisplayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosUserCreation.isInvalidMailMsgDisplayed();

        } else {
            userCreation.isInvalidMailMsgdisplayed();
        }
    }

    public void Search_criteria_Check(String mail) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.search_criteria_check(mail);
        }
    }

    public void is_SearchResultPresent() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.is_search_Result_present();
        }
    }

    public void Search_criteria_BankFaceApplication() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.search_criteria_BankApplication();
        }
    }

    public void Authorized_Search_record_check() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.click_Authorized_searchRecord(appLanguage);
        }
    }

    public void User_SummaryRecord_Present() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            userCreation.check_userSummary_Record_present();
        }
    }

    public void Enter_UnauthorizedRecord_Details(String mail,String status) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            userCreation.unAuthorizedRecord_Search(mail,status,appLanguage);
        }
    }

    public void clickUnauthorizedRecord() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.click_unauthorized_Record(appLanguage);
        }
    }
    public void clicAuthorizeBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.enterRemarks();
            userCreation.clickAthorizeBtn();
            userCreation.authorizationPopupValidations(appLanguage);
        }
    }

    public void clicRejectBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            userCreation.enterRemarks();
            userCreation.clickRejectBtn();
            userCreation.rejectPopupValidations(appLanguage);
        }
    }
    public void isUserRejectPresent() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            userCreation.isUserRejectMsgPresent(appLanguage);
        }

    }
}
