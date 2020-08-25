package com.mathworks.headcount.ui.pages;

import com.mathworks.test.tools.mwhtmlguitest.*;

import java.util.List;

public class ListPlan {
  private WindowTester wt;
  String columnToGroup="div[class='ag-header-row'] > div[col-id='columnName']";
  String rowGroups="div[class*='ag-column-drop-row-group'] > span[class='ag-column-drop-empty-message']";


  public ListPlan(WindowTester window){
    this.wt = window;
  }

  public  String selectRow(String rowName){
    String rowInGridContainer= "div[row-id*=\""+rowName+"\"] > div";
            //"div.ag-center-cols-clipper > div > div > div[row-id*=\"" + rowName +"\"] > div[col-id=\"type\"]";
      //String rowInGridContainer= "#ListViewGrid > div > div > div[class*=\"ag-layout-normal\"] > div[class*=\"ag-layout-normal\"] > div[class*=\"ag-row-animation\"] > div.ag-center-cols-clipper > div > div > div[row-id*=\"" + rowName +"\"] > div[col-id=\"type\"]";
    //wt.getTesterByXpath("//div[@col-id='name'][text()="+rowName).click();
      List<ElementTester> elementTesters =  wt.getTestersByCSS(rowInGridContainer);
      elementTesters.get(0).click();
      System.out.println("Row Id :" + elementTesters.get(0).getInnerText());
      return elementTesters.get(0).getInnerText();
  }
  public  void selectMultiRows(List<String> rowName){
    for (String s : rowName) {
      ElementTester row = wt.getTesterById("//div[@col-id='name'][text()=" + s);
      row.doWithModifier(ModifierKey.CONTROL, (Runnable) row::click);
    }
  }
  public void selectAColumnAndSetRowGroups(String columnName){
    columnToGroup=columnToGroup.replace("columnName",columnName);
    wt.getTesterByCSS(columnToGroup).dragAndDrop(wt.getTesterByCSS(rowGroups));
  }

  public Boolean singleLevelGroupValidation(List<String> groupvalues){
    String GridGroupingData="div[class*='ag-row-animation'] > div[class='ag-center-cols-clipper'] > div > div > div";
    Boolean isGrouped=false;

    List<ElementTester> GroupingData=  wt.getTestersByCSS(GridGroupingData);

    for (ElementTester e:GroupingData) {
     if (groupvalues.contains(e.getInnerText().split("\\(")[0])){
        isGrouped=true;
      }
      else{
        isGrouped=false;
        return isGrouped;
      }

    }

    return isGrouped;
  }
}
