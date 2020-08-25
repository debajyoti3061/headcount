package com.mathworks.headcount.api.response.supervisoryorg;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "managerId",
    "parentSupervisoryOrgId",
    "managerType",
    "managerName",
    "planData"
})
public class SupervisoryOrg {

  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("managerId")
  private Integer managerId;
  @JsonProperty("parentSupervisoryOrgId")
  private String parentSupervisoryOrgId;
  @JsonProperty("managerType")
  private String managerType;
  @JsonProperty("managerName")
  private String managerName;
  @JsonProperty("planData")
  private Boolean planData;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("managerId")
  public Integer getManagerId() {
    return managerId;
  }

  @JsonProperty("managerId")
  public void setManagerId(Integer managerId) {
    this.managerId = managerId;
  }

  @JsonProperty("parentSupervisoryOrgId")
  public String getParentSupervisoryOrgId() {
    return parentSupervisoryOrgId;
  }

  @JsonProperty("parentSupervisoryOrgId")
  public void setParentSupervisoryOrgId(String parentSupervisoryOrgId) {
    this.parentSupervisoryOrgId = parentSupervisoryOrgId;
  }

  @JsonProperty("managerType")
  public String getManagerType() {
    return managerType;
  }

  @JsonProperty("managerType")
  public void setManagerType(String managerType) {
    this.managerType = managerType;
  }

  @JsonProperty("managerName")
  public String getManagerName() {
    return managerName;
  }

  @JsonProperty("managerName")
  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  @JsonProperty("planData")
  public Boolean getPlanData() {
    return planData;
  }

  @JsonProperty("planData")
  public void setPlanData(Boolean planData) {
    this.planData = planData;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
