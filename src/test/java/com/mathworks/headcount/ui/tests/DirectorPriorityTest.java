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
public class DirectorPriorityTest extends TestBaseUI{
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
  public void setDirectorPriorityTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest21",dbconfig.getProperty("directorPassword"));
    String DirectorPriority="D1";
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    //icID="PROPOSED_2467";
    //node_id="PROPOSED_2467";
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id); // get name of the previously added row
    AddModal addModal = toolStrip.editProposed();
    addModal.setDirectorPriority(DirectorPriority);
    validateDirectorPriority(DirectorPriority,node_id);
  }

  private void validateDirectorPriority(String ExpectedPriority, String rowId) throws SQLException {
      String ActualPriority="";
      pstmt = conn.prepareStatement(
              "select * from HEADCOUNT_PLAN_VW where headcount_id in (select headcount_id from ORG_HIERARCHY_PLAN where node_id=?)");
      pstmt.setString(1,rowId);
      rs = pstmt.executeQuery();
      while(rs.next()){
        ActualPriority=rs.getString("director_priority");
      }
      Assert.assertEquals(ExpectedPriority,ActualPriority);

  }

  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}

