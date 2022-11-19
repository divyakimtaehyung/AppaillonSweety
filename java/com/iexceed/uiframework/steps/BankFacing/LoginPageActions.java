package com.iexceed.uiframework.steps.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.BankFacing.Android.A_LoginPage;
import uiframework.PageObjects.BankFacing.IOS.I_LoginPage;
import uiframework.PageObjects.BankFacing.Web.LoginPage;

import static com.iexceed.uiframework.runners.TestRunner.appLanguage;


public class LoginPageActions extends TestBase {
    private static Logger LOGGER = LogManager.getLogger(LoginPageActions.class);
    LoginPage loginPage;
    A_LoginPage androidLoginPage;
    I_LoginPage iosLoginPage;
    public static String AppPlatForm;

    public LoginPageActions(String appPlatForm) {
        AppPlatForm = appPlatForm;
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage = new A_LoginPage();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage = new I_LoginPage();
        } else {
            loginPage = new LoginPage();
        }

    }

    public void verifyLoginPage() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("ios")) {
            iosLoginPage.verifyLoginPage();
        }
    }

    public void is_otp_msgDisplayed(String msg) throws Exception {
        loginPage.isOtpMsg_displayed(msg);
    }

    public void choose_language(String language) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.changelanguage(language);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.changelanguage(language);
        } else {
            loginPage.changelanguage(language);
        }
    }

    public void clickOk_button() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.click_ok_button(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.click_ok_button(appLanguage);
        } else {
            loginPage.click_ok_button(appLanguage);
        }

    }

    public void invalid_otp_validations(String msg1, String msg2) throws Exception {
        loginPage.enter_invalid_OTP_validation(msg1, msg2);
    }

    public void is_otpScreen_launched() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.is_otp_screen_displayed(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.is_otp_screen_displayed(appLanguage);
        } else {
            loginPage.is_otp_screen_displayed(appLanguage);
        }

    }

    public void resendOTP_check() throws Exception {
        loginPage.click_resentOTP_link();
    }

    public void resend_OTP_n_times() throws Exception {
        loginPage.click_resent_OTP_nTime();
    }

    public void resend_max_Error_validations(String msg) throws Exception {
        loginPage.otp_max_Resent_Error_validations(msg);
    }

    public void enter_validOtp() throws Exception {
        loginPage.enter_valid_otp();
    }



    public void EnterLoginCredentials(String userName, String Password) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterUserName(userName);
            androidLoginPage.enterPassword(Password);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterUserName(userName);
            iosLoginPage.enterPassword(Password);
        } else {
            loginPage.enterUserName(userName);
            loginPage.enterPassword(Password);
        }
    }


    public void is_loginpage_displayed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.is_loginpage_displayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.is_loginpage_displayed();
        } else {
            loginPage.is_loginpage_displayed();
        }

    }

    public void clickLoginButton() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.ClickLoginButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.ClickLoginButton();
        } else {
            loginPage.ClickLoginButton();
        }


    }

    public void isDashboardDisplayed() throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.isDashboard();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.isDashboard();
        } else {
            loginPage.isDashboard();
        }

    }

    public void clickLoginInButton() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.ClickLoginButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.ClickLoginButton();
        } else {
            loginPage.ClickLoginButton();
        }

    }

    public void isChangePasswordScreenDisplayed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.isChangePswdScreenDisplayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.isChangePswdScreenDisplayed();
        } else {
            loginPage.isChangePswdScreenDisplayed();
        }

    }

    public void enterOldPasswordConfirmPassword(String emailPassword, String password) throws Exception {
        loginPage.setOldPassword(emailPassword);
        loginPage.setNewPassword(password);
        loginPage.setConfirmPasswordButton(password);
    }

    public void enterOldPassword(String emailPassword) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enter_old_system_password(emailPassword);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.setOldPassword(emailPassword);

        } else {
            loginPage.setOldPassword(emailPassword);
        }

    }

    public void enterNewConfirmPassword(String password, String password2) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterNewPswd(password);
            androidLoginPage.enterConfirmPswd(password2);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.setNewPassword(password);
            iosLoginPage.setConfirmPasswordButton(password);


        } else {
            loginPage.setNewPassword(password);
            loginPage.setConfirmPasswordButton(password);
        }


    }

    public void clickChangePasswordButton() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.ClickChangePswdButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.ClickChangePswdButton();
        } else {
            loginPage.ClickChangePswdButton();

        }
    }

    public void checkErrorMsg() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.checkErrorMsgOnScreen();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.checkErrorMsgOnScreen();
        } else {
            loginPage.checkErrorMsgOnScreen();
        }
    }

    public void checkValidationErrorMsg() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.check_policy_password_msg_present();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.checkErrorMsgOnScreen();
        } else {
            loginPage.checkErrorMsgOnScreen();
        }
    }


    public void enterSystemGenetaredPsd(String password) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enter_old_system_password(password);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterWrongPassword(password);
        } else {
            loginPage.enterWrongPassword(password);
        }


    }

    public void enterWrongPswd(String Password) throws Exception {
        loginPage.enterWrongPassword(Password);
    }

    public void validateMessageBox(String message) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
//            androidLoginPage.validateMessageBox(message);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
//            loginPage.validateMessageBox(message);
        }


    }

    public void clickChangePasswordConfirmButton() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.ClickChangePswdButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.ClickChangePswdconfirmButton();
        } else {
            loginPage.ClickChangePswdconfirmButton();
        }


    }

    public void enterNewPswd(String newPassword) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterNewPswd(newPassword);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterNewPswd(newPassword);
        } else {
            loginPage.enterNewPswd(newPassword);
        }

    }

    public void enterConfirmPsd(String confirmPassword) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterConfirmPswd(confirmPassword);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterConfirmPswd(confirmPassword);
        } else {
            loginPage.enterConfirmPswd(confirmPassword);
        }

    }

    public void confirm_error_Msg_Displayed() throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.confirmPsd_error_Msg_displayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.confirmPsd_error_Msg_displayed();
        } else {
            loginPage.confirmPsd_error_Msg_displayed();
        }

    }

    public void isLoginErrorMsgDisplayed() throws Exception {

        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.isErrorLoginMsgDisplayed(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.isErrorLoginMsgDisplayed(appLanguage);
        } else {
            loginPage.isErrorLoginMsgDisplayed(appLanguage);
        }


    }

    public void is_lock_user_msg_displayed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.is_lock_ErrorMsgDisplayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.is_lock_ErrorMsgDisplayed();
        } else {
            loginPage.is_lock_ErrorMsgDisplayed();
        }


    }

    public void EnterLogincredentials(String userName, String Password) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterUserName(userName);
            androidLoginPage.enterPassword(Password);
            androidLoginPage.ClickLoginButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterUserName(userName);
            iosLoginPage.enterPassword(Password);
            iosLoginPage.ClickLoginButton();
        } else {

            loginPage.enterUserName(userName);
            loginPage.enterPassword(Password);
            loginPage.ClickLoginButton();
        }


    }


    public void check_password_poclicy(String msg) throws Exception {
        loginPage.check_password_policy();
        loginPage.check_policy_password_msg_present(msg);
    }

    public void enterOtp(String otp) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.setOtpField(otp);
            androidLoginPage.clickOtpVerifyButton(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.setOtpField(otp);
        } else {
            loginPage.setOtpField(otp);
        }


    }

    public void clickOTPVerifyButton() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.clickOtpVerifyButton(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.clickOtpVerifyButton();
        } else {
            loginPage.clickOtpVerifyButton();
        }


    }

    public void clickOkButton() throws Exception {
        loginPage.clickokBtn();

    }


    public void enterEmailAndPassword(String UserId, String Password) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.enterUserName(UserId);
            androidLoginPage.enterPassword(Password);
            androidLoginPage.ClickLoginButton();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.enterUserName(UserId);
            iosLoginPage.enterPassword(Password);
            iosLoginPage.ClickLoginButton();
        } else {
            loginPage.verifyLoginPage();
            loginPage.setLoginEmailID(UserId);
            loginPage.setLoginPassword(Password);

        }

    }

    public void verifyOTPScreen() {
        loginPage.verifyOtpScreen();
    }

    public void clickResendOTP() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidLoginPage.clickOtpResendLink(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosLoginPage.clickOtpResendLink();
        } else {
            loginPage.clickOtpResendLink();
        }

    }


}
