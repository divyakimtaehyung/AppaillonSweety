package uiframework.PageObjects.CustomerFacing.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiframework.MobileUtility.AndroidUtility;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class A_DashboardObjects {

    @FindBy(xpath = "//*[@resource-id='cfpdhb__Dashboard__el_txt_1']")
    WebElement dashboardTitle;

    private final AndroidUtility utilities;

    public A_DashboardObjects(){
        PageFactory.initElements(appiumDriver,this);
        utilities = new AndroidUtility();
    }

    public void verifyDashboard(){
        utilities.waitForElement(dashboardTitle);
    }
}
