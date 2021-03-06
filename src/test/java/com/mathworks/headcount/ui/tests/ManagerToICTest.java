package com.mathworks.headcount.ui.tests;

import com.mathworks.headcount.ui.pages.*;
import com.mathworks.test.tools.mwhtmlguitest.TesterFactory;
import com.mathworks.test.tools.mwhtmlguitest.WindowTester;
import com.mathworks.test.tools.mwwebguitesttools.browsersupport.SupportedBrowser;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.BeforeBrowserSession;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.SingleBrowserPerTest;
import org.junit.*;
import org.junit.runner.RunWith;

import java.sql.SQLException;

@RunWith(SingleBrowserPerTest.class)
public class ManagerToICTest extends TestBaseUI{
  private static TesterFactory tf;
  private static WindowTester wt;
  String currentTime=getCurrentTime();

  @BeforeBrowserSession
  public static void beforeBrowser(SupportedBrowser sb) {
    tf = new TesterFactory(sb);
  }

  @Before
  public void beforeThisTest() throws SQLException {
    initConfigurations();
    initenv();
    wt = tf.openWindowTester(TESTURL);
    init_dbconnection();
  }

  @Test
  public void proposedManagertoICTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow("proposedManager");
    AddModal editModal = toolStrip.addProposed();
    editModal.fillJobCode("QUE30I",false,false,"");
    validateAdd();
  }

  @Test
  public void reqManagertoICTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow("reqManager");
    AddModal editModal = toolStrip.addProposed();
    editModal.fillJobCode("QUE30I",false,false,"");
    validateAdd();
  }

  @Test
  public void staffManagertoICTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow("staffManager");
    AddModal editModal = toolStrip.addProposed();
    editModal.fillJobCode("QUE30I",false,false,"");
    validateAdd();
  }

  private void validateAdd() {
  }


  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
