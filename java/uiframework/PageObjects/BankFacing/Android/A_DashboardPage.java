package uiframework.PageObjects.BankFacing.Android;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiframework.MobileUtility.AndroidUtility;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class A_DashboardPage extends TestBase {


    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpapp__BasePage__mainMenu']")
    WebElement menuBtn;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='bfpapp__MenuList__i__Menu__title_0_txtcnt']")
    WebElement userMngMnt;
    @FindBy(id = "bfpusr__UserCreation__el_txt_1_txtcnt")
    WebElement userDetailsScreen;
    @FindBy(xpath = "//android.widget.Button[@resource-id='bfpapp__BasePage__logout']")
    WebElement logoutIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Are you sure you want to logout ?']\"")
    WebElement logoutPopup;
    @FindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//android.widget.Button[@text='Cancel']")
    WebElement cancelBtn;
    @FindBy(xpath = "//android.widget.Button[@text='يلغي']")
    WebElement cancelBtnArabic;
    @FindBy(xpath = "//android.widget.Button[@text='نعم']")
    WebElement okBtnArabic;

    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private AndroidUtility utilities;

    public A_DashboardPage() {
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

    public void naviagteUserManageMentPage() throws Exception {
        utilities.waitForSeconds(10);
        utilities.click(menuBtn);
        utilities.waitForSeconds(1);
        utilities.click(userMngMnt);
    }

    public void isUserMngMentVisible() throws Exception {
        utilities.waitForSeconds(3);
        try {
            commonElements.isElementVisible(menuBtn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void click_logout_icon() throws Exception {
        utilities.waitForSeconds(1);
        utilities.click(logoutIcon);

    }

    public void is_logout_msg_displayed() throws Exception {
        commonElements.isElementVisible(logoutIcon);
    }

    public void click_ok_btn(String appLanguage) throws Exception {
        if(appLanguage.equalsIgnoreCase("arabic")){
            utilities.click(okBtnArabic);
        }else {
            utilities.click(okBtn);
        }

    }

    public void click_cancel_btn(String appLanguage) throws Exception {
        if(appLanguage.equalsIgnoreCase("arabic")){
            utilities.click(cancelBtnArabic);
        }else {
            utilities.click(cancelBtn);
        }
    }


}
