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
public class ICtoManagerManagesExistingGrpTest extends TestBaseUI{
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
  public void icPorposedToManagerExistingGrpTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(icID);
    AddModal editModal = toolStrip.editProposed();
    editModal.fillJobCode("QUE30S",true,false,manages_sup);
    editModal.save();
    validateExistingGrpPromotion();
  }

  @Ignore
  @Test
  public void icReqToManagerExistingGrpTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow("reqID");
    AddModal editModal = toolStrip.editProposed();
    editModal.fillJobCode("QUE30S",true,false,"manages sup"+"Req");
    validateExistingGrpPromotion();
  }

  @Ignore
  @Test
  public void icStaffToManagerExistingGrpTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow("staff name");
    AddModal editModal = toolStrip.editProposed();
    editModal.fillJobCode("QUE30S",true,false,"manages sup"+"staff");
    validateExistingGrpPromotion();
  }

  private void validateExistingGrpPromotion() throws SQLException {

    System.out.println(headcount_id);
    String ancestors ="SUP_MATHWORKS,SUP_195,SUP_172,SUP_462,SUP_927,SUP_2590";
    String ancestors_path="";
    pstmt = conn.prepareStatement(
        "select * from ORG_HIERARCHY_PLAN where headcount_id=? and headcount_type='proposed'");
    pstmt.setString(1,headcount_id);
    System.out.println(headcount_id);
    rs = pstmt.executeQuery();
    while(rs.next()){
      node_id=rs.getString("node_id");
      ancestors_path=rs.getString("ancestors_path");
    }
    Assert.assertEquals(ancestors+","+node_id,ancestors_path);
    ic_managerID = node_id;
    System.out.println("ic managerid="+ic_managerID);
  }


  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
