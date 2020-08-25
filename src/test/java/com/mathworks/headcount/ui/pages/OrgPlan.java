package com.mathworks.headcount.ui.pages;

import com.mathworks.test.tools.mwhtmlguitest.*;

import java.util.List;

public class OrgPlan {

    private WindowTester wt;
    public OrgPlan(WindowTester window){
        this.wt = window;
    }

    public Boolean headcountICExists(String node_id){
        String IdSearchInGrid="div[row-id=\""+node_id+"\"]";
        //div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-pinned-left-cols-container >
        if(wt.getTestersByCSS(IdSearchInGrid)!=null)
            return true;
        return false;
    }

    public Boolean headcountManagerExists(String node_id){
        String IdSearchInGrid="div[row-id=\""+node_id+"\"]";
        //div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-pinned-left-cols-container >
        if(wt.getTestersByCSS(IdSearchInGrid)!=null)
            return true;
        return false;
    }

  public void selectRow(String rowName){
    String rowInGridContainer= "div[row-id*=\""+rowName+"\"] > div";
    List<ElementTester> elementTesters =  wt.getTestersByCSS(rowInGridContainer);
    elementTesters.get(0).click();

  }
  public  void selectMultiRows(List<String> rowName){
    for (String s : rowName) {
      ElementTester row = wt.getTesterById("//div[@col-id='name'][text()=" + s);
      row.doWithModifier(ModifierKey.CONTROL, (Runnable) row::click);
    }
  }
}
