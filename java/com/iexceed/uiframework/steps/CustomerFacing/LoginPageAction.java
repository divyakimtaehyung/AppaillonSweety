package com.iexceed.uiframework.steps.CustomerFacing;


import uiframework.PageObjects.CustomerFacing.Android.A_LoginPageObjects;
import uiframework.PageObjects.CustomerFacing.IOS.I_LoginPageObjects;
import uiframework.PageObjects.CustomerFacing.Web.LoginPageObjects;

import java.io.IOException;

public class LoginPageAction {

    private final String platform ;
    LoginPageObjects  loginPageObjects;
    A_LoginPageObjects aLoginPageObjects;
    I_LoginPageObjects iLoginPageObjects;

    public LoginPageAction(String platform){
        this.platform = platform;
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects = new I_LoginPageObjects();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects = new A_LoginPageObjects();
        }else {
            loginPageObjects = new LoginPageObjects();
        }
    }

    public void verifyLoginPage() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.verifyLoginPage();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifyLoginPage();
        }else {
            loginPageObjects.verifyLoginPage();
        }
    }

    public void enterEmailAndPassword(String email, String password) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.verifyLoginPage();
            iLoginPageObjects.setLoginEmailID(email);
            iLoginPageObjects.setLoginPassword(password);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifyLoginPage();
            aLoginPageObjects.setLoginEmailID(email);
            aLoginPageObjects.setLoginPassword(password);
        }else {
            loginPageObjects.verifyLoginPage();
            loginPageObjects.setLoginEmailID(email);
            loginPageObjects.setLoginPassword(password);
        }
    }

    public void clickLoginInButton() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickLoginButton();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.clickLoginButton();
        }else {
                loginPageObjects.clickLoginButton();
        }
    }

    public void clickSignUpLink() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickSignUplink();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifyLoginPage();
            aLoginPageObjects.clickSignUplink();
        }else {
            loginPageObjects.verifyLoginPage();
            loginPageObjects.clickSignUplink();
        }
    }

    public void clickSignUpButton() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickSignUpButton();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.clickSignUpButton();
        }else {
            loginPageObjects.clickSignUpButton();
        }
    }


    public void enterOtp(String otp) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setOtpField(otp);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setOtpField(otp);
        }else {
            loginPageObjects.setOtpField(otp);
        }
    }

    public void clickOTPVerifyButton() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickOtpVerifyButton();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.clickOtpVerifyButton();
        }else {
            loginPageObjects.clickOtpVerifyButton();
        }
    }

    public void enterSignUpDetails(String email, String mobileCode, String mobileNumber) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setSignUpEmailId(email);
            iLoginPageObjects.selectSignUpMobileCode(mobileCode);
            iLoginPageObjects.setSignUpMobileNumber(mobileNumber);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setSignUpEmailId(email);
            aLoginPageObjects.selectSignUpMobileCode(mobileCode);
            aLoginPageObjects.setSignUpMobileNumber(mobileNumber);
        }else {
            loginPageObjects.setSignUpEmailId(email);
            loginPageObjects.selectSignUpMobileCode(mobileCode);
            loginPageObjects.setSignUpMobileNumber(mobileNumber);
        }
    }

    public void verifyChangePasswordScreen() throws IOException {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.verifyChangePasswordScreen();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifyChangePasswordScreen();
        }else {
            loginPageObjects.verifyChangePasswordScreen();
        }
    }

    public void enterOldPasswordConfirmPassword(String emailPassword, String password) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setOldPassword(emailPassword);
            iLoginPageObjects.setNewPassword(password);
            iLoginPageObjects.setConfirmPasswordButton(password);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setOldPassword(emailPassword);
            aLoginPageObjects.setNewPassword(password);
            aLoginPageObjects.setConfirmPasswordButton(password);
        }else {
            loginPageObjects.setOldPassword(emailPassword);
            loginPageObjects.setNewPassword(password);
            loginPageObjects.setConfirmPasswordButton(password);
        }
    }

    public void clickChangePassword() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickChangeConfirmButton();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.clickChangeConfirmButton();
            aLoginPageObjects.clickChangeConfirmButton();
        }else {
            loginPageObjects.clickChangeConfirmButton();
        }
    }

    public void verifyOTPScreen() {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.verifyOtpScreen();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifyOtpScreen();
        }else {
            loginPageObjects.verifyOtpScreen();
        }
    }

    public void validateSuccessMessage(String message) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateSuccessMessageBox(message);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateSuccessMessageBox(message);
        }else {
            loginPageObjects.validateSuccessMessageBox(message);
        }
    }

    public void clickResendOTP() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.clickOtpResendLink();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.clickOtpResendLink();
        }else {
            loginPageObjects.clickOtpResendLink();
        }
    }

    public void enterOldPassword(String emailPassword) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setOldPassword(emailPassword);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setOldPassword(emailPassword);
        }else {
            loginPageObjects.setOldPassword(emailPassword);
        }
    }

    public void enterNewConfirmPassword(String password) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setNewPassword(password);
            iLoginPageObjects.setConfirmPasswordButton(password);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setNewPassword(password);
            aLoginPageObjects.setConfirmPasswordButton(password);
        }else {
            loginPageObjects.setNewPassword(password);
            loginPageObjects.setConfirmPasswordButton(password);
        }
    }

    public void enterNewDistinctConfirmPassword(String password, String distinctPassword) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.setNewPassword(password);
            iLoginPageObjects.setConfirmPasswordButton(distinctPassword);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.setNewPassword(password);
            aLoginPageObjects.setConfirmPasswordButton(distinctPassword);
        }else {
            loginPageObjects.setNewPassword(password);
            loginPageObjects.setConfirmPasswordButton(distinctPassword);
        }
    }

    public void verifySignUpPage() throws IOException {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.verifySignUpPage();
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.verifySignUpPage();
        }else {
            loginPageObjects.verifySignUpPage();
        }
    }

    public boolean validateEmailId(String email) {
        if (platform.equalsIgnoreCase("ios")){
            return iLoginPageObjects.validateEmail(email);
        }else if (platform.equalsIgnoreCase("android")){
            return aLoginPageObjects.validateEmail(email);
        }else {
            return loginPageObjects.validateEmail(email);
        }
    }

    public boolean validateMobileNumber(String mobileNumber) {
        if (platform.equalsIgnoreCase("ios")) {
            return iLoginPageObjects.validateMobileNumber(mobileNumber);
        } else if (platform.equalsIgnoreCase("android")) {
            return aLoginPageObjects.validateMobileNumber(mobileNumber);
        } else {
        return loginPageObjects.validateMobileNumber(mobileNumber);
        }
    }

    public boolean validateCountryCode(String mobileCode) throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            return iLoginPageObjects.validateCountryCode(mobileCode);
        }else if (platform.equalsIgnoreCase("android")){
            return aLoginPageObjects.validateCountryCode(mobileCode);
        }else {
            return loginPageObjects.validateCountryCode(mobileCode);
        }
    }

    public void validateMessageOldPassword(String message) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateOldPasswordMessage(message);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateOldPasswordMessage(message);
        }else {
            loginPageObjects.validateOldPasswordMessage(message);
        }
    }

    public void validateMessageNewPassword(String message) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateNewPasswordMessage(message);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateNewPasswordMessage(message);
        }else {
            loginPageObjects.validateNewPasswordMessage(message);
        }
    }

    public void validateMessageConfirmPassword(String message) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateConfirmPasswordMessage(message);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateConfirmPasswordMessage(message);
        }else {
            loginPageObjects.validateConfirmPasswordMessage(message);
        }
    }

    public void validatePasswordPoliciesOfUpperCase(String policy) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.assertUpperCaseValidation(policy);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.assertUpperCaseValidation(policy);
        }else {
            loginPageObjects.assertUpperCaseValidation(policy);
        }
    }

    public void validateInvalidOldPasswordMessage(String message1) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateInvalidOldPassword(message1);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateInvalidOldPassword(message1);
        }else {
            loginPageObjects.validateInvalidOldPassword(message1);
        }
    }

    public void validateInvalidConfirmPassword(String message3) {
        if (platform.equalsIgnoreCase("ios")){
            iLoginPageObjects.validateInvalidConfirmPassword(message3);
        }else if (platform.equalsIgnoreCase("android")){
            aLoginPageObjects.validateInvalidConfirmPassword(message3);
        }else {
            loginPageObjects.validateInvalidConfirmPassword(message3);
        }
    }

    public void validateErrorMessage(String message) throws Exception {
        if (platform.equalsIgnoreCase("ios")) {
            iLoginPageObjects.validateSuccessMessageBox(message);
        } else if (platform.equalsIgnoreCase("android")) {
            aLoginPageObjects.validateSuccessMessageBox(message);
        } else {
            loginPageObjects.validateErrorMessageBox(message);
        }
    }

    public void acceptPermissionMessages() {
        if (platform.equalsIgnoreCase("ios")) {
            iLoginPageObjects.acceptAlertMessages();
        }
    }

    public void selectLanguage(String appLanguage) throws Exception {
        if (platform.equalsIgnoreCase("ios")) {
//            iLoginPageObjects.validateSuccessMessageBox(message);
        } else if (platform.equalsIgnoreCase("android")) {
//            aLoginPageObjects.validateSuccessMessageBox(message);
        } else {
            loginPageObjects.selectLanguage(appLanguage);
        }
    }
}
