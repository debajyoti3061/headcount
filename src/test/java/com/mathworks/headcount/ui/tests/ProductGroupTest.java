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
public class ProductGroupTest extends TestBaseUI{
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
  public void setProductGrpProposedTest()  throws SQLException , InterruptedException{
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    //icID="PROPOSED_2467";
    //node_id="PROPOSED_2467";
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    AddModal editModal = toolStrip.editProposed();
    editModal.setProductGrp("M1 Matlab");
    validateProductGrp("M1 MATLAB",node_id);
  }

  @Ignore
  @Test
  public void setProductGrpReqTest()  throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow("req1");
    AddModal editModal = toolStrip.editProposed();
    editModal.setProductGrp("A1 EPS");
    validateProductGrp("A1 EPS",node_id);
  }

  @Ignore
  @Test
  public void setProductGrpStaffTest()  throws SQLException , InterruptedException{
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow("staff1");
    AddModal editModal = toolStrip.editProposed();
    editModal.setProductGrp("E1 EDU");
    validateProductGrp("E1 EDU",node_id);
  }

  private void validateProductGrp(String ExpectedName,String rowId) throws SQLException {
      String ActualName="";
      pstmt = conn.prepareStatement(
              "select * from HEADCOUNT_PLAN_VW where headcount_id in (select headcount_id from ORG_HIERARCHY_PLAN where node_id=?)");
      pstmt.setString(1,rowId);
      rs = pstmt.executeQuery();
      while(rs.next()){
          ActualName=rs.getString("product_group_name");
      }
      Assert.assertEquals(ExpectedName,ActualName);
  }


  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }

}
