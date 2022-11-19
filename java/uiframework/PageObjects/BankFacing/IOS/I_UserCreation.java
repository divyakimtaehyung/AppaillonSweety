package uiframework.PageObjects.BankFacing.IOS;
import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uiframework.DomainObjects.Utility;
import java.util.List;

public class I_UserCreation extends TestBase {

    WebDriver driver = TestBase.getDriver();
    @FindBy(id = "bfpusr__UserMgtCreation__UserName")
    WebElement userName;
    @FindBy(id = "bfpusr__UserMgtCreation__UserEmailId")
    WebElement emailId;
    @FindBy(id = "bfpusr__UserMgtCreation__CountryPhoneNumber")
    WebElement mobileNumber;
    @FindBy(xpath = "//span[@id='select2-bfpusr__UserMgtCreation__CountryCodes-container']")
    WebElement mobCodeDD;
    @FindBy(xpath = "//ul[@id='select2-bfpusr__UserMgtCreation__CountryCodes-results']/li")
    List<WebElement> mobileCode;
    @FindBy(xpath = "//*[text()='Bank admin Initiator']")
    WebElement roleDD;
    @FindBy(xpath = "//ul[@id='select2-bfpusr__roleIdMap__i__RoleNode__RoleId_0-results']/li")
    List<WebElement> roleID;
    //      @FindBy(xpath = "//[@id='select2-bfpusr__roleIdMap__i__RoleNode__RoleId_0-results']")
//       WebElement roleID;
//
    @FindBy(xpath = "//*[@id='bfpusr__UserMgtCreation__el_btn_14']")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@text='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//*[@text='حفظ']")
    WebElement saveBtnArabic;
    @FindBy(xpath = "//*[@id='bfpusr__UserMgtCreation__el_btn_13']")
    WebElement cancelBtn;
    @FindBy(xpath = "//*[@id='bfpusr__UserMgtVerify__el_btn_4']")
    WebElement confirmBtn;
    //    @FindBy(id = "bfpusr__UserCreation__el_btn_13")
//    WebElement cancelBtn;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//*[text()='نعم']")
    WebElement okBtnArabic;
    @FindBy(xpath = "//ol[@id='bfpusr__UserMgtLanding__successHeader']//li[contains(@class,'active')]")
    WebElement userSucessMg;
    @FindBy(xpath = "//ol[@id='bfpusr__UserMgtLanding__successHeader']//li[contains(@class,'active')]")
    WebElement userSucessMgArabic;
    @FindBy(xpath = "//p[contains(text(),'Invalid Email ID')]")
    WebElement invalidMailMsg;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement OKTextBtn;
    @FindBy(xpath = "//p[contains(text(),'User Created successfully.')]")
    WebElement userCreationMsg;
    @FindBy(xpath = "//input[@id='bfpusr__UserMgtCreation__browse']")
    WebElement uploadPhoto;
    @FindBy(xpath = "//p[contains(text(),'Unsupported file format.')]")
    WebElement uploadErrorMsg;
    @FindBy(xpath = "//*[text()='Bank Facing Application']")
    WebElement applicationPredefinedValue;
    @FindBy(xpath = "//*[text()='+376']")
    WebElement mobCodeDefineValue;
    @FindBy(xpath = "//*[text()='Bank admin Initiator']")
    WebElement roleIDdefinedValue;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okayBtn;
    @FindBy(id = "bfpusr__UserMgtSummary__createUserBtn_txtcnt")
    WebElement createNewUSer;
    WebElement UserMngMntEmailID;
    @FindBy(id = "bfpusr__UserMgtSummary__SearchBtn_txtcnt")
    WebElement searchBtn;
    @FindBy(id = "td_bfpusr__GetUserList__i__userDetails__userId_0")
    WebElement searchRecord0;
    @FindBy(id = "bfpusr__UserMgtView__status")
    WebElement userDetail_authorized_Status;
    @FindBy(id = "bfpusr__UserMgtSummary__userMgtSummaryTable_table")
    WebElement userSummary_table;


    Utility utils = new Utility();
    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private Utility utility;

    private static Logger LOGGER = LogManager.getLogger(I_UserCreation.class);

    public I_UserCreation() {
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

    public void clickOKBtn() {
        try {
            utility.click(okBtn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enterUsername(String username) throws Exception {
        clickOKBtn();
        utility.waitForSeconds(3);
        utility.sendKeys(userName, username);
    }

    public void enterEmail(String email) throws Exception {
        utility.waitForSeconds(1);
        utility.sendKeys(emailId, email);
    }

    public void selectMobCode(String mobCode) throws Exception {
        utility.click(mobCodeDD);
        String mcode = "+" + mobCode;
        utility.selectFromDropDown(mobileCode, mcode);
    }

    public void enterMobileNumber(String mobileNum) throws Exception {
        utility.sendKeys(mobileNumber, mobileNum);
    }

    public void selectRole(String role) throws Exception {
        try {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        } catch (Exception e) {
            System.out.println(e);
        }
        utility.click(roleDD);
        utility.selectFromDropDown(roleID, role);
    }

    public void clickSaveBtn() throws Exception {
        utility.waitForSeconds(3);
        utility.click(submitBtn);
    }

    public void clickConfirm_Btn(String appLanguage) throws Exception {
        if (appLanguage.equalsIgnoreCase("arabic")) {
            try {
                utility.click(saveBtnArabic);
            } catch (Exception e) {

            }
        } else {
            try {
                utility.click(saveBtn);
            } catch (Exception e) {

            }
        }
        utility.waitForSeconds(3);
        utility.click(confirmBtn);
    }

    public void clickOkBtn() throws Exception {
        utility.waitForSeconds(10);
        utility.click(okBtn);
    }

    public void isUserCreationMsgPresent(String appLanguage) throws Exception {
        utility.waitForSeconds(10);
        if (appLanguage.equalsIgnoreCase("arabic")) {
            commonElements.isElementVisible(userSucessMgArabic);
            utility.waitForSeconds(5);
            utility.click(okBtnArabic);
        } else {
            commonElements.isElementVisible(userSucessMg);
            utility.click(okBtn);
        }
    }


    public void clickCancel() throws Exception {
        utility.waitForSeconds(3);
        utility.click(cancelBtn);
    }


    public void invalidUsername_AssertTrue() throws Exception {
        utility.waitForSeconds(2);
        String rgbFormat = commonElements.getCssValue(userName, "background-color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexcolor);
        try {
            Boolean b = utility.waitForElement(userCreationMsg);
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

    }


    public void isInvalidMailMsgDisplayed() throws Exception {
        utility.waitForSeconds(2);
        String rgbFormat = commonElements.getCssValue(emailId, "background-color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexcolor);
        Boolean b = utility.waitForElement(userCreationMsg);
        if (b) {
            Assert.fail();
        } else if (hexcolor.equals("#ffffff")) {
            Assert.assertTrue(true);
            System.out.println("passed");
        } else if (utility.waitForElement(invalidMailMsg)) {
            Assert.assertTrue(true);
            System.out.println("passed :ok inavlid message present");
        } else {
            Assert.assertFalse(true);
            System.out.println("failed");
        }

    }


    public void invalid_mobileNum_check() throws Exception {
        utility.waitForSeconds(2);
        String rgbFormat = commonElements.getCssValue(mobileNumber, "background-color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexcolor);

        if (hexcolor.equals("#ffffff")) {
            try {
                utility.waitForElement(userCreationMsg);
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

    }

    public void upload_photo() throws Exception {
        String UploadPhoto = "/home/i-exceed.com/sweety.r/Videos/Appzillon/appzillon-web/src/test/resources/DataSet/uploadFiles/sample.java";
        utility.waitForSeconds(2);
        utility.sendKeys(uploadPhoto, UploadPhoto);

    }


    public void upload_error_msg() throws Exception {
        utility.waitForElement(uploadErrorMsg);
        utility.click(okBtn);
    }

    public void is_applicationName_preDefined_value_present() throws Exception {
        utility.waitForElement(applicationPredefinedValue);
    }

    public void is_phoneNumber_value_present() throws Exception {
        utility.waitForElement(mobCodeDefineValue);
    }

    public void is_roleID_value_present() throws Exception {
        utility.waitForElement(roleIDdefinedValue);
    }

    public void clickOk() throws Exception {
        try {
            utility.click(okayBtn);
        } catch (Exception e) {

        }
    }

    public void create_new_user() throws Exception {
        try {
            utility.click(createNewUSer);
        } catch (Exception e) {

        }
        utility.waitForSeconds(3);
    }

    public void isInvalidMailMsgdisplayed() throws Exception {
    }

    public void search_criteria_check(String mailID) throws Exception {
        commonElements.isElementVisible(UserMngMntEmailID);
        utility.sendKeys(UserMngMntEmailID, mailID);
        utility.click(searchBtn);
    }

    public void is_search_Result_present() throws Exception {
        commonElements.isElementVisible(searchRecord0);
    }

    public void search_criteria_BankApplication() throws Exception {
        commonElements.isElementVisible(UserMngMntEmailID);
        utility.clearText(UserMngMntEmailID);
        utility.click(searchBtn);
    }

    public void click_Authorized_searchRecord() throws Exception {
        utility.click(searchRecord0);
        commonElements.isElementVisible(userDetail_authorized_Status);
        utility.click(OKTextBtn);
    }

    public void check_userSummary_Record_present() throws Exception {
        commonElements.isElementVisible(userSummary_table);
    }

    public void click_unauthorized_Record() throws Exception {
        utility.click(searchRecord0);
        commonElements.isElementVisible(userDetail_authorized_Status);
    }

}

