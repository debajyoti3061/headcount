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
public class VpReviewStatusTest extends TestBaseUI{
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
  public void setVPReview1Test()  throws SQLException,InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest22",dbconfig.getProperty("vpPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    //icID="PROPOSED_2467";
    //node_id="PROPOSED_2467";
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setVPReviewStatus("Request");
    validateVPReviewStatus("Request",node_id);
  }
  @Test
  public void setVPReview2Test()  throws SQLException,InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest22",dbconfig.getProperty("vpPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setVPReviewStatus("Defer");
    validateVPReviewStatus("Defer",node_id);
  }
  @Test
  public void setDirectorReview3Test()  throws SQLException,InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest22",dbconfig.getProperty("vpPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setVPReviewStatus("Drop");
    validateVPReviewStatus("Drop",node_id);
  }

  @Test
  public void setVPReview4Test()  throws SQLException,InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest22",dbconfig.getProperty("vpPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal addModal = toolStrip.editProposed();
    addModal.setVPReviewStatus("Unreviewed");
    validateVPReviewStatus("Unreviewed",node_id);
  }

  private void validateVPReviewStatus(String ExpectedStatus,String rowId) throws SQLException {
      String ActualStatus="";
      pstmt = conn.prepareStatement(
              "select * from HEADCOUNT_PLAN_VW where headcount_id in (select headcount_id from ORG_HIERARCHY_PLAN where node_id=?)");
      pstmt.setString(1,rowId);
      rs = pstmt.executeQuery();
      while(rs.next()){
          ActualStatus=rs.getString("vp_proposed_review_status");
      }
      Assert.assertEquals(ExpectedStatus,ActualStatus);
  }

  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}