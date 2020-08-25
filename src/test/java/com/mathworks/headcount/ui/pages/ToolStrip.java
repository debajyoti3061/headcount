package com.mathworks.headcount.ui.pages;

import com.mathworks.test.tools.mwhtmlguitest.NonTextKeys;
import com.mathworks.test.tools.mwhtmlguitest.WindowTester;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ToolStrip {
  private WindowTester wt;
  public ToolStrip(WindowTester window){
    this.wt = window;
  }

  String currentButton="input[name='phase'][value='current']";
  String planButton="#phase-select-radio-group > label > a > span > input[value=\"plan\"]";
  String listButton="input[name='view'][value='0']";
  String orgChartButton="input[name='view'][value='1']";
  String addButton ="//span[text()='Add']";
  String editButton ="//span[text()='Edit/View']";
  String edit="#ba-tstrip-button-editheadcount";
  String removeButton ="//span[text()='Remove']";
  String managerSelect="#manager-select";
  String archiveButton="#ba-tstrip-button-archive";
  String managerDDL="button[title='Open']>span>svg";
  String firstManager="input[aria-activedescendant='manager-select-option-0']";
  String lockButton="input[class*='MuiSwitch-input']";
  String Locked="span[class*='Mui-checked']";
  String logoutButton="//*[@id=\"app\"]/div[1]/header/div/div/button";
  String logout="//*[@id=\"Toolstrip-ba-tstrip-titlebar-qa-settings-menu\"]/div[3]/ul/li";
  String disableAddButton="#ba-tstrip-button-addheadcount";
  String disableEditButton="#ba-tstrip-button-editheadcount";
  String disableRemoveButton="#ba-tstrip-button-removeheadcount";
  String disableEditGroupButton="#ba-tstrip-button-editgroup";
  String disableArchiveButton="#ba-tstrip-button-archive";
  String convertButton = "#ba-tstrip-button-convert";
  String confirmButton ="//span[text()='Confirm']";
  //String disableUnArchiveButton="#ba-tstrip-button-unarchive";


  public AddModal addProposed(){
    wt.getTesterByXpath(addButton).click();

    return new AddModal(wt);
  }

  public AddModal editProposed(){
    wt.getTesterByXpath(editButton).click();
    //wt.getTesterByCSS(edit).click();
    return new AddModal(wt);
  }

  public void removeProposed(){
    wt.getTesterByXpath(removeButton).click();
  }

  public void gotoOrgView(){
    wt.getTesterByCSS(orgChartButton).click();
  }

  public void gotolistView(){
    wt.getTesterByCSS(listButton).click();
  }

  public void gotoplanView(){
    wt.getTesterByCSS(planButton).click();
  }

  public void gotocurrentView(){
    wt.getTesterByCSS(currentButton).click();
  }

  public void selectManager(String manager){
    wt.getTesterByCSS(managerSelect).sendKey(NonTextKeys.CONTROL+"A");
    wt.getTesterByCSS(managerSelect).sendKey(NonTextKeys.DELETE);
    wt.getTesterByCSS(managerSelect).sendKey(manager);
    wt.getTesterByCSS(managerSelect).sendKey(NonTextKeys.ARROW_DOWN);
    wt.getTesterByCSS(managerSelect).sendKey(NonTextKeys.ENTER);
  }

  public void archive() {
    wt.getTesterByCSS(archiveButton).click();
  }

  public void loadGrid(String managerName) {
    wt.getTesterByCSS(managerDDL).click();
    wt.getTesterByCSS(managerSelect).sendKey(managerName);
    wt.getTesterByCSS(firstManager).click();
  }
  public void setLockButton() { wt.getTesterByCSS(lockButton).click();}

  public void flip() {
    wt.getTesterByCSS(convertButton).click();
    wt.getTesterByXpath(confirmButton).click();
   /* await()
        .pollInterval(2, TimeUnit.SECONDS)
        .atMost(6, TimeUnit.SECONDS)
        .until(() -> wt.getTestersByCSS().size() != 0);*/
  }

  public Boolean isLocked() {
    try{
      if (wt.getTesterByCSS(Locked) != null)
        return true;
    }catch(Exception e){

    }
    return false;
  }

  public Boolean getProperty(String propertyName,String propertyValue){
    //String disabledClass = "Mui-disabled.Mui-disabled";
  if(propertyName.contains("Add"))
    return wt.getTesterByCSS(disableAddButton).getAttribute("class").contains(propertyValue);
    if(propertyName.contains("Edit"))
      return wt.getTesterByCSS(disableEditButton).getAttribute("class").contains(propertyValue);
    if(propertyName.contains("Remove"))
      return wt.getTesterByCSS(disableRemoveButton).getAttribute("class").contains(propertyValue);
    if(propertyName.contains("EditGroup"))
      return wt.getTesterByCSS(disableEditGroupButton).getAttribute("class").contains(propertyValue);
    if(propertyName.contains("Archive"))
      return wt.getTesterByCSS(disableArchiveButton).getAttribute("class").contains(propertyValue);

      return false;
  }
  public void logout(){
    wt.getTesterByXpath(logoutButton).click();
    wt.getTesterByXpath(logout).click();

  }

}
