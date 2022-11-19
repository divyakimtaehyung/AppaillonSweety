package com.iexceed.uiframework.steps.API;

import com.iexceed.uiframework.rest.RestAssuredWrapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uiframework.PageObjects.API.*;

import java.util.HashMap;
import java.util.Map;

public class userAuthenticationActions {

    private static Logger LOGGER = LogManager.getLogger(userAuthenticationActions.class);
    public static Response response;
    public static Map<String, String> hmap;
    public static Map<String, String> Qmap;
    public static Map<String, String> Pmap;

    public void setEndpoint(String baseURI, String endPoint) {
        RestAssuredWrapper.setBaseURI(baseURI, endPoint);
    }

    public void setHeaders(String acceptLang, String tenentId, String OsType) {
        hmap = new HashMap<String, String>();
        hmap.put("Accept-Language", acceptLang);
        hmap.put("accept", tenentId);
        hmap.put("X-REQUEST-ID", OsType);
    }

    public void set_logout_header(String accept_language, String accessToken, String refresh_token, String x_tenentId) {
        hmap = new HashMap<String, String>();
        hmap.put("Accept-Language", accept_language);
        hmap.put("Authorization", accessToken);
        hmap.put("refresh_token", refresh_token);
        hmap.put("X-TENANT-ID", x_tenentId);
    }

    public void set_refresh_Header(String refreshToken,String acceptLanguage,String x_tenent){
        hmap=new HashMap<String,String>();
        hmap.put("refresh_token",refreshToken);
        hmap.put("Accept-Language", acceptLanguage);
        hmap.put("X-TENANT-ID",x_tenent);
    }

    public void setPathParams() {
        Pmap = new HashMap<String, String>();
//        Pmap.put("Accept-Language", acceptLang);
//        Pmap.put("accept", tenentId);
//        Pmap.put("X-REQUEST-ID", OsType);

    }

    public void OTP_setHeaders(String accessToken, String acceptLang, String tenentId) {
        hmap = new HashMap<String, String>();
        hmap.put("accessToken", accessToken);
        hmap.put("Accept-Language", acceptLang);
        hmap.put("accept", tenentId);

    }

    public void Post_OTPGenerate(String path, String userName, String password, String mobileNumber, String appType) {
        OTP_GeneratePost_Dt otp_generatePost_dt = new OTP_GeneratePost_Dt(userName, password, mobileNumber, appType);
        response = RestAssuredWrapper.postRequestWithJsonContentType(path, otp_generatePost_dt, hmap);
    }

    public void put_OTPresent(String path, String userID, int refNo) {
        OTP_ResentPUT_Dt otp_resentPUT_dt = new OTP_ResentPUT_Dt(userID, refNo);
        response = RestAssuredWrapper.putRequestWithObjPathParamAndHeaders(path, otp_resentPUT_dt, hmap, Pmap);
    }

    public void put_validateOtpRequest(String path, String userId, String otp, int refNo, String requestId, String appType) {
        OTP_ValidatePUT_Dt otp_validatePUT_dt = new OTP_ValidatePUT_Dt(userId, otp, refNo, requestId, appType);
        response = RestAssuredWrapper.putRequestWithObjPathParamAndHeaders(path, otp_validatePUT_dt, hmap, Pmap);
    }

    public void Post_userAuthentication_Login(String path, String userName, String password) {
        auth_loginPost_Dt auth_loginPost_dt = new auth_loginPost_Dt(userName, password);
        response = RestAssuredWrapper.postRequestWithJsonContentType(path, auth_loginPost_dt, hmap);
    }


    public void Post_Refesh_token(String path){
        response = RestAssuredWrapper.postRequestWithJsonContentType(path);
    }
    public void post_user_logout(String path) {
        response = RestAssuredWrapper.postRequestWithJsonContentType(path);
    }

    public void getStatusCode(int expectedResponseCode) {
        RestAssuredWrapper.StatusCodeTest(response, expectedResponseCode);
    }


}
