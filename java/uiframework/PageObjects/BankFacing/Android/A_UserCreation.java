package uiframework.PageObjects.BankFacing.Android;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.cucumber.messages.internal.com.google.common.collect.ImmutableMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uiframework.DomainObjects.Utility;
import uiframework.MobileUtility.AndroidUtility;

import java.util.List;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class A_UserCreation extends TestBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpusr__UserMgtCreation__UserName']")
    WebElement userName;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpusr__UserMgtCreation__UserEmailId']")
    WebElement emailId;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpusr__UserMgtCreation__CountryPhoneNumber']")
    WebElement mobileNumber;
    @FindBy(xpath = "//*[@text='+376']")
    WebElement mobCodeDD;
    @FindBy(xpath = "//*[@text='+268']")
    WebElement MobileCodeTemp;
    @FindBy(xpath = "//android.widget.ListView[@resource-id='select2-bfpusr__UserCreation__CountryCodes-results']")
    List<WebElement> mobileCode;
    @FindBy(xpath = "//*[@text='Bank admin Initiator']")
    WebElement roleDD;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='select2-bfpusr__roleIdMap__i__RoleNode__RoleId_0-container']")
    List<WebElement> roleID;
    @FindBy(xpath = "//*[@text='بادر مسؤول البنك']")
    WebElement roleDDArabic;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='select2-bfpusr__roleIdMap__i__RoleNode__RoleId_0-container']")
    List<WebElement> roleIDArabic;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpusr__UserMgtCreation__el_btn_14']")
    WebElement submitBtn;
    @FindBy(xpath = "//android.widget.Button[@text='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//android.widget.Button[@text='حفظ']")
    WebElement saveBtnArabic;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpusr__UserMgtVerify__el_btn_4']")
    WebElement confirmBtn;
    @FindBy(xpath = "//android.widget.TextView[@text='There is a server issue, contact system adminstrator']")
    WebElement serverError;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpusr__UserMgtCreation__el_btn_13_txtcnt']")
    WebElement cancelBtn;
    @FindBy(xpath = "//android.widget.Button[@text='يلغي']")
    WebElement cancelBtnArabic;
    @FindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//android.widget.Button[@text='نعم']")
    WebElement okBtnArabic;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpusr__UserMgtSummary__createUserBtn']")
    WebElement createNewUSer;

    @FindBy(xpath = "//android.widget.ListView[@resource-id='bfpusr__UserMgtLanding__successHeader']")
    WebElement userSucessMg;
    @FindBy(xpath = "//p[contains(text(),'Invalid Email ID')]")
    WebElement invalidMailMsg;
    @FindBy(xpath = "//android.widget.Button[text()='OK']")
    WebElement OKBtn;
    @FindBy(xpath = "//p[contains(text(),'User Created successfully.')]")
    WebElement userCreationMsg;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpusr__UserMgtCreation__browse']")
    WebElement uploadPhoto;
    @FindBy(xpath = "//p[contains(text(),'Unsupported file format.')]")
    WebElement uploadErrorMsg;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='bfpusr__UserMgtCreation__applicationName']")
    WebElement applicationPredefinedValue;
    @FindBy(xpath = "//android.widget.Spinner[@text='+376']")
    WebElement mobCodeDefineValue;
    @FindBy(xpath = "//android.widget.Spinner[@text='Bank admin Initiator']")
    WebElement roleIDdefinedValue;
    @FindBy(xpath = "//android.widget.Button[text()='Ok']")
    WebElement okayBtn;
    @FindBy(id = "bfpusr__UserMgtSummary__emailId")
    WebElement UserMngMntEmailID;
    @FindBy(id = "bfpusr__UserMgtSummary__SearchBtn_txtcnt")
    WebElement searchBtn;

    Utility utils = new Utility();

    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private AndroidUtility utilities;
    private static Logger LOGGER = LogManager.getLogger(A_UserCreation.class);

    public A_UserCreation() {
        PageFactory.initElements(appiumDriver, this);
        commonElements = new CommonElements();
        commonDriver = new CommonDriver(appiumDriver);
        textBoxControls = new TextBoxControls();
        waitUtility = new WaitUtility();
        windowHandling = new WindowHandling(appiumDriver);
        screenshotControl = new ScreenshotControl(appiumDriver);
        javaScriptControls = new JavaScriptControls(appiumDriver);
        utils = new Utility();
        utilities = new AndroidUtility();
    }

    public void clickOKBtn() {
        try {
            utilities.click(okBtn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enterUsername(String username) throws Exception {
        clickOKBtn();
        utilities.waitForSeconds(3);
        userName.clear();
        utilities.sendKeys(userName, username);

    }

    public void create_new_user() throws Exception {
        utilities.click(createNewUSer);
        utilities.waitForSeconds(3);
    }

    public void enterEmail(String email) throws Exception {
        emailId.clear();
        utilities.sendKeys(emailId, email);
    }

    public void selectMobCode(String mobCode) throws Exception {
//        commonElements.click(mobCodeDD);
//        String mcode = "+" + mobCode;
//                commonElements.click(MobileCodeTemp);
//        textBoxControls.setText(mobCodeDD,mcode);
//        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
//        utils.selectionItemVisible(mcode,mobileCode);
//        utils.selectFromDropDown(mobileCode,mcode);

    }

    public void enterMobileNumber(String mobileNum) throws Exception {
        mobileNumber.clear();
        utilities.sendKeys(mobileNumber, mobileNum);
    }

    public void selectRole(String role, String language) throws Exception {

        try {
            appiumDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (language.equalsIgnoreCase("arabic")) {
            try {
                utilities.click(roleDDArabic);
                utilities.selectFromDropDown(roleIDArabic, role);
            } catch (Exception e) {

            }
        } else {
            utilities.click(roleDD);
            utilities.selectFromDropDown(roleID, role);
        }

    }

    public void clickSaveBtn() throws Exception {
        clickOk();
        utilities.waitForSeconds(2);
        utilities.click(submitBtn);
    }

    public void clickConfirm_Btn(String appLanguage) throws Exception {
        if (appLanguage.equalsIgnoreCase("arabic")) {
            try {
                utilities.click(saveBtnArabic);
            } catch (Exception e) {

            }
        } else {
            try {
                utilities.click(saveBtn);
            } catch (Exception e) {

            }
        }
        utilities.waitForSeconds(2);
        utilities.click(confirmBtn);
    }


    public void isUserCreationMsgPresent(String appLanguage) throws Exception {
        utilities.waitForSeconds(14);
        commonElements.isElementVisible(userSucessMg);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            utilities.click(okBtnArabic);
        } else {
            utilities.click(okBtn);
        }

    }


    public void clickCancel(String appLanguage) throws Exception {
        if (appLanguage.equalsIgnoreCase("arabic")) {
            utilities.click(cancelBtnArabic);
        } else {
            utilities.click(cancelBtn);
        }
    }


    public void invalidUsername_AssertTrue() throws Exception {
        utilities.waitForSeconds(2);
        try {

            String rgbFormat = userName.getCssValue("background-color");
            System.out.println(rgbFormat);
            String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
            System.out.println(hexcolor);
            try {
                Boolean b = commonElements.isElementVisible(userCreationMsg);
                if (b) {
                    Assert.fail();
                } else if (hexcolor.equals("#ffffff")) {

                    Assert.assertTrue(true);
                    System.out.println("passed");
                } else {
                    Assert.fail();
                    System.out.println("failed");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {

        }

    }


    public void isInvalidMailMsgDisplayed() throws Exception {
        try {
            utilities.waitForSeconds(2);
            String rgbFormat = emailId.getCssValue("background-color");
            System.out.println(rgbFormat);
            String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
            System.out.println(hexcolor);
            Boolean b = commonElements.isElementVisible(userCreationMsg);

            if (b) {
                Assert.fail();
            } else if (hexcolor.equals("#ffffff")) {
                Assert.assertTrue(true);
                System.out.println("passed");
            } else if (commonElements.isElementVisible(invalidMailMsg)) {
                Assert.assertTrue(true);
                System.out.println("passed :ok inavlid message present");
            } else {
                Assert.assertFalse(true);
                System.out.println("failed");
            }
        } catch (Exception e) {

        }

    }


    public void invalid_mobileNum_check() throws Exception {
        try {
            utilities.waitForSeconds(2);
            Boolean b = null;
            String rgbFormat = mobileNumber.getCssValue("style");
            System.out.println(rgbFormat);
            String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
            System.out.println(hexcolor);
            if (hexcolor.equals("#ffffff")) {
                try {
                    commonElements.isElementVisible(userCreationMsg);
                    Assert.fail();
                } catch (Exception e) {
                    System.out.println(e);
                }
                Assert.assertTrue(true);
                System.out.println("passed");
            } else {
                Assert.fail();
                System.out.println("failed");
            }
        } catch (Exception e) {

        }

    }

    public void upload_photo() throws Exception {
        String UploadPhoto = "/home/i-exceed.com/sweety.r/Videos/Appzillon/appzillon-web/src/test/resources/DataSet/uploadFiles/sample.java";
        utilities.waitForSeconds(2);
        utilities.sendKeys(uploadPhoto, UploadPhoto);

    }

    public void upload_error_msg() throws Exception {
        utilities.waitForSeconds(2);
        commonElements.isElementVisible(uploadErrorMsg);
        utilities.click(okBtn);
    }

    public void is_applicationName_preDefined_value_present() throws Exception {
        utilities.waitForSeconds(5);
        commonElements.isElementVisible(applicationPredefinedValue);
    }

    public void is_phoneNumber_value_present() throws Exception {
        utilities.waitForSeconds(3);
        commonElements.isElementVisible(mobCodeDefineValue);
    }

    public void is_roleID_value_present(String appLanguage) throws Exception {
        utilities.waitForSeconds(7);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            commonElements.isElementVisible(roleDDArabic);
        } else {
            commonElements.isElementVisible(roleIDdefinedValue);
        }
    }

    public void clickOk() throws Exception {
        utilities.waitForSeconds(4);
        try {
            utilities.click(okBtn);
        } catch (Exception e) {

        }
    }

    public void search_criteria_check(String mailID) throws Exception {
        commonElements.isElementVisible(UserMngMntEmailID);
        utilities.sendKeys(UserMngMntEmailID,mailID);
        utilities.click(searchBtn);
    }

}
