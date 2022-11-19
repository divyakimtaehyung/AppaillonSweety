package com.iexceed.uiframework.steps.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.BankFacing.Android.A_DashboardPage;
import uiframework.PageObjects.BankFacing.IOS.I_DashboardPage;
import uiframework.PageObjects.BankFacing.Web.DashboardPage;
import uiframework.PageObjects.BankFacing.Web.WorkFlowMngMntPage;

import static com.iexceed.uiframework.runners.TestRunner.appLanguage;

public class WorkFlowMngMntActions extends TestBase {
    private static Logger LOGGER = LogManager.getLogger(WorkFlowMngMntActions.class);

    public static String AppPlatForm;
    A_DashboardPage androidDashboardPage;
    I_DashboardPage iosDashboardPage;
    WorkFlowMngMntPage workFlowMngMntPage;


    public WorkFlowMngMntActions(String appplatform) {
        AppPlatForm = appplatform;
        if (appplatform.equalsIgnoreCase("ios")) {
            iosDashboardPage = new I_DashboardPage();
        } else if (appplatform.equalsIgnoreCase("android")) {
            androidDashboardPage = new A_DashboardPage();
        } else {
            workFlowMngMntPage=new WorkFlowMngMntPage();
        }
    }

    public void is_workflow_managementScreen_displayed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.is_workFlow_mngment_Screen();
        }
    }
    public void click_add_button() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.click_add_button();
        }
    }
    public void workFlow_initiate_Screen_dispalyed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.is_workFlow_initiate_screen_displayed();
        }
    }
    public void enerWorkFlowDetails(String type,String workflow) throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.set_corporateType(type);
            workFlowMngMntPage.set_description();
            workFlowMngMntPage.set_workflow_type(workflow);
        }
    }
    public void click_save_Btn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.clickSaveBtn();
        }
    }
    public void click_confirmBtn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {


        } else {
            workFlowMngMntPage.click_confirmBtn();
        }
    }


}
