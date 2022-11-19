package com.iexceed.uiframework.steps.CustomerFacing;

import uiframework.PageObjects.CustomerFacing.Android.A_DashboardObjects;
import uiframework.PageObjects.CustomerFacing.IOS.I_DashboardObjects;
import uiframework.PageObjects.CustomerFacing.Web.DashboardObjects;

public class DashboardAction {

    private final String platform ;
    DashboardObjects  dashboardObjects;
    A_DashboardObjects aDashboardObjects;
    I_DashboardObjects iDashboardObjects;

    public DashboardAction(String platform){
        this.platform = platform;
        if (platform.equalsIgnoreCase("ios")){
            iDashboardObjects = new I_DashboardObjects();
        }else if (platform.equalsIgnoreCase("android")){
            aDashboardObjects = new A_DashboardObjects();
        }else {
            dashboardObjects = new DashboardObjects();
        }
    }


    public void verifyDashboard() throws Exception {
        if (platform.equalsIgnoreCase("ios")){
            iDashboardObjects.verifyDashboard();
        }else if (platform.equalsIgnoreCase("android")){
            aDashboardObjects.verifyDashboard();
        }else {
            dashboardObjects.verifyDashboard();
        }
    }
}
