package com.iexceed.uiframework.steps.BankFacing;

import com.iexceed.uiframework.core.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.BankFacing.Android.A_DashboardPage;
import uiframework.PageObjects.BankFacing.IOS.I_DashboardPage;
import uiframework.PageObjects.BankFacing.Web.DashboardPage;


import static com.iexceed.uiframework.runners.TestRunner.appLanguage;

public class DashboardActions extends TestBase {
    private static Logger LOGGER = LogManager.getLogger(DashboardActions.class);
    DashboardPage dashboardPage;
    public static String AppPlatForm;
    A_DashboardPage androidDashboardPage;
    I_DashboardPage iosDashboardPage;


    public DashboardActions(String appplatform) {
        AppPlatForm = appplatform;
        if (appplatform.equalsIgnoreCase("ios")) {
            iosDashboardPage = new I_DashboardPage();
        } else if (appplatform.equalsIgnoreCase("android")) {
            androidDashboardPage = new A_DashboardPage();
        } else {
            dashboardPage = new DashboardPage();
        }
    }

    public void navigateUserMngMntPage() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.naviagteUserManageMentPage();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.naviagteUserManageMentPage();
        } else {
            dashboardPage.naviagteUserManageMentPage();
        }
    }

    public void navigateWorkFlow() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {

        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {

        } else {
            dashboardPage.clickWorkFlow();
        }
    }

    public void isUserDetailsPage() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.isUserMngMentVisible();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.isUserMngMentVisible();

        } else {
            dashboardPage.isUserMngMentVisible();
        }

    }


    public void logout_icon_validations() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.click_logout_icon();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.click_logout_icon();

        } else {
            dashboardPage.click_logout_icon();
        }
    }

    public void is_logoutMsg_displayed() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.is_logout_msg_displayed();
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.is_logout_msg_displayed();
        } else {
            dashboardPage.is_logout_msg_displayed();
        }

    }

    public void click_ok_btn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.click_ok_btn(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.click_ok_btn();
        } else {
            dashboardPage.click_ok_btn();
        }

    }

    public void click_cancel_btn() throws Exception {
        if (AppPlatForm.equalsIgnoreCase("Android")) {
            androidDashboardPage.click_cancel_btn(appLanguage);
        } else if (AppPlatForm.equalsIgnoreCase("IOS")) {
            iosDashboardPage.click_cancel_btn();

        } else {
            dashboardPage.click_cancel_btn();
        }

    }


}
