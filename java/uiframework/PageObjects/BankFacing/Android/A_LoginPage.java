package uiframework.PageObjects.BankFacing.Android;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uiframework.DomainObjects.Utility;
import uiframework.MobileUtility.AndroidUtility;

import java.util.List;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;


public class A_LoginPage extends TestBase {

    @FindBy(xpath = "//*[@text='While using the app']")
    WebElement accessPopup;
    @FindBy(xpath = "//*[@text='Allow']")
    WebElement allowBtn;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__userId']")
    WebElement emailId;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__pswd']")
    WebElement password;
    @FindBy(xpath = "//*[@resource-id='bfplog__Login__element_button_1']")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.Image")
    WebElement dashboard;

    @FindBy(xpath = "//android.view.View[@resource-id='bfplog__ChangePasswordBeforeLogin__el_txt_1']")
    WebElement changePswdScreeen;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfplog__ChangePasswordBeforeLogin__element_button_2']")
    WebElement changePswdBtn;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='bfplog__ChangePasswordBeforeLogin__oldPassword_ERR_TEXT_txtcnt']")
    WebElement chngPsderrorMsg1;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='bfplog__ChangePasswordBeforeLogin__newPassword_ERR_TEXT_txtcnt']")
    WebElement chngPsderrorMsg2;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='bfplog__ChangePasswordBeforeLogin__confirmPassword_ERR_TEXT_txtcnt']")
    WebElement chngPsderrorMsg3;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='bfplog__ChangePasswordBeforeLogin__Old_Password_Validate_Row_txtcnt']")
    WebElement oldPsdMsg;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfplog__ChangePasswordBeforeLogin__oldPassword']")
    WebElement oldPswd;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__element_button_2")
    WebElement changePswdConfirmBtn;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfplog__ChangePasswordBeforeLogin__newPassword']")
    WebElement newPassword;
    @FindBy(xpath = "//android.widget.TextView[@text='New password & confirm password is not same.']")
    WebElement confirmPsdErrorMSg;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfplog__ChangePasswordBeforeLogin__confirmPassword']")
    WebElement ConfirmPsdBtn;
    @FindBy(xpath = "//*[@id='bfplog__ChangePasswordBeforeLogin__sc_row_3']")
    WebElement psdPolicy;
    @FindBy(xpath = "//android.widget.TextView[@text='Password validation failed.']")
    WebElement policy_psdFaildMsg;

    @FindBy(xpath = "//android.widget.TextView[@text='Invalid password.']")
    WebElement loginFaildMsg;
    @FindBy(xpath = "//android.widget.TextView[@text='رمز مرور خاطئ.']")
    WebElement loginFaildMsgArabic;
    @FindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    WebElement OTPokBtn;
    @FindBy(xpath = "//android.widget.Button[@text='نعم']")
    WebElement OkBtnArabic;
    @FindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement okBtn1;
    @FindBy(xpath = "//android.widget.TextView[@text='User Account is Locked, Please try after some time']")
    WebElement userErrorLockMsg;

    @FindBy(xpath = "//p[contains(text(),'OTP has sent to your E-mail ID and phone number.')]")
    WebElement otpMsg;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpotp__OTPScreen__OTP']")
    WebElement otpScreen;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpotp__OTPScreen__Verify']")
    WebElement verifyBtn;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpotp__OTPScreen__ResendOtp']")
    WebElement resentOTPlink;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpotp__OTPScreen__OTP']")
    WebElement otpTxtBox;
    @FindBy(xpath = "//p[contains(text(),'Invalid OTP.')]")
    WebElement invalidOtpErrorMsg1;
    @FindBy(xpath = "//p[contains(text(),'Maximum retries count have reached.')]")
    WebElement invalidOtpErrorMsg2;
    @FindBy(xpath = "//p[contains(text(),'Maximum retries count have reached.')]")
    WebElement invalidOtpErrorMsg3;
    @FindBy(xpath = "//p[contains(text(),'00:00')]")
    WebElement OTPtimer;
    @FindBy(xpath = "//android.widget.Spinner[@text='English']")
    WebElement englishTxtBox;
    @FindBy(xpath = "//android.view.View")
    List<WebElement> viewTxt;
    @FindBy(xpath = "//*[@text='عربي']")
    WebElement arabicBtn;


    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private AndroidUtility utilities;

    public A_LoginPage() {
        PageFactory.initElements(appiumDriver, this);
        commonElements = new CommonElements();
        commonDriver = new CommonDriver(appiumDriver);
        textBoxControls = new TextBoxControls();
        waitUtility = new WaitUtility();
        windowHandling = new WindowHandling(appiumDriver);
        screenshotControl = new ScreenshotControl(appiumDriver);
        javaScriptControls = new JavaScriptControls(appiumDriver);
        utilities = new AndroidUtility();
    }

    public void click_ok_button(String appLanguage) throws Exception {
        if (appLanguage.equalsIgnoreCase("arabic")) {
            try {
                utilities.click(OkBtnArabic);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                utilities.click(okBtn1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void changelanguage(String language) throws Exception {
        utilities.waitForSeconds(4);
        try {
            utilities.click(englishTxtBox);
            utilities.selectFromDropDown(viewTxt, language);
        } catch (Exception e) {

        }
        utilities.waitForSeconds(2);
    }


    public void isOtpMsg_displayed(String msg) throws Exception {
        utilities.waitForSeconds(2);
        commonElements.isElementVisible(otpMsg);
        Assert.assertEquals(msg, commonElements.getText(otpMsg));
        utilities.click(okBtn);
    }

    public void enter_invalid_OTP_validation(String msg1, String msg2) throws Exception {
        for (int i = 1; i <= 4; i++) {
            utilities.sendKeys(otpTxtBox, "789000");
            click_verify_button();
            utilities.waitForSeconds(2);
            try {
                commonElements.isElementVisible(invalidOtpErrorMsg1);
                Assert.assertEquals(msg1, commonElements.getText(invalidOtpErrorMsg1));
                utilities.click(okBtn1);
            } catch (Exception e) {
                commonElements.isElementVisible(invalidOtpErrorMsg3);
                Assert.assertEquals(msg2, commonElements.getText(invalidOtpErrorMsg3));
                utilities.click(okBtn1);
            }
        }

    }

    public void enter_valid_otp() throws Exception {
        utilities.waitForSeconds(130);
        click_verify_button();
        utilities.waitForSeconds(4);
    }

    public void validateMessageBox(String message) throws Exception {
//        utility.validateSuccessMessageBox(message);
        utilities.click(okBtn);
    }

    public void is_otp_screen_displayed(String appLanguage) throws Exception {
        utilities.waitForSeconds(15);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            utilities.click(OkBtnArabic);
        } else {
            try {
                utilities.click(OTPokBtn);
            } catch (Exception e) {
                utilities.click(okBtn);
            }
        }
        utilities.waitForSeconds(1);
        commonElements.isElementVisible(otpScreen);
    }

    public void click_resent_OTP_nTime() throws Exception {
        commonElements.isElementVisible(resentOTPlink);
        utilities.waitForSeconds(160);
        commonElements.isElementVisible(OTPtimer);
        try {
            for (int i = 1; i < 4; i++) {
                utilities.click(resentOTPlink);
                utilities.waitForSeconds(2);
                utilities.click(okBtn);
                utilities.waitForSeconds(160);
            }
        } catch (Exception e) {
            utilities.waitForSeconds(2);
            utilities.click(okBtn1);
            utilities.waitForSeconds(160);
            System.out.println(e);
        }

    }

    public void otp_max_Resent_Error_validations(String msg) throws Exception {
        commonElements.isElementVisible(invalidOtpErrorMsg3);
        Assert.assertEquals(msg, commonElements.getText(invalidOtpErrorMsg3));
        try {
            utilities.click(okBtn);
        } catch (Exception e) {
            utilities.click(okBtn1);
        }
    }

    public void click_resentOTP_link() throws Exception {
        Boolean b = commonElements.isElementVisible(resentOTPlink);
        utilities.waitForSeconds(155);
        try {
            if (b) {
                utilities.click(resentOTPlink);
                utilities.waitForSeconds(2);
                utilities.click(okBtn1);
            }
        } catch (Exception e) {
            utilities.waitForSeconds(2);
            utilities.click(okBtn);
            System.out.println(e);
        }

    }

    public void click_verify_button() throws Exception {
        utilities.click(verifyBtn);
    }

    public void is_loginpage_displayed() throws Exception {
        try {
            utilities.waitForSeconds(4);
            commonElements.isElementVisible(emailId);
        } catch (Exception e) {

        }
    }


    public void clickOtpResendLink(String appLanguage) throws Exception {
        try {
            utilities.waitForSeconds(5);
            utilities.click(resentOTPlink);
            utilities.waitForSeconds(2);
            utilities.click(OTPokBtn);
        } catch (Exception e) {
            click_ok_button(appLanguage);
        }
    }

    public void enterUserName(String username) throws Exception {
        utilities.waitForSeconds(6);
        try {
            utilities.click(accessPopup);
            utilities.click(allowBtn);
        } catch (Exception e) {

        }
        utilities.waitForSeconds(2);
        utilities.clearText(emailId);
        utilities.sendKeys(emailId, username);
    }

    public void enterPassword(String passWord) throws Exception {
        utilities.clearText(password);
        utilities.sendKeys(password, passWord);
    }


    public void ClickLoginButton() throws Exception {
        utilities.waitForSeconds(2);
        try {
            utilities.click(loginBtn);
        }catch(Exception e){

        }
    }

    public void isDashboard() throws Exception {
        utilities.waitForSeconds(4);
        commonElements.isElementVisible(dashboard);
    }


    public void isChangePswdScreenDisplayed() throws Exception {
        utilities.waitForSeconds(8);
        commonElements.isElementVisible(changePswdScreeen);

    }

    public void ClickChangePswdButton() throws Exception {
        try {
            appiumDriver.hideKeyboard();
        } catch (Exception e) {

        }
        utilities.click(changePswdBtn);
    }

    public void checkErrorMsgOnScreen() throws Exception {
        utilities.waitForSeconds(8);
        try {
            commonElements.isElementVisible(chngPsderrorMsg1);
            commonElements.isElementVisible(chngPsderrorMsg2);
            commonElements.isElementVisible(oldPsdMsg);
        } catch (Exception e) {
            try {
                commonElements.isElementVisible(chngPsderrorMsg3);
            } catch (Exception e1) {

            }
        }

    }

    public void enter_old_system_password(String passWord) throws Exception {
        utilities.waitForSeconds(2);
        utilities.click(oldPswd);
        utilities.sendKeys(oldPswd, passWord);
        try {
            appiumDriver.hideKeyboard();
        } catch (Exception e) {

        }

    }

    public void enterWrongPassword(String passWord) throws Exception {
        utilities.sendKeys(oldPswd, passWord);

    }

    public void ClickChangePswdconfirmButton() throws Exception {
        utilities.click(changePswdConfirmBtn);

    }

    public void enterNewPswd(String Newpassword) throws Exception {
        utilities.click(newPassword);
        utilities.sendKeys(newPassword, Newpassword);

    }

    public void enterConfirmPswd(String Confirmword) throws Exception {
        utilities.click(ConfirmPsdBtn);
        utilities.sendKeys(ConfirmPsdBtn, Confirmword);

    }

    public void confirmPsd_error_Msg_displayed() throws Exception {
        try {
            commonElements.isElementVisible(confirmPsdErrorMSg);
        } catch (Exception e) {

        }
    }

    public void isErrorLoginMsgDisplayed(String appLanguage) throws Exception {
        utilities.waitForSeconds(3);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            commonElements.isElementVisible(loginFaildMsgArabic);
            utilities.click(OkBtnArabic);
        } else {
            commonElements.isElementVisible(loginFaildMsg);
            utilities.click(OTPokBtn);
        }
        utilities.waitForSeconds(3);
    }

    public void is_lock_ErrorMsgDisplayed() throws Exception {
        try {
            try {
                utilities.waitForSeconds(2);
                commonElements.isElementVisible(userErrorLockMsg);
                utilities.click(OTPokBtn);
            } catch (Exception e) {
                utilities.waitForSeconds(1);
                commonElements.isElementVisible(loginFaildMsg);
                utilities.click(OTPokBtn);
                System.out.println(e);
            }
        } catch (Exception e1) {
        }

    }

    public void check_password_policy() throws Exception {
        commonElements.isElementVisible(psdPolicy);
        String rgbFormat = commonElements.getCssValue(psdPolicy, "background-color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexcolor);
        if (hexcolor.equals("#ffffff")) {
            System.out.println("password should satisfy password policy");
            Assert.fail();
        }

    }

    public void check_policy_password_msg_present() throws Exception {
        try {
            commonElements.isElementVisible(policy_psdFaildMsg);
            utilities.click(okBtn);
        } catch (Exception e) {
            confirmPsd_error_Msg_displayed();
        }
    }

    public void setOtpField(String value) throws Exception {
        utilities.waitForSeconds(3);
        utilities.sendKeys(otpTxtBox, value);

    }

    public void clickOtpVerifyButton(String appLanguage) throws Exception {
        utilities.waitForSeconds(2);
        try {
            utilities.click(verifyBtn);
            utilities.waitForSeconds(4);
            utilities.click(OTPokBtn);
        } catch (Exception e) {
            click_ok_button(appLanguage);
        }
    }

}


