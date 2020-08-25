
package com.mathworks.headcount.api.response.addproposed;

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
    "mgrCurrent",
    "jobCodeCurrent",
    "deptIdCurrent",
    "deptNameCurrent",
    "locationIdCurrent",
    "locationNameCurrent",
    "supervisoryOrgIdCurrent",
    "supervisoryOrgNameCurrent",
    "reportsToIdCurrent",
    "reportsToTypeCurrent",
    "reportsToNameCurrent"
})
public class HeadcountCurrentFieldsModel {

    @JsonProperty("mgrCurrent")
    private Object mgrCurrent;
    @JsonProperty("jobCodeCurrent")
    private Object jobCodeCurrent;
    @JsonProperty("deptIdCurrent")
    private Object deptIdCurrent;
    @JsonProperty("deptNameCurrent")
    private Object deptNameCurrent;
    @JsonProperty("locationIdCurrent")
    private Object locationIdCurrent;
    @JsonProperty("locationNameCurrent")
    private Object locationNameCurrent;
    @JsonProperty("supervisoryOrgIdCurrent")
    private Object supervisoryOrgIdCurrent;
    @JsonProperty("supervisoryOrgNameCurrent")
    private Object supervisoryOrgNameCurrent;
    @JsonProperty("reportsToIdCurrent")
    private Object reportsToIdCurrent;
    @JsonProperty("reportsToTypeCurrent")
    private Object reportsToTypeCurrent;
    @JsonProperty("reportsToNameCurrent")
    private Object reportsToNameCurrent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("mgrCurrent")
    public Object getMgrCurrent() {
        return mgrCurrent;
    }

    @JsonProperty("mgrCurrent")
    public void setMgrCurrent(Object mgrCurrent) {
        this.mgrCurrent = mgrCurrent;
    }

    @JsonProperty("jobCodeCurrent")
    public Object getJobCodeCurrent() {
        return jobCodeCurrent;
    }

    @JsonProperty("jobCodeCurrent")
    public void setJobCodeCurrent(Object jobCodeCurrent) {
        this.jobCodeCurrent = jobCodeCurrent;
    }

    @JsonProperty("deptIdCurrent")
    public Object getDeptIdCurrent() {
        return deptIdCurrent;
    }

    @JsonProperty("deptIdCurrent")
    public void setDeptIdCurrent(Object deptIdCurrent) {
        this.deptIdCurrent = deptIdCurrent;
    }

    @JsonProperty("deptNameCurrent")
    public Object getDeptNameCurrent() {
        return deptNameCurrent;
    }

    @JsonProperty("deptNameCurrent")
    public void setDeptNameCurrent(Object deptNameCurrent) {
        this.deptNameCurrent = deptNameCurrent;
    }

    @JsonProperty("locationIdCurrent")
    public Object getLocationIdCurrent() {
        return locationIdCurrent;
    }

    @JsonProperty("locationIdCurrent")
    public void setLocationIdCurrent(Object locationIdCurrent) {
        this.locationIdCurrent = locationIdCurrent;
    }

    @JsonProperty("locationNameCurrent")
    public Object getLocationNameCurrent() {
        return locationNameCurrent;
    }

    @JsonProperty("locationNameCurrent")
    public void setLocationNameCurrent(Object locationNameCurrent) {
        this.locationNameCurrent = locationNameCurrent;
    }

    @JsonProperty("supervisoryOrgIdCurrent")
    public Object getSupervisoryOrgIdCurrent() {
        return supervisoryOrgIdCurrent;
    }

    @JsonProperty("supervisoryOrgIdCurrent")
    public void setSupervisoryOrgIdCurrent(Object supervisoryOrgIdCurrent) {
        this.supervisoryOrgIdCurrent = supervisoryOrgIdCurrent;
    }

    @JsonProperty("supervisoryOrgNameCurrent")
    public Object getSupervisoryOrgNameCurrent() {
        return supervisoryOrgNameCurrent;
    }

    @JsonProperty("supervisoryOrgNameCurrent")
    public void setSupervisoryOrgNameCurrent(Object supervisoryOrgNameCurrent) {
        this.supervisoryOrgNameCurrent = supervisoryOrgNameCurrent;
    }

    @JsonProperty("reportsToIdCurrent")
    public Object getReportsToIdCurrent() {
        return reportsToIdCurrent;
    }

    @JsonProperty("reportsToIdCurrent")
    public void setReportsToIdCurrent(Object reportsToIdCurrent) {
        this.reportsToIdCurrent = reportsToIdCurrent;
    }

    @JsonProperty("reportsToTypeCurrent")
    public Object getReportsToTypeCurrent() {
        return reportsToTypeCurrent;
    }

    @JsonProperty("reportsToTypeCurrent")
    public void setReportsToTypeCurrent(Object reportsToTypeCurrent) {
        this.reportsToTypeCurrent = reportsToTypeCurrent;
    }

    @JsonProperty("reportsToNameCurrent")
    public Object getReportsToNameCurrent() {
        return reportsToNameCurrent;
    }

    @JsonProperty("reportsToNameCurrent")
    public void setReportsToNameCurrent(Object reportsToNameCurrent) {
        this.reportsToNameCurrent = reportsToNameCurrent;
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
