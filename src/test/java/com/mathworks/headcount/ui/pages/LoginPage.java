package com.mathworks.headcount.ui.pages;

import com.mathworks.test.tools.mwhtmlguitest.WindowTester;

public class LoginPage {
  private WindowTester wt;
  public LoginPage(WindowTester window){
    this.wt = window;
  }

  public OrgCurrent doLogin(String username,String password){
    wt.getTesterByCSS("#ba-lf-username").sendKey(username);
    wt.getTesterByCSS("#ba-lf-password").sendKey(password);
    wt.getTesterByCSS(".loginButton").click();
    return  new OrgCurrent(wt);
  }
}
