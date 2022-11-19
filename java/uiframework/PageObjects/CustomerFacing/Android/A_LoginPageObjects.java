package uiframework.PageObjects.CustomerFacing.Android;

import com.iexceed.uiframework.core.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiframework.MobileUtility.AndroidUtility;

import java.util.List;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class A_LoginPageObjects extends TestBase{


	//Login page Objects

	@FindBy(xpath = "//*[@resource-id='cfplog__Login__el_txt_5']")
	WebElement loginPageTitle;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__langChangeDD']")
	WebElement languageButton;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__langCwhangeDD_div']/android.view.View/android.view.View")
	List<WebElement> languageList;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__userId']")
	WebElement loginEmailID;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__pswd']")
	WebElement loginPassword;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__element_button_1']")
	WebElement loginButton;
	@FindBy(xpath = "//*[@resource-id='cfplog__Login__signUpLink']")
	WebElement signUplink;

	//Signup Page Objects
	@FindBy(xpath = "//*[@resource-id='cfpsgn__SignUp__emailId']")
	WebElement signUpEmailId;
	@FindBy(xpath = "//*[@resource-id='cfpsgn__SignUp__mobCode_li']/android.view.View/android.widget.Spinner")
	WebElement signUpMobileCode;
	@FindBy(xpath = "//*[@resource-id='select2-cfpsgn__SignUp__mobCode-container']")
	WebElement signUPMobileCodeText;
	@FindBy(xpath = "//*[@resource-id='cfpsgn__SignUp__mobileNum']")
	WebElement signUpMobileNumber;
	@FindBy(xpath = "//*[@resource-id='cfpsgn__SignUp__signUpBtn']")
	WebElement signUpButton;

	//OTP Page Objects
	@FindBy(xpath = "//*[@resource-id='cfpotp__OTPScreen__OTP']")
	WebElement otpField;
	@FindBy(xpath = "//*[@resource-id='cfpotp__OTPScreen__ResendOtp']")
	WebElement otpResendLink;
	@FindBy(xpath = "//*[@resource-id='cfpotp__OTPScreen__Verify']")
	WebElement otpVerifyButton;

	//Change Password Screen Objects
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__oldPassword']")
	WebElement oldPassword;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__newPassword']")
	WebElement newPassword;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__confirmPassword']")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__element_button_2']")
	WebElement confirmPasswordButton;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__oldPassword_ERR_TEXT_txtcnt']")
	WebElement oldPasswordMessage;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__Old_Password_Validate_Row_txtcnt']")
	WebElement oldPasswordValidationMessage;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__newPassword_ERR_TEXT_txtcnt']")
	WebElement newPasswordMessage;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__confirmPassword_ERR_TEXT_txtcnt']")
	WebElement confirmPasswordMessage;
	@FindBy(xpath = "//*[@resource-id='cfplog__ChangePassword__el_txt_6_txtcnt']")
	WebElement confirmPasswordDistinctMessage;


	private final AndroidUtility utilities;

	public A_LoginPageObjects(){
		PageFactory.initElements(appiumDriver,this);
		utilities = new AndroidUtility();
	}

	public void selectLanguage(String language) throws Exception {
		if (language.equalsIgnoreCase("english")){
			utilities.listSelection(languageButton,languageList,"en");
		}else {
			utilities.listSelection(languageButton,languageList,"ar");
			utilities.click(languageButton);
			utilities.waitForElementTextVisible(loginPageTitle,"مرحبًا بكم في Appzillon مصرف");
		}
	}

	public void setLoginEmailID(String value) throws Exception {
		utilities.sendKeys(loginEmailID,value);
	}

	public void setLoginPassword(String value) throws Exception {
		utilities.sendKeys(loginPassword,value);
	}

	public void clickLoginButton() throws Exception {
		utilities.click(loginButton);
	}

	public void clickSignUplink() throws Exception {
		utilities.click(signUplink);
	}

	public void setSignUpEmailId(String value) throws Exception {
		utilities.waitForElement(signUpEmailId);
		utilities.waitForTextVisible(signUpMobileCode);
		utilities.sendKeys(signUpEmailId,value);
	}

	public void selectSignUpMobileCode(String value) throws Exception {
//		utilities.click(signUpMobileCode);
//		utilities.waitForElement(signUPMobileCodeText);
//		utilities.sendKeys(signUPMobileCodeText,value);
//		System.out.println(signUPMobileCodeText.getText());
//		utilities.selectFromDropDown(signUpMobileCode,value);
	}

	public void setSignUpMobileNumber(String value) throws Exception {
		utilities.sendKeys(signUpMobileNumber,value);
	}

	public void clickSignUpButton() throws Exception {
		utilities.click(signUpButton);
	}

	public void setOtpField(String value) throws Exception {
		utilities.waitForElement(otpField);
		utilities.sendKeys(otpField,value);
	}

	public void clickOtpResendLink() throws Exception {
		utilities.click(otpResendLink);
	}

	public void clickOtpVerifyButton() throws Exception {
		utilities.click(otpVerifyButton);
	}

	public void clickChangeConfirmButton() throws Exception {
		utilities.click(confirmPasswordButton);
	}


	public void setOldPassword(String value) throws Exception {
		utilities.sendKeys(oldPassword,value);
		utilities.click(oldPassword);
	}

	public void setNewPassword(String value) throws Exception {
		utilities.click(newPassword);
		utilities.sendKeys(newPassword,value);
	}

	public void setConfirmPasswordButton(String value) throws Exception {
		utilities.sendKeys(confirmPassword,value);
	}


	public void assertUpperCaseValidation(String value){
		//Vaiidation cannot be done due to Android CSS
	}


	public void verifyChangePasswordScreen() {
		utilities.waitForElement(oldPassword);
	}

	public void verifyOtpScreen() {
		utilities.waitForElement(otpField);
	}

	public void verifyLoginPage() {
			utilities.waitForElement(loginEmailID);
	}

	public void validateSuccessMessageBox(String message) throws Exception {
		utilities.validateSuccessMessageBox(message);
	}

    public void verifySignUpPage() {
		utilities.waitForElement(signUpEmailId);
    }

    public boolean validateEmail(String email) {
		return utilities.checkSameTextEnteredPresent(signUpEmailId,email);
    }

	public boolean validateMobileNumber(String mobileNumber) {
		return utilities.checkSameTextEnteredPresent(signUpMobileNumber,mobileNumber);
	}

	public boolean validateCountryCode(String mobileCode) throws Exception {
		utilities.waitForSeconds(2);
		return utilities.checkSameTextEnteredPresent(signUPMobileCodeText,mobileCode);
	}

	public void validateOldPasswordMessage(String message) {
		utilities.assertMessage(oldPasswordMessage,message);
	}

	public void validateNewPasswordMessage(String message) {
		utilities.assertMessage(newPasswordMessage,message);
	}

	public void validateConfirmPasswordMessage(String message) {
		utilities.assertMessage(confirmPasswordMessage,message);
	}

	public void validateInvalidOldPassword(String message1) {
		utilities.assertMessage(oldPasswordValidationMessage,message1);
	}

	public void validateInvalidConfirmPassword(String message3) {
		utilities.assertMessage(confirmPasswordDistinctMessage,message3);
	}

}