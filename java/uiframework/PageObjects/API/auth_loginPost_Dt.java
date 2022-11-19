package uiframework.PageObjects.API;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userName",
        "password",
})
public class auth_loginPost_Dt {

    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;


    public auth_loginPost_Dt(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;


    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setuserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setpassword(String password) {
        this.password = password;
    }

}



