package uiframework.PageObjects.API;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.sl.In;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "description",
        "workflowKey",
        "action",
        "actionBy",
        "version",
        "remarks",

})


public class workFlowPutDt {

    @JsonProperty("description")
    private String description;
    @JsonProperty("workflowKey")
    private String workflowKey;
    @JsonProperty("action")
    private String action;
    @JsonProperty("actionBy")
    private String actionBy;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("remarks")
    private String remarks;

    public workFlowPutDt(String description, String  workflowKey, String action, String actionBy, Integer version, String remarks) {
        super();
        this.description = description;
        this.workflowKey = workflowKey;
        this.action = action;
        this.actionBy = actionBy;
        this.version = version;
        this.remarks = remarks;

    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("workflowKey")
    public String getWorkflowKey() {
        return workflowKey;
    }

    @JsonProperty("workflowKey")
    public void setWorkflowKey(String workflowKey) {
        this.workflowKey = workflowKey;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("actionBy")
    public String getActionBy() {
        return actionBy;
    }

    @JsonProperty("actionBy")
    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(int version) {
        this.version = version;
    }

    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }

    @JsonProperty("remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
