package com.iexceed.uiframework.steps.API;

import com.iexceed.uiframework.rest.RestAssuredWrapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.API.workFlowPostDt;
import uiframework.PageObjects.API.workFlowPutDt;

import java.util.*;

public class workFlowActions {

    private static Logger LOGGER = LogManager.getLogger(workFlowActions.class);
    public static Response response;
    public static Map<String, String> hmap;
    public static Map<String, String> Qmap;
    public static Map<String, String> Pmap;

    public void setEndpoint(String baseURI, String endPoint) {
        RestAssuredWrapper.setBaseURI(baseURI, endPoint);
    }

    public void setHeaders(String acceptLang, String accepLan, String requestId, String contentType) {
        hmap = new HashMap<String, String>();
        hmap.put("Accept-Language", acceptLang);
        hmap.put("accept", accepLan);
        hmap.put("X-REQUEST-ID", requestId);
        hmap.put("Content-Type", contentType);

    }

    public void setHeaders_GETAPICALL(String acceptLang, String accepLan, String requestId) {
        hmap = new HashMap<String, String>();
        hmap.put("Accept-Language", acceptLang);
        hmap.put("accept", accepLan);
        hmap.put("X-REQUEST-ID", requestId);
    }

    public void setQueryParams(String id, String tenent) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
    }

    public void set_Description_QueryParams(String id, String tenent, String Description) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("description", Description);
    }

    public void set_Status_QueryParams(String id, String tenent, String status) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("status", status);
    }

    public void set_initiateDate_QueryParams(String id, String tenent, String date) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("initiationDt", date);
    }

    public void set_AuthDate_QueryParams(String id, String tenent, String date) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("authorizationDt", date);
    }

    public void set_AuthToDate_QueryParams(String id, String tenent, String date) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("authorizationTs", date);
    }

    public void set_AuthinitiateDate_AuthteToDate_QueryParams(String id, String tenent, String date, String inititeToDate) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("initiationDt", date);
        Qmap.put("initiationTs", inititeToDate);
    }

    public void set_initiateDate_initiateToDate_QueryParams(String id, String tenent, String date, String inititeToDate) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("initiationDt", date);
        Qmap.put("initiationTs", inititeToDate);
    }

    public void set_DELETE_QueryParams(String id, String tenent, String actionBy, int version, String remarks) {
        Qmap = new HashMap<String, String>();
        Qmap.put("id", id);
        Qmap.put("tenant", tenent);
        Qmap.put("actionBy", actionBy);
        Qmap.put("version", String.valueOf(version));
        Qmap.put("remarks", remarks);

    }

    public void setPathParams(String id, String tenent) {
        Pmap = new HashMap<String, String>();
//        Pmap.put("id", id);
//        Pmap.put("tenant", tenent);
    }

    public void Post_createNewWorkFlow(String path, String corporateType, Integer id, String description, String workflowKey, String tenant, String actionBy) {
        workFlowPostDt workFlowPostDt = new workFlowPostDt(corporateType, id, description, workflowKey, tenant, actionBy);
        response = RestAssuredWrapper.postRequestWithJsonContentType(path, workFlowPostDt, hmap);
    }

    public void Put_updateWorkFlow(String baseuri, String endpoint, String path, String description, String workflowKey, String action, String actionBy,
                                   Integer version, String remarks, String id, String tenent) {
        String Requestpath = baseuri + endpoint + path + "/" + id + "/tenants/" + tenent;
        workFlowPutDt workFlowPutDt = new workFlowPutDt(description, workflowKey, action, actionBy, version, remarks);
      //  response = RestAssuredWrapper.putRequestWithObjPathParamAndHeaders(Requestpath, workFlowPutDt, hmap, Pmap);
    }

    public void getStatusCode(int expectedResponseCode) {
        RestAssuredWrapper.StatusCodeTest(response, expectedResponseCode);
    }

    public void get_workflowDetails(String baseURI, String endURL, String path, int id, String tenent) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
    }

    public void get_workflowDetails_withDesc(String baseURI, String endURL, String path, int id, String tenent, String description) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&description=" + description;
//        https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T003&description=Mention%20the%20description
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
    }

    public void get_workflowDetails_withStatus(String baseURI, String endURL, String path, int id, String tenent, String status) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&status=" + status;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
    }

    public void get_workflowDetails_withInitaiteDate_InitiateToDate(String baseURI, String endURL, String path, int id, String tenent, String date, String TODate) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&initFromDt=" + date + "initToDt=" + TODate;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
        //https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T001&initFromDt=2022-09-14&initToDt=2022-09-14%2013%3A38%3A56.573%20%2B0530
    }


    public void get_workflowDetails_withInitaiteDate(String baseURI, String endURL, String path, int id, String tenent, String date) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&initFromDt=" + date;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
        //https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T001&initFromDt=2022-09-14
    }

    public void get_workflowDetails_withAuthDate(String baseURI, String endURL, String path, int id, String tenent, String date) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&authFromDt=" + date;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
        //https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T001&initFromDt=2022-09-14
    }

    public void get_workflowDetails_withAuthToDate(String baseURI, String endURL, String path, int id, String tenent, String date) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&authToDt=" + date;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
        //https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T001&initFromDt=2022-09-14
    }

    public void get_workflowDetails_AuthInitiate_withAuthToDate(String baseURI, String endURL, String path, int id, String tenent, String date, String date1) {
        String getRequestPath = baseURI + endURL + path + "?id=" + id + "&tenant=" + tenent + "&authFromDt=" + date + "&authToDt=" + date1;
        response = RestAssuredWrapper.getRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
        //https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflows?id=1002&tenant=T001&initFromDt=2022-09-14
    }

    public void delete_workflow(String baseURI, String endURL, String path, int id, String tenent, String actionBy
            , int version, String remarks) {
        String tempMail[] = actionBy.split("@");
        String tempmail = tempMail[0] + "%40" + tempMail[1];
        String getRequestPath = baseURI + endURL + path + "/auth?tenant=" + tenent + "&id=" + id + "&actionBy=" + tempmail + "&version=" + version + "&remarks=" + remarks;
//        https://autoworkflowmanagement.apzplatforms.com/workflow-management/v1/corporate-onboard/workflow/auth?tenant=T003&id=1002&actionBy=kdivya%40mail.com&version=3&remarks=remarks
        RestAssuredWrapper.deleteRequestWithQueryParamAndHeaders(getRequestPath, hmap, Qmap);
    }

    public void getResponse() {
        System.out.println(response);
    }

}
