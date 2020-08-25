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
public class EditReportsToTest extends TestBaseUI{
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
    wt.maximize();
    init_dbconnection();
  }

  @Test
  public void editReportsToTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    String rowId=listPlan.selectRow(icID);
    AddModal editModal = toolStrip.editProposed();
    editModal.fillReportsTo(managerName);
    Thread.sleep(2000);
    editModal.save();
    validateReportsTO(managerName,rowId);
  }

  private void validateReportsTO(String ExpectedName,String rowId) throws SQLException {
    String actualName="";
    pstmt = conn.prepareStatement(
            "select * from HEADCOUNT_PLAN_VW where headcount_id in (select headcount_id from ORG_HIERARCHY_PLAN where node_id=?)");
    pstmt.setString(1,rowId);
    rs = pstmt.executeQuery();
    while(rs.next()){
      actualName=rs.getString("reports_to_name");
    }
    Assert.assertTrue(rowId.contains(actualName));
  }


  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
