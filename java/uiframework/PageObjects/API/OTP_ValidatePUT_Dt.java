package uiframework.PageObjects.API;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "otp",
        "refNo",
        "requestId",
        "appType",

})
public class OTP_ValidatePUT_Dt {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("otp")
    private String otp;
    @JsonProperty("refNo")
    private int refNo;
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("appType")
    private String appType;


    public OTP_ValidatePUT_Dt(String userId, String otp, int refNo, String requestId,String appType) {
        super();
        this.userId = userId;
        this.otp = otp;
        this.refNo = refNo;
        this.requestId = requestId;
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

    @JsonProperty("otp")
    public String getOtp() {
        return otp;
    }
    @JsonProperty("otp")
    public void setotp(String otp) {
        this.otp = otp;
    }

    @JsonProperty("refNo")
    public int getrefNo() {
        return refNo;
    }
    @JsonProperty("refNo")
    public void setrefNo(int refNo) {
        this.refNo = refNo;
    }

    @JsonProperty("requestId")
    public String getrequestId() {
        return requestId;
    }
    @JsonProperty("requestId")
    public void setrequestId(String requestId) {
        this.requestId = requestId;
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



