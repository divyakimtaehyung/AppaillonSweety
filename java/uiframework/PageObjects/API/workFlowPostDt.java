package uiframework.PageObjects.API;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "corporateType",
        "id",
        "description",
        "workflowKey",
        "tenant",
        "actionBy",

})


public class workFlowPostDt {

    @JsonProperty("corporateType")
    private String corporateType;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("workflowKey")
    private String workflowKey;
    @JsonProperty("tenant")
    private String tenant;
    @JsonProperty("actionBy")
    private String actionBy;

    public workFlowPostDt(String corporateType, Integer id, String description, String workflowKey, String tenant, String actionBy) {
        super();
        this.corporateType = corporateType;
        this.id = id;
        this.description = description;
        this.workflowKey = workflowKey;
        this.tenant = tenant;
        this.actionBy = actionBy;

    }

    @JsonProperty("corporateType")
    public String getCorporateType() {
        return corporateType;
    }

    @JsonProperty("corporateType")
    public void setCorporateType(String corporateType) {
        this.corporateType = corporateType;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
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

    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    @JsonProperty("tenant")
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @JsonProperty("actionBy")
    public String getActionBy() {
        return actionBy;
    }

    @JsonProperty("actionBy")
    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

}
