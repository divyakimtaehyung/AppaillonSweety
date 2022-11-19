package uiframework.PageObjects.BankFacing.IOS;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiframework.DomainObjects.Utility;

import java.util.List;

public class I_DashboardPage extends TestBase {

    WebDriver driver = TestBase.getDriver();

    @FindBy(id = "btn_icon_icon-hamburger-collapse")
    WebElement menuBtn;
    @FindBy(id = "bfpapp__MenuList__i__Menu__title_0")
    WebElement userMngMnt;
    @FindBy(id = "bfpusr__UserMgtSummary__createUserBtn_txtcnt")
    WebElement createUserBtn;
    @FindBy(id = "bfpusr__UserCreation__el_txt_1_txtcnt")
    WebElement userDetailsScreen;
    @FindBy(xpath = "//*[@id='bfpapp__BasePage__mainMenu']")
    WebElement menuIocn;
    @FindBy(xpath = "//*[@id='btn_icon_icon-logout']")
    WebElement logoutIcon;
    @FindBy(xpath = "//p[contains(text(),'Are you sure you want to logout ?')]")
    WebElement logoutPopup;
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement okBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement cancelBtn;


    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private Utility utility;


    public I_DashboardPage() {
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

    public void naviagteUserManageMentPage() throws Exception {
        utility.waitForElement(menuBtn);
        utility.click(menuBtn);
        utility.waitForSeconds(15);
        utility.click(userMngMnt);
        utility.waitForElement(createUserBtn);
        utility.click(createUserBtn);

    }

    public void isUserMngMentVisible() throws Exception {
        utility.waitForSeconds(3);
        commonElements.isElementVisible(menuBtn);
    }

    public void click_logout_icon() throws Exception {
        utility.waitForElement(logoutIcon);
        utility.click(logoutIcon);

    }

    public void is_logout_msg_displayed() throws Exception {
        utility.waitForElement(logoutIcon);
    }

    public void click_ok_btn() throws Exception {
        utility.click(okBtn);
    }

    public void click_cancel_btn() throws Exception {
        utility.click(cancelBtn);
    }
}
