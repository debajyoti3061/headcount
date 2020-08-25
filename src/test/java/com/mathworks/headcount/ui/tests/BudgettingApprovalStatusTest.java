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
public class BudgettingApprovalStatusTest extends TestBaseUI{
  private static TesterFactory tf;
  private static WindowTester wt;

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
  public void setbudgettingReview1Test()  throws SQLException , InterruptedException{
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    //icID="PROPOSED_2467";
    //node_id="PROPOSED_2467";
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setBudgettingReviewStatus("Approved by Gating");
    validateBudgettingReviewStatus("Approved by Gating",node_id);
  }
  @Test
  public void setbudgettingReview2Test()  throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setBudgettingReviewStatus("Approved Pending");
    validateBudgettingReviewStatus("Approved Pending",node_id);
  }
  @Test
  public void setbudgettingReview3Test()  throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setBudgettingReviewStatus("On Hold");
    validateBudgettingReviewStatus("On Hold",node_id);
  }

  @Test
  public void setbudgettingReview4Test()  throws SQLException , InterruptedException{
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setBudgettingReviewStatus("Declined");
    validateBudgettingReviewStatus("Declined",node_id);
  }

  @Test
  public void setbudgettingReview5Test()  throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setBudgettingReviewStatus("Unreviewed");
    validateBudgettingReviewStatus("Unreviewed",node_id);
  }

  private void validateBudgettingReviewStatus(String ExpectedStatus,String rowId) throws SQLException, InterruptedException {
      String ActualStatus="";
      pstmt = conn.prepareStatement(
              "select * from HEADCOUNT_PLAN_VW where headcount_id in (select headcount_id from ORG_HIERARCHY_PLAN where node_id=?)");
      pstmt.setString(1,rowId);
      rs = pstmt.executeQuery();
      while(rs.next()){
          ActualStatus=rs.getString("budget_approval_status");
      }
      Assert.assertEquals(ExpectedStatus,ActualStatus);
  }

  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
