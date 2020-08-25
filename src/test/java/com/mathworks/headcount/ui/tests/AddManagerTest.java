package com.mathworks.headcount.ui.tests;

import com.mathworks.headcount.ui.pages.*;
import com.mathworks.test.tools.mwhtmlguitest.TesterFactory;
import com.mathworks.test.tools.mwhtmlguitest.WindowTester;
import com.mathworks.test.tools.mwwebguitesttools.browsersupport.SupportedBrowser;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.BeforeBrowserSession;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.SingleBrowserPerTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

@RunWith(SingleBrowserPerTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddManagerTest extends TestBaseUI{
  private static TesterFactory tf;
  private static WindowTester wt;
  String managesGrp="manages "+getCurrentTime();

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
  public void addManager1NewGrpTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    AddModal addModal = toolStrip.addProposed();
    managerName="Proposed Manager"+getCurrentTime();
    addModal.addProposed(managerName,"role1","Jessica Fairbanks","EPS and LTC QE (Jessica Fairbanks, SUP_2590)","QUE30S",true,true,managesGrp,"US_Natick","Quality Engineering");
    addModal.save();
    Thread.sleep(4000);
    validateManagerAdd();
  }

  private void validateManagerAdd() throws SQLException {
    OrgPlan orgPlan=new OrgPlan(wt);
    String ancestors ="SUP_MATHWORKS,SUP_195,SUP_172,SUP_462,SUP_927,SUP_2590";
    String node_id="";
    String ancestors_path="";
    pstmt = conn.prepareStatement(
            "select top 1 * from ORG_HIERARCHY_PLAN where headcount_type=? order by headcount_id desc");
    pstmt.setString(1,"Proposed");
    rs = pstmt.executeQuery();
    while(rs.next()){
      node_id=rs.getString("node_id");
      ancestors_path=rs.getString("ancestors_path");
    }

    Assert.assertTrue(orgPlan.headcountManagerExists(node_id));
    Assert.assertEquals(ancestors+","+node_id,ancestors_path);
    managerID = node_id;
    System.out.println("headcountid ="+headcount_id);
    System.out.println("managerid=" +managerID);
  }

  @Ignore
  @Test
  public void addManager2ExistingGrpTest() throws SQLException, InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    AddModal addModal = toolStrip.addProposed();
    managerName="Proposed Manager"+getCurrentTime();
    addModal.addProposed(managerName,"role1","Jessica Fairbanks","EPS and LTC QE (Jessica Fairbanks, SUP_2590)","QUE30S",true,false,managesGrp,"US_Natick","Quality Engineering");
    addModal.save();
    validateManagerAdd();
  }


  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
