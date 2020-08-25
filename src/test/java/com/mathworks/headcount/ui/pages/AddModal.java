package com.mathworks.headcount.ui.pages;

import com.mathworks.test.tools.mwhtmlguitest.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

public class AddModal {
  private WindowTester wt;

  public AddModal(WindowTester window) {
    this.wt = window;
  }

  String namebox = "#edit-panel-name";
  String roleDescbox = "#edit-panel-role";
  String deptDDL = "#edit-panel-department";
  String reportsToDDL = "#edit-panel-reports-to";
  String jobCodeDDL = "#edit-panel-jobCode";
  String group = "#edit-panel-group";
  String firstValueInGroup = "input[aria-activedescendant='edit-panel-group-option-0']";
  String firstJobCode = "[aria-controls='edit-panel-jobCode-popup'] [aria-activedescedant='edit-panel-jobCode-option-0']";
  String managesExistingGrpDDL = "#edit-panel-jobCodeExistingGroup";
  String managesNewGrpDDL = "#edit-panel-jobCodeNewGroup";
  String locationDDL = "#edit-panel-location-rollup";
  String locationRemove = "//input[@id='edit-panel-location-rollup']/following-sibling::div/button";
  String managerPriorityBox = "#edit-panel-mgr-priority";
  String directorPriorityBox = "#edit-panel-dir-priority";
  String srdirectorPriorityBox = "#edit-panel-sr-dir-priority";
  String vpPriorityBox = "#edit-panel-vp-priority";
  String justificationBox = "body[data-id='edit-panel-justification']";
  String commentBox = "body[data-id='edit-panel-comments']";
  String saveButton = "#edit-panel-save";
  String cancelButton = "#edit-panel-cancel";
  String userField1 = "#edit-panel-user-1";
  String confidentialNotesBox = "#edit-panel-confidential-notes";
  String productGrpDDL = "#edit-panel-product-group";
  String newGrpRadioButton = "input[value='newGroup']";
  String vpReviewStatus = "#edit-panel-vp-status";
  String directorReviewStatus = "#edit-panel-dir-status";
  String srDirectorReviewStatus = "#edit-panel-sr-dir-status";
  String budgetApprovalStatus = "#edit-panel-budget-status";
  String closeIcon ="button[aria-label='Close']";

  public void save() throws InterruptedException {
    wt.getTesterByCSS(saveButton).click();
    await()
        .pollInterval(2,TimeUnit.SECONDS)
        .atMost(8, TimeUnit.SECONDS)
        .until(() -> wt.getTestersByCSS(closeIcon).size() != 0);
  }

  public void addProposed(String name, String roleDesc, String reportsTo, String reportsToGroup, String jobCode, boolean isManager, boolean isNewGrp, String managesGrp, String location, String dept) throws InterruptedException {
    fillName(name);
    fillRoleDescription(roleDesc);
    fillReportsTo(reportsTo);
    fillReportToGroup(reportsToGroup);
    fillJobCode(jobCode, isManager, isNewGrp, managesGrp);
    // fillLocation(location);
    //fillDepartment(dept);
  }

  public void fillDepartment(String dept) {
    wt.getTesterByCSS(deptDDL).sendKey(dept);
  }

  public void fillReportsTo(String reportsTo) {
    wt.getTesterByCSS(reportsToDDL).click();
    wt.getTesterByCSS(reportsToDDL).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(reportsToDDL).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(reportsToDDL).sendKey(reportsTo);
    wt.getTesterByCSS(reportsToDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(reportsToDDL).sendKey(NonTextKeys.ENTER);
  }

  public void fillJobCode(String jobCode, boolean isManager, boolean isNewGrp, String managesGrp) throws InterruptedException {
    wt.getTesterByCSS(jobCodeDDL).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(jobCodeDDL).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(jobCodeDDL).sendKey(jobCode);
    //wt.
    wt.getTesterByCSS(jobCodeDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(jobCodeDDL).sendKey(NonTextKeys.ENTER);
    //Thread.sleep(2000);

    //wt.getTesterByCSS(firstJobCode).click();
    if (isManager) {
      if (isNewGrp) {
        wt.getTesterByCSS(newGrpRadioButton).click();
        //Thread.sleep(2000);
        createfillNewGrp(managesGrp);
      } else {
        selectexistingGrp(managesGrp);
      }
    }

  }

  private void selectexistingGrp(String managesGrp) {
    wt.getTesterByCSS(managesExistingGrpDDL).sendKey(managesGrp);
    wt.getTesterByCSS(managesExistingGrpDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(managesExistingGrpDDL).sendKey(NonTextKeys.ENTER);
  }

  private void createfillNewGrp(String grp) throws InterruptedException {
    //Thread.sleep(2000);
    wt.getTesterByCSS(managesNewGrpDDL).sendKey(grp);
    //Thread.sleep(2000);
  }

  private void fillLocation(String location) {
    wt.getTesterByCSS(locationDDL).sendKey(location);
  }

  private void fillRoleDescription(String roleDesc) {
    wt.getTesterByCSS(roleDescbox).sendKey(roleDesc);
  }

  private void fillName(String name) {
    wt.getTesterByCSS(namebox).sendKey(name);
  }

  private void fillReportToGroup(String groupName) throws InterruptedException {
    wt.getTesterByCSS(group).sendKey(groupName);
    //wt.getTesterByCSS(firstValueInGroup).click();
    wt.getTesterByCSS(group).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(group).sendKey(NonTextKeys.ENTER);
  }
  //aria-activedescendant='edit-panel-group-option-0

  public void setManagerPriority(String priority) throws InterruptedException {
    wt.getTesterByCSS(managerPriorityBox).click();
    wt.getTesterByCSS(managerPriorityBox).sendKey(priority);
    save();
  }

  public void setDirectorPriority(String priority) throws InterruptedException {
    wt.getTesterByCSS(directorPriorityBox).sendKey(priority);
    save();
  }

  public void setSrDirectorPriority(String priority) throws InterruptedException {
    wt.getTesterByCSS(srdirectorPriorityBox).sendKey(priority);
    save();
  }

  public void setVPPriority(String priority) throws InterruptedException {
    wt.getTesterByCSS(vpPriorityBox).sendKey(priority);
    save();
  }


  public void setDirectorReviewStatus(String status) throws InterruptedException {
    wt.getTesterByCSS(directorReviewStatus).click();
    wt.getTesterByCSS(directorReviewStatus).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(directorReviewStatus).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(directorReviewStatus).sendKey(status);
    wt.getTesterByCSS(directorReviewStatus).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(directorReviewStatus).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setSrDirectorReviewStatus(String status) throws InterruptedException {
    wt.getTesterByCSS(srDirectorReviewStatus).click();
    wt.getTesterByCSS(srDirectorReviewStatus).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(srDirectorReviewStatus).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(srDirectorReviewStatus).sendKey(status);
    wt.getTesterByCSS(srDirectorReviewStatus).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(srDirectorReviewStatus).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setVPReviewStatus(String status) throws InterruptedException {
    wt.getTesterByCSS(vpReviewStatus).click();
    wt.getTesterByCSS(vpReviewStatus).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(vpReviewStatus).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(vpReviewStatus).sendKey(status);
    wt.getTesterByCSS(vpReviewStatus).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(vpReviewStatus).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setBudgettingReviewStatus(String status) throws InterruptedException{
    wt.getTesterByCSS(budgetApprovalStatus).click();
    wt.getTesterByCSS(budgetApprovalStatus).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(budgetApprovalStatus).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(budgetApprovalStatus).sendKey(status);
    wt.getTesterByCSS(budgetApprovalStatus).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(budgetApprovalStatus).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setJustification(String justification) throws InterruptedException {
    moveIniFrame("edit-panel-justification_ifr");
    wt.getTesterByCSS(justificationBox).sendKey(justification);
    moveOutiFrame();
    save();
  }

  private void moveIniFrame(String id) {
    FrameTester ft = wt.getTesterById(id);
    wt.zoomToFrame(ft);
  }

  public void moveOutiFrame() {
    wt.toFront();
  }

  public void setComment(String comment) throws InterruptedException {
    moveIniFrame("edit-panel-comments_ifr");
    wt.getTesterByCSS(commentBox).sendKey(comment);
    moveOutiFrame();
    save();
  }

  public String getAttribute(String attribute) {
    return wt.getTesterByCSS(justificationBox).getAttribute(attribute);
  }

  public void setUserField(String userFieldData) throws InterruptedException {
    wt.getTesterByCSS(userField1).sendKey(userFieldData);
    save();
  }

  public void setConfNotes(String confNotes) throws InterruptedException {
    wt.getTesterByCSS(confidentialNotesBox).sendKey(confNotes);
    save();
  }

  public void setDepartment(String department) throws InterruptedException {
    wt.getTesterByCSS(deptDDL).click();
    wt.getTesterByCSS(deptDDL).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(deptDDL).sendKey(department);
    wt.getTesterByCSS(deptDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(deptDDL).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setLocation(String location) throws InterruptedException {
    wt.getTesterByCSS(locationDDL).click();
    wt.getTesterByCSS(locationDDL).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(locationDDL).sendKey(location);
    wt.getTesterByCSS(locationDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(locationDDL).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setProductGrp(String productGrp) throws InterruptedException {
    wt.getTesterByCSS(productGrpDDL).click();
    wt.getTesterByCSS(productGrpDDL).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(productGrpDDL).sendKey(productGrp);
    wt.getTesterByCSS(productGrpDDL).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(productGrpDDL).sendKey(NonTextKeys.ENTER);
    save();
  }

  public void setRoleDescription(String roleDescription) throws InterruptedException {
    wt.getTesterByCSS(roleDescbox).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(roleDescbox).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(roleDescbox).sendKey(roleDescription);
    save();
  }




}
