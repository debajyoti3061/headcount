
package com.mathworks.headcount.api.response.addproposed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orgNode",
    "orgNodeString",
    "orgLevel",
    "nodeId",
    "name",
    "nameLong",
    "managedSupervisoryOrgId",
    "managedSupervisoryOrgName",
    "type",
    "id",
    "reqType",
    "jobCodeName",
    "reportsTo",
    "supervisoryOrg",
    "department",
    "location",
    "jobCode",
    "jobLevel",
    "status",
    "isManager",
    "regTemp",
    "termDate",
    "reqLatestActivity",
    "reqRecruiter",
    "reqDaysActive",
    "totalReports",
    "directReports",
    "totalReqs",
    "totalAdds",
    "totalVpRequested",
    "totalVpDeferred",
    "totalVpOther",
    "ancestorsPath",
    "ancestors",
    "justification",
    "planData",
    "confidentialNotes",
    "hasChanges",
    "userField1",
    "userField2",
    "userField3",
    "userField4",
    "mgrPriority",
    "directorPriority",
    "srDirectorPriority",
    "vpPriority",
    "directorProposedReviewStatus",
    "srDirectorProposedReviewStatus",
    "vpProposedReviewStatus",
    "budgetApprovalStatus",
    "budgetApprovalComments",
    "vp",
    "productGroup",
    "productGroupImportedName",
    "salesTerritories",
    "salesTerritoryTypes",
    "comments",
    "roleDesc",
    "geckoComponent",
    "changesCurrentToPlan",
    "headcountCurrentFieldsModel",
    "proposedId",
    "reqOriginType",
    "reqOriginYear"
})
public class AddProposed {

    @JsonProperty("orgNode")
    private String orgNode;
    @JsonProperty("orgNodeString")
    private String orgNodeString;
    @JsonProperty("orgLevel")
    private Integer orgLevel;
    @JsonProperty("nodeId")
    private String nodeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameLong")
    private String nameLong;
    @JsonProperty("managedSupervisoryOrgId")
    private Object managedSupervisoryOrgId;
    @JsonProperty("managedSupervisoryOrgName")
    private Object managedSupervisoryOrgName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("reqType")
    private ReqType reqType;
    @JsonProperty("jobCodeName")
    private Object jobCodeName;
    @JsonProperty("reportsTo")
    private ReportsTo reportsTo;
    @JsonProperty("supervisoryOrg")
    private SupervisoryOrg supervisoryOrg;
    @JsonProperty("department")
    private Department department;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("jobCode")
    private Object jobCode;
    @JsonProperty("jobLevel")
    private Object jobLevel;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("isManager")
    private String isManager;
    @JsonProperty("regTemp")
    private Object regTemp;
    @JsonProperty("termDate")
    private Object termDate;
    @JsonProperty("reqLatestActivity")
    private Object reqLatestActivity;
    @JsonProperty("reqRecruiter")
    private Object reqRecruiter;
    @JsonProperty("reqDaysActive")
    private Object reqDaysActive;
    @JsonProperty("totalReports")
    private Object totalReports;
    @JsonProperty("directReports")
    private Object directReports;
    @JsonProperty("totalReqs")
    private Object totalReqs;
    @JsonProperty("totalAdds")
    private Object totalAdds;
    @JsonProperty("totalVpRequested")
    private Object totalVpRequested;
    @JsonProperty("totalVpDeferred")
    private Object totalVpDeferred;
    @JsonProperty("totalVpOther")
    private Object totalVpOther;
    @JsonProperty("ancestorsPath")
    private String ancestorsPath;
    @JsonProperty("ancestors")
    private List<String> ancestors = null;
    @JsonProperty("justification")
    private Object justification;
    @JsonProperty("planData")
    private Boolean planData;
    @JsonProperty("confidentialNotes")
    private Object confidentialNotes;
    @JsonProperty("hasChanges")
    private String hasChanges;
    @JsonProperty("userField1")
    private Object userField1;
    @JsonProperty("userField2")
    private Object userField2;
    @JsonProperty("userField3")
    private Object userField3;
    @JsonProperty("userField4")
    private Object userField4;
    @JsonProperty("mgrPriority")
    private Object mgrPriority;
    @JsonProperty("directorPriority")
    private Object directorPriority;
    @JsonProperty("srDirectorPriority")
    private Object srDirectorPriority;
    @JsonProperty("vpPriority")
    private Object vpPriority;
    @JsonProperty("directorProposedReviewStatus")
    private String directorProposedReviewStatus;
    @JsonProperty("srDirectorProposedReviewStatus")
    private String srDirectorProposedReviewStatus;
    @JsonProperty("vpProposedReviewStatus")
    private String vpProposedReviewStatus;
    @JsonProperty("budgetApprovalStatus")
    private String budgetApprovalStatus;
    @JsonProperty("budgetApprovalComments")
    private Object budgetApprovalComments;
    @JsonProperty("vp")
    private Vp vp;
    @JsonProperty("productGroup")
    private ProductGroup productGroup;
    @JsonProperty("productGroupImportedName")
    private Object productGroupImportedName;
    @JsonProperty("salesTerritories")
    private Object salesTerritories;
    @JsonProperty("salesTerritoryTypes")
    private Object salesTerritoryTypes;
    @JsonProperty("comments")
    private Object comments;
    @JsonProperty("roleDesc")
    private Object roleDesc;
    @JsonProperty("geckoComponent")
    private GeckoComponent geckoComponent;
    @JsonProperty("changesCurrentToPlan")
    private Object changesCurrentToPlan;
    @JsonProperty("headcountCurrentFieldsModel")
    private HeadcountCurrentFieldsModel headcountCurrentFieldsModel;
    @JsonProperty("proposedId")
    private Object proposedId;
    @JsonProperty("reqOriginType")
    private Object reqOriginType;
    @JsonProperty("reqOriginYear")
    private Object reqOriginYear;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("orgNode")
    public String getOrgNode() {
        return orgNode;
    }

    @JsonProperty("orgNode")
    public void setOrgNode(String orgNode) {
        this.orgNode = orgNode;
    }

    @JsonProperty("orgNodeString")
    public String getOrgNodeString() {
        return orgNodeString;
    }

    @JsonProperty("orgNodeString")
    public void setOrgNodeString(String orgNodeString) {
        this.orgNodeString = orgNodeString;
    }

    @JsonProperty("orgLevel")
    public Integer getOrgLevel() {
        return orgLevel;
    }

    @JsonProperty("orgLevel")
    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    @JsonProperty("nodeId")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("nodeId")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameLong")
    public String getNameLong() {
        return nameLong;
    }

    @JsonProperty("nameLong")
    public void setNameLong(String nameLong) {
        this.nameLong = nameLong;
    }

    @JsonProperty("managedSupervisoryOrgId")
    public Object getManagedSupervisoryOrgId() {
        return managedSupervisoryOrgId;
    }

    @JsonProperty("managedSupervisoryOrgId")
    public void setManagedSupervisoryOrgId(Object managedSupervisoryOrgId) {
        this.managedSupervisoryOrgId = managedSupervisoryOrgId;
    }

    @JsonProperty("managedSupervisoryOrgName")
    public Object getManagedSupervisoryOrgName() {
        return managedSupervisoryOrgName;
    }

    @JsonProperty("managedSupervisoryOrgName")
    public void setManagedSupervisoryOrgName(Object managedSupervisoryOrgName) {
        this.managedSupervisoryOrgName = managedSupervisoryOrgName;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("reqType")
    public ReqType getReqType() {
        return reqType;
    }

    @JsonProperty("reqType")
    public void setReqType(ReqType reqType) {
        this.reqType = reqType;
    }

    @JsonProperty("jobCodeName")
    public Object getJobCodeName() {
        return jobCodeName;
    }

    @JsonProperty("jobCodeName")
    public void setJobCodeName(Object jobCodeName) {
        this.jobCodeName = jobCodeName;
    }

    @JsonProperty("reportsTo")
    public ReportsTo getReportsTo() {
        return reportsTo;
    }

    @JsonProperty("reportsTo")
    public void setReportsTo(ReportsTo reportsTo) {
        this.reportsTo = reportsTo;
    }

    @JsonProperty("supervisoryOrg")
    public SupervisoryOrg getSupervisoryOrg() {
        return supervisoryOrg;
    }

    @JsonProperty("supervisoryOrg")
    public void setSupervisoryOrg(SupervisoryOrg supervisoryOrg) {
        this.supervisoryOrg = supervisoryOrg;
    }

    @JsonProperty("department")
    public Department getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("jobCode")
    public Object getJobCode() {
        return jobCode;
    }

    @JsonProperty("jobCode")
    public void setJobCode(Object jobCode) {
        this.jobCode = jobCode;
    }

    @JsonProperty("jobLevel")
    public Object getJobLevel() {
        return jobLevel;
    }

    @JsonProperty("jobLevel")
    public void setJobLevel(Object jobLevel) {
        this.jobLevel = jobLevel;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("isManager")
    public String getIsManager() {
        return isManager;
    }

    @JsonProperty("isManager")
    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    @JsonProperty("regTemp")
    public Object getRegTemp() {
        return regTemp;
    }

    @JsonProperty("regTemp")
    public void setRegTemp(Object regTemp) {
        this.regTemp = regTemp;
    }

    @JsonProperty("termDate")
    public Object getTermDate() {
        return termDate;
    }

    @JsonProperty("termDate")
    public void setTermDate(Object termDate) {
        this.termDate = termDate;
    }

    @JsonProperty("reqLatestActivity")
    public Object getReqLatestActivity() {
        return reqLatestActivity;
    }

    @JsonProperty("reqLatestActivity")
    public void setReqLatestActivity(Object reqLatestActivity) {
        this.reqLatestActivity = reqLatestActivity;
    }

    @JsonProperty("reqRecruiter")
    public Object getReqRecruiter() {
        return reqRecruiter;
    }

    @JsonProperty("reqRecruiter")
    public void setReqRecruiter(Object reqRecruiter) {
        this.reqRecruiter = reqRecruiter;
    }

    @JsonProperty("reqDaysActive")
    public Object getReqDaysActive() {
        return reqDaysActive;
    }

    @JsonProperty("reqDaysActive")
    public void setReqDaysActive(Object reqDaysActive) {
        this.reqDaysActive = reqDaysActive;
    }

    @JsonProperty("totalReports")
    public Object getTotalReports() {
        return totalReports;
    }

    @JsonProperty("totalReports")
    public void setTotalReports(Object totalReports) {
        this.totalReports = totalReports;
    }

    @JsonProperty("directReports")
    public Object getDirectReports() {
        return directReports;
    }

    @JsonProperty("directReports")
    public void setDirectReports(Object directReports) {
        this.directReports = directReports;
    }

    @JsonProperty("totalReqs")
    public Object getTotalReqs() {
        return totalReqs;
    }

    @JsonProperty("totalReqs")
    public void setTotalReqs(Object totalReqs) {
        this.totalReqs = totalReqs;
    }

    @JsonProperty("totalAdds")
    public Object getTotalAdds() {
        return totalAdds;
    }

    @JsonProperty("totalAdds")
    public void setTotalAdds(Object totalAdds) {
        this.totalAdds = totalAdds;
    }

    @JsonProperty("totalVpRequested")
    public Object getTotalVpRequested() {
        return totalVpRequested;
    }

    @JsonProperty("totalVpRequested")
    public void setTotalVpRequested(Object totalVpRequested) {
        this.totalVpRequested = totalVpRequested;
    }

    @JsonProperty("totalVpDeferred")
    public Object getTotalVpDeferred() {
        return totalVpDeferred;
    }

    @JsonProperty("totalVpDeferred")
    public void setTotalVpDeferred(Object totalVpDeferred) {
        this.totalVpDeferred = totalVpDeferred;
    }

    @JsonProperty("totalVpOther")
    public Object getTotalVpOther() {
        return totalVpOther;
    }

    @JsonProperty("totalVpOther")
    public void setTotalVpOther(Object totalVpOther) {
        this.totalVpOther = totalVpOther;
    }

    @JsonProperty("ancestorsPath")
    public String getAncestorsPath() {
        return ancestorsPath;
    }

    @JsonProperty("ancestorsPath")
    public void setAncestorsPath(String ancestorsPath) {
        this.ancestorsPath = ancestorsPath;
    }

    @JsonProperty("ancestors")
    public List<String> getAncestors() {
        return ancestors;
    }

    @JsonProperty("ancestors")
    public void setAncestors(List<String> ancestors) {
        this.ancestors = ancestors;
    }

    @JsonProperty("justification")
    public Object getJustification() {
        return justification;
    }

    @JsonProperty("justification")
    public void setJustification(Object justification) {
        this.justification = justification;
    }

    @JsonProperty("planData")
    public Boolean getPlanData() {
        return planData;
    }

    @JsonProperty("planData")
    public void setPlanData(Boolean planData) {
        this.planData = planData;
    }

    @JsonProperty("confidentialNotes")
    public Object getConfidentialNotes() {
        return confidentialNotes;
    }

    @JsonProperty("confidentialNotes")
    public void setConfidentialNotes(Object confidentialNotes) {
        this.confidentialNotes = confidentialNotes;
    }

    @JsonProperty("hasChanges")
    public String getHasChanges() {
        return hasChanges;
    }

    @JsonProperty("hasChanges")
    public void setHasChanges(String hasChanges) {
        this.hasChanges = hasChanges;
    }

    @JsonProperty("userField1")
    public Object getUserField1() {
        return userField1;
    }

    @JsonProperty("userField1")
    public void setUserField1(Object userField1) {
        this.userField1 = userField1;
    }

    @JsonProperty("userField2")
    public Object getUserField2() {
        return userField2;
    }

    @JsonProperty("userField2")
    public void setUserField2(Object userField2) {
        this.userField2 = userField2;
    }

    @JsonProperty("userField3")
    public Object getUserField3() {
        return userField3;
    }

    @JsonProperty("userField3")
    public void setUserField3(Object userField3) {
        this.userField3 = userField3;
    }

    @JsonProperty("userField4")
    public Object getUserField4() {
        return userField4;
    }

    @JsonProperty("userField4")
    public void setUserField4(Object userField4) {
        this.userField4 = userField4;
    }

    @JsonProperty("mgrPriority")
    public Object getMgrPriority() {
        return mgrPriority;
    }

    @JsonProperty("mgrPriority")
    public void setMgrPriority(Object mgrPriority) {
        this.mgrPriority = mgrPriority;
    }

    @JsonProperty("directorPriority")
    public Object getDirectorPriority() {
        return directorPriority;
    }

    @JsonProperty("directorPriority")
    public void setDirectorPriority(Object directorPriority) {
        this.directorPriority = directorPriority;
    }

    @JsonProperty("srDirectorPriority")
    public Object getSrDirectorPriority() {
        return srDirectorPriority;
    }

    @JsonProperty("srDirectorPriority")
    public void setSrDirectorPriority(Object srDirectorPriority) {
        this.srDirectorPriority = srDirectorPriority;
    }

    @JsonProperty("vpPriority")
    public Object getVpPriority() {
        return vpPriority;
    }

    @JsonProperty("vpPriority")
    public void setVpPriority(Object vpPriority) {
        this.vpPriority = vpPriority;
    }

    @JsonProperty("directorProposedReviewStatus")
    public String getDirectorProposedReviewStatus() {
        return directorProposedReviewStatus;
    }

    @JsonProperty("directorProposedReviewStatus")
    public void setDirectorProposedReviewStatus(String directorProposedReviewStatus) {
        this.directorProposedReviewStatus = directorProposedReviewStatus;
    }

    @JsonProperty("srDirectorProposedReviewStatus")
    public String getSrDirectorProposedReviewStatus() {
        return srDirectorProposedReviewStatus;
    }

    @JsonProperty("srDirectorProposedReviewStatus")
    public void setSrDirectorProposedReviewStatus(String srDirectorProposedReviewStatus) {
        this.srDirectorProposedReviewStatus = srDirectorProposedReviewStatus;
    }

    @JsonProperty("vpProposedReviewStatus")
    public String getVpProposedReviewStatus() {
        return vpProposedReviewStatus;
    }

    @JsonProperty("vpProposedReviewStatus")
    public void setVpProposedReviewStatus(String vpProposedReviewStatus) {
        this.vpProposedReviewStatus = vpProposedReviewStatus;
    }

    @JsonProperty("budgetApprovalStatus")
    public String getBudgetApprovalStatus() {
        return budgetApprovalStatus;
    }

    @JsonProperty("budgetApprovalStatus")
    public void setBudgetApprovalStatus(String budgetApprovalStatus) {
        this.budgetApprovalStatus = budgetApprovalStatus;
    }

    @JsonProperty("budgetApprovalComments")
    public Object getBudgetApprovalComments() {
        return budgetApprovalComments;
    }

    @JsonProperty("budgetApprovalComments")
    public void setBudgetApprovalComments(Object budgetApprovalComments) {
        this.budgetApprovalComments = budgetApprovalComments;
    }

    @JsonProperty("vp")
    public Vp getVp() {
        return vp;
    }

    @JsonProperty("vp")
    public void setVp(Vp vp) {
        this.vp = vp;
    }

    @JsonProperty("productGroup")
    public ProductGroup getProductGroup() {
        return productGroup;
    }

    @JsonProperty("productGroup")
    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    @JsonProperty("productGroupImportedName")
    public Object getProductGroupImportedName() {
        return productGroupImportedName;
    }

    @JsonProperty("productGroupImportedName")
    public void setProductGroupImportedName(Object productGroupImportedName) {
        this.productGroupImportedName = productGroupImportedName;
    }

    @JsonProperty("salesTerritories")
    public Object getSalesTerritories() {
        return salesTerritories;
    }

    @JsonProperty("salesTerritories")
    public void setSalesTerritories(Object salesTerritories) {
        this.salesTerritories = salesTerritories;
    }

    @JsonProperty("salesTerritoryTypes")
    public Object getSalesTerritoryTypes() {
        return salesTerritoryTypes;
    }

    @JsonProperty("salesTerritoryTypes")
    public void setSalesTerritoryTypes(Object salesTerritoryTypes) {
        this.salesTerritoryTypes = salesTerritoryTypes;
    }

    @JsonProperty("comments")
    public Object getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Object comments) {
        this.comments = comments;
    }

    @JsonProperty("roleDesc")
    public Object getRoleDesc() {
        return roleDesc;
    }

    @JsonProperty("roleDesc")
    public void setRoleDesc(Object roleDesc) {
        this.roleDesc = roleDesc;
    }

    @JsonProperty("geckoComponent")
    public GeckoComponent getGeckoComponent() {
        return geckoComponent;
    }

    @JsonProperty("geckoComponent")
    public void setGeckoComponent(GeckoComponent geckoComponent) {
        this.geckoComponent = geckoComponent;
    }

    @JsonProperty("changesCurrentToPlan")
    public Object getChangesCurrentToPlan() {
        return changesCurrentToPlan;
    }

    @JsonProperty("changesCurrentToPlan")
    public void setChangesCurrentToPlan(Object changesCurrentToPlan) {
        this.changesCurrentToPlan = changesCurrentToPlan;
    }

    @JsonProperty("headcountCurrentFieldsModel")
    public HeadcountCurrentFieldsModel getHeadcountCurrentFieldsModel() {
        return headcountCurrentFieldsModel;
    }

    @JsonProperty("headcountCurrentFieldsModel")
    public void setHeadcountCurrentFieldsModel(HeadcountCurrentFieldsModel headcountCurrentFieldsModel) {
        this.headcountCurrentFieldsModel = headcountCurrentFieldsModel;
    }

    @JsonProperty("proposedId")
    public Object getProposedId() {
        return proposedId;
    }

    @JsonProperty("proposedId")
    public void setProposedId(Object proposedId) {
        this.proposedId = proposedId;
    }

    @JsonProperty("reqOriginType")
    public Object getReqOriginType() {
        return reqOriginType;
    }

    @JsonProperty("reqOriginType")
    public void setReqOriginType(Object reqOriginType) {
        this.reqOriginType = reqOriginType;
    }

    @JsonProperty("reqOriginYear")
    public Object getReqOriginYear() {
        return reqOriginYear;
    }

    @JsonProperty("reqOriginYear")
    public void setReqOriginYear(Object reqOriginYear) {
        this.reqOriginYear = reqOriginYear;
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
