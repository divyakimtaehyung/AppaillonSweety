package uiframework.PageObjects.API;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "refNo",

})
public class OTP_ResentPUT_Dt {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("refNo")
    private int refNo;


    public OTP_ResentPUT_Dt(String userId,int refNo) {
        super();
        this.userId = userId;
        this.refNo = refNo;
    }

    @JsonProperty("userId")
    public String getuserId() {
        return userId;
    }
    @JsonProperty("userId")
    public void setuserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("refNo")
    public int getrefNo() {
        return refNo;
    }
    @JsonProperty("refNo")
    public void setrefNo(int refNo) {
        this.refNo = refNo;
    }


}



