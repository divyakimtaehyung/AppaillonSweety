package uiframework.PageObjects.BankFacing.IOS;

import com.iexceed.uiframework.core.TestBase;

import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ScreenshotState;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.TestRunner;
import uiframework.DomainObjects.Utility;

import java.util.List;


public class I_LoginPage extends TestBase {
    public static WebDriver driver = TestBase.getDriver();


    @FindBy(id = "bfplog__Login__userId")
    WebElement emailId;
    @FindBy(id = "bfplog__Login__pswd")
    WebElement password;
    @FindBy(id = "bfplog__Login__element_button_1")
    WebElement loginBtn;
    @FindBy(id = "bfpapp__BasePage__userProfileImg")
    WebElement dashboard;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__el_label_1")
    WebElement changePswdScreeen;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__element_button_2")
    WebElement changePswdBtn;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__newPassword_ERR_TEXT_txtcnt")
    WebElement chngPsderrorMsg1;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__confirmPassword_ERR_TEXT_txtcnt")
    WebElement chngPsderrorMsg2;
    @FindBy(id = "//p[contains(text(),'Password validation failed.')]")
    WebElement chngPsderrorMsg3;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__oldPassword_ERR_TEXT")
    WebElement oldPsdMsg;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__oldPassword")
    WebElement oldPswd;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__element_button_2")
    WebElement changePswdConfirmBtn;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__newPassword")
    WebElement newPassword;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__el_txt_6_txtcnt")
    WebElement confirmPsdErrorMSg;
    @FindBy(id = "bfplog__ChangePasswordBeforeLogin__confirmPassword")
    WebElement ConfirmPsdBtn;
    @FindBy(xpath = "//*[@id='bfplog__ChangePasswordBeforeLogin__sc_row_3']")
    WebElement psdPolicy;
    @FindBy(xpath = "//p[contains(text(),'Password validation failed.')]")
    WebElement policy_psdFaildMsg;

    @FindBy(xpath = "//p[contains(text(),'Email-ID/Password is invalid')]")
    WebElement loginFaildMsg;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement okBtn;
    @FindBy(xpath = "//*[text()='نعم']")
    WebElement okBtnArabic;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okBtn1;
    @FindBy(xpath = "//p[contains(text(),'User Account is Locked, Please try after some time')]")
    WebElement userErrorLockMsg;

    @FindBy(xpath = "//p[contains(text(),'OTP has sent to your E-mail ID and phone number')]")
    WebElement otpMsg;
    @FindBy(xpath = "//input[@id='bfpotp__OTPScreen__OTP']")
    WebElement otpScreen;
    @FindBy(id = "bfpotp__OTPScreen__Verify")
    WebElement verifyBtn;
    @FindBy(id = "bfpotp__OTPScreen__ResendOtp_li")
    WebElement resentOTPlink;
    @FindBy(id = "bfpotp__OTPScreen__OTP")
    WebElement otpTxtBox;
    @FindBy(xpath = "//p[contains(text(),'Invalid OTP.')]")
    WebElement invalidOtpErrorMsg1;
    @FindBy(xpath = "//p[contains(text(),'Maximum retries count have reached.')]")
    WebElement invalidOtpErrorMsg2;
    @FindBy(xpath = "//p[contains(text(),'Maximum retries count have reached.')]")
    WebElement invalidOtpErrorMsg3;
    @FindBy(xpath = "//p[contains(text(),'00:00')]")
    WebElement OTPtimer;
    @FindBy(xpath = "//span[@id='select2-bfplog__Login__langChangeDD-container']")
    WebElement englishTxtBox;
    @FindBy(xpath = "//ul[@id='select2-bfplog__Login__langChangeDD-results']/li")
    List<WebElement> languageDD;

    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private Utility utility;

//    private final Utility utilities;


    public I_LoginPage() {

        PageFactory.initElements(driver, this);
        commonElements = new CommonElements();
        commonDriver = new CommonDriver(driver);
        textBoxControls = new TextBoxControls();
        waitUtility = new WaitUtility();
        windowHandling = new WindowHandling(driver);
        screenshotControl = new ScreenshotControl(driver);
        javaScriptControls = new JavaScriptControls(driver);
        utility = new Utility();


    }


    public void changelanguage(String language) throws Exception {
        utility.waitForSeconds(4);
        try {
            utility.click(englishTxtBox);
            utility.selectFromDropDown(languageDD, language);
        } catch (Exception e) {
            System.out.println(e);
        }
        utility.waitForSeconds(4);
    }

    public void click_ok_button(String appLanguage) throws Exception {
        utility.waitForSeconds(4);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            try {
                utility.click(okBtnArabic);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            utility.waitForSeconds(8);
            try {
                utility.click(okBtn1);
            } catch (Exception e) {
                utility.click(okBtn);
            }
        }
    }

    public void isOtpMsg_displayed(String msg) throws Exception {
        utility.waitForSeconds(10);
        utility.waitForElement(otpMsg);
        Assert.assertEquals(msg, commonElements.getText(otpMsg));
        utility.click(okBtn);
    }

    public void enter_invalid_OTP_validation(String msg1, String msg2) throws Exception {
        for (int i = 1; i <= 4; i++) {
            utility.sendKeys(otpTxtBox, "789000");
            click_verify_button();
            utility.waitForSeconds(2);
            try {
                utility.waitForElement(invalidOtpErrorMsg1);
                Assert.assertEquals(msg1, commonElements.getText(invalidOtpErrorMsg1));
                utility.click(okBtn1);
            } catch (Exception e) {
                utility.waitForElement(invalidOtpErrorMsg3);
                Assert.assertEquals(msg2, commonElements.getText(invalidOtpErrorMsg3));
                utility.click(okBtn1);
            }
        }

    }

    public void enter_valid_otp() throws Exception {
        utility.waitForSeconds(100);
        utility.sendKeys(otpTxtBox, "291186");
        click_verify_button();
        utility.waitForSeconds(4);
    }

    public void is_otp_screen_displayed(String appLanguage) throws Exception {
        utility.waitForSeconds(9);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            utility.click(okBtnArabic);
        } else {
            utility.waitForSeconds(3);
            try {
                utility.click(okBtn);
            } catch (Exception e) {
                utility.click(okBtn1);
            }
        }
        utility.waitForSeconds(4);
        commonElements.isElementVisible(otpScreen);
    }

    public void click_resent_OTP_nTime() throws Exception {
        utility.waitForElement(resentOTPlink);
        utility.waitForSeconds(160);
        utility.waitForElement(OTPtimer);
        try {
            for (int i = 1; i < 4; i++) {
                utility.click(resentOTPlink);
                utility.waitForSeconds(2);
                utility.click(okBtn);

            }
        } catch (Exception e) {
            utility.waitForSeconds(2);
            utility.click(okBtn1);
        }
        utility.waitForSeconds(160);
    }

    public void otp_max_Resent_Error_validations(String msg) throws Exception {
        utility.waitForElement(invalidOtpErrorMsg3);
        Assert.assertEquals(msg, commonElements.getText(invalidOtpErrorMsg3));
        try {
            utility.click(okBtn);
        } catch (Exception e) {
            utility.click(okBtn1);
        }
    }

    public void click_resentOTP_link() throws Exception {
        utility.waitForElement(resentOTPlink);
        try {
            utility.click(resentOTPlink);
            utility.waitForSeconds(2);
            utility.click(okBtn1);
        } catch (Exception e) {
            utility.waitForSeconds(2);
            utility.click(okBtn);
        }

    }

    public void click_verify_button() throws Exception {
        utility.click(verifyBtn);
    }


    public void reFresh() {
        driver.navigate().refresh();
    }

    public void is_loginpage_displayed() {
        utility.waitForElement(emailId);
    }

    public void verifyLoginPage() {
        utility.waitForElement(emailId);
    }

    public void setLoginEmailID(String value) throws Exception {
        utility.sendKeys(emailId, value);
    }

    public void setLoginPassword(String value) throws Exception {
        utility.sendKeys(password, value);
    }


    public void enterUserName(String username) throws Exception {
        utility.waitForSeconds(10);
        utility.sendKeys(emailId, username);
    }

    public void enterPassword(String passWord) throws Exception {
        textBoxControls.clearText(password);
        utility.sendKeys(password, passWord);
    }


    public void ClickLoginButton() throws Exception {
        utility.waitForElement(loginBtn);
        utility.click(loginBtn);
    }

    public void isDashboard() throws Exception {
        utility.waitForElement(dashboard);
    }


    public void isChangePswdScreenDisplayed() throws Exception {
        utility.waitForElement(changePswdScreeen);
    }

    public void setOldPassword(String value) throws Exception {
        utility.sendKeys(oldPswd, value);
    }

    public void setNewPassword(String value) throws Exception {
        utility.sendKeys(newPassword, value);
    }

    public void setConfirmPasswordButton(String value) throws Exception {
        utility.sendKeys(ConfirmPsdBtn, value);
    }

    public void ClickChangePswdButton() throws Exception {
        utility.waitForSeconds(3);
        utility.click(changePswdBtn);
    }

    public void validateMessageBox(String message) throws Exception {
        utility.validateSuccessMessageBox(message);
//        utility.click(okBtn);
    }

    public void clickokBtn() throws Exception {
        utility.waitForElement(okBtn);
        utility.click(okBtn);
    }

    public void verifyOtpScreen() {
        utility.waitForElement(otpScreen);
    }

    public void clickOtpResendLink() throws Exception {
        utility.click(resentOTPlink);
    }


    public void checkErrorMsgOnScreen() throws Exception {
        utility.waitForSeconds(5);
        try {
            commonElements.isElementVisible(chngPsderrorMsg1);
            commonElements.isElementVisible(chngPsderrorMsg2);
            commonElements.isElementVisible(oldPsdMsg);
        } catch (Exception e) {
            commonElements.isElementVisible(chngPsderrorMsg3);
        }

    }

    public void enterWrongPassword(String passWord) throws Exception {
        utility.sendKeys(oldPswd, passWord);
    }

    public void ClickChangePswdconfirmButton() throws Exception {
        utility.click(changePswdConfirmBtn);
        utility.waitForSeconds(6);
    }

    public void enterNewPswd(String Newpassword) throws Exception {
        utility.sendKeys(newPassword, Newpassword);
    }

    public void enterConfirmPswd(String Confirmword) throws Exception {
        utility.sendKeys(ConfirmPsdBtn, Confirmword);
    }

    public void confirmPsd_error_Msg_displayed() throws Exception {
        utility.waitForElement(confirmPsdErrorMSg);
    }

    public void isErrorLoginMsgDisplayed(String appLanguage) throws Exception {
        utility.waitForSeconds(10);
        if(appLanguage.equalsIgnoreCase("arabic")){
            try {
                utility.click(okBtnArabic);
            }catch(Exception e){}
        }else {
            utility.click(okBtn);
        }
    }

    public void setOtpField(String value) throws Exception {
        utility.waitForElement(otpTxtBox);
        utility.sendKeys(otpTxtBox, value);
    }

    public void clickOtpVerifyButton() throws Exception {
        utility.waitForSeconds(5);
        utility.click(verifyBtn);
        utility.waitForSeconds(5);
        try {
            utility.click(okBtn1);
        } catch (Exception e) {
        }
    }


    public void is_lock_ErrorMsgDisplayed() throws Exception {
        try {
            utility.waitForSeconds(2);
            utility.waitForElement(userErrorLockMsg);
            utility.click(okBtn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void check_password_policy() throws Exception {
        utility.waitForElement(psdPolicy);
        String rgbFormat = commonElements.getCssValue(psdPolicy, "background-color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexcolor);
        if (hexcolor.equals("#ffffff")) {
            System.out.println("password should satisfy password policy");
            Assert.fail();
        }

    }

    public void check_policy_password_msg_present(String msg) throws Exception {
        try {
            utility.click(changePswdConfirmBtn);
        } catch (Exception e) {
            System.out.println(e);
        }
        utility.waitForElement(policy_psdFaildMsg);
        Assert.assertEquals(msg, commonElements.getText(policy_psdFaildMsg));
        utility.click(okBtn);
    }


}


