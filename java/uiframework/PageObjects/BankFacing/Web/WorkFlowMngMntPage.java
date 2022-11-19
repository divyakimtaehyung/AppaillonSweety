package uiframework.PageObjects.BankFacing.Web;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.*;
import com.iexceed.uiframework.utilites.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiframework.DomainObjects.Utility;

import java.util.List;

public class WorkFlowMngMntPage extends TestBase {

    WebDriver driver = TestBase.getDriver();

    @FindBy(id = "bfpapp__MenuList__i__Menu__title_1")
    WebElement workFlowMngMnt;
    @FindBy(id = "bfpwmg__WorkflowMgtLanding__Btn1")
    WebElement workFlowMngMntPage;
    @FindBy(id = "bfpwmg__WorkflowMgtSummary__AddBtn_summary")
    WebElement addButton;
    @FindBy(id = "bfpwmg__WorkflowMgtLanding__ThreeBtn")
    WebElement add_record_page;
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement okBtn;
    @FindBy(id = "bfpwmg__WorkflowMgtAddition__save")
    WebElement saveBtn;
    @FindBy(id = "bfpwmg__WorkflowMgtAddition__cancel")
    WebElement cancelBtn;
    @FindBy(xpath = "//input[@id='bfpwmg__WorkflowMgtAddition__ProductCode']")
    WebElement corporateTypeDD;
    @FindBy(xpath = "//*[@id='bfpwmg__WorkflowMgtAddition__ProductCode_div']/ul/li")
    List<WebElement> corporateTypeList;
    @FindBy(id = "bfpwmg__WorkflowMgtAddition__Description")
    WebElement description;
    @FindBy(id = "bfpwmg__WorkflowMgtAddition__Workflow")
    WebElement workFlowTypeDD;
    @FindBy(xpath = "//*[@id='bfpwmg__WorkflowMgtAddition__Workflow_div']/ul/li")
    List<WebElement> workFlowTypeList;
    @FindBy(id = "bfpwmg__WorkflowMgtVerify__el_btn_4")
    WebElement confirmBtn;
    @FindBy(id = "bfpwmg__WorkflowMgtAddition__cancel")
    WebElement otpBox;

    private CommonElements commonElements;
    private CommonDriver commonDriver;
    private TextBoxControls textBoxControls;
    private WaitUtility waitUtility;
    private WindowHandling windowHandling;
    private ScreenshotControl screenshotControl;
    private JavaScriptControls javaScriptControls;
    private Utility utility;


    public WorkFlowMngMntPage() {
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

    public void is_workFlow_mngment_Screen() throws Exception {
        utility.waitForElement(workFlowMngMntPage);
        commonElements.isElementVisible(workFlowMngMntPage);
    }

    public void click_add_button() throws Exception {
        utility.click(addButton);
    }

    public void is_workFlow_initiate_screen_displayed() throws Exception {
        commonElements.isElementVisible(add_record_page);
    }

    public void set_corporateType(String type) throws Exception {
        utility.click(corporateTypeDD);
        utility.selectFromDropDown(corporateTypeList, type);
    }

    public void set_description() throws Exception {
        utility.sendKeys(description, "description");
    }

    public void set_workflow_type(String workflow) throws Exception {
        utility.click(workFlowTypeDD);
        utility.selectFromDropDown(workFlowTypeList, workflow);
    }

    public void clickSaveBtn() throws Exception {
      utility.click(saveBtn);
    }
    public void click_confirmBtn() throws Exception {
        utility.waitForSeconds(3);
        utility.click(confirmBtn);
    }

}
