package uiframework.PageObjects.API;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "emailId",
        "mobileNumber",
        "appType",

})
public class OTP_GeneratePost_Dt {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("mobileNumber")
    private String mobileNumber;
    @JsonProperty("appType")
    private String appType;


    public OTP_GeneratePost_Dt(String userId, String emailId, String mobileNumber, String appType) {
        super();
        this.userId = userId;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.appType = appType;
    }

    @JsonProperty("userId")
    public String getuserId() {
        return userId;
    }
    @JsonProperty("userId")
    public void setuserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("emailId")
    public String getemailId() {
        return emailId;
    }
    @JsonProperty("emailId")
    public void setemailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("mobileNumber")
    public String getmobileNumber() {
        return mobileNumber;
    }
    @JsonProperty("emailId")
    public void setmobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @JsonProperty("appType")
    public String getappType() {
        return appType;
    }
    @JsonProperty("appType")
    public void setappType(String appType) {
        this.appType = appType;
    }



}



