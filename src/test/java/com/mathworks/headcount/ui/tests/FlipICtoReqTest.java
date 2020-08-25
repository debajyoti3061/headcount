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
public class FlipICtoReqTest extends TestBaseUI{
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
  public void flipICtoReqTest() throws InterruptedException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest3",dbconfig.getProperty("adminPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.selectManager("Fairbanks, Jessica (US, Quality Engineering)");
    toolStrip.gotoplanView();
    //icID="PROPOSED_2304";
    //node_id="PROPOSED_2304";
    OrgPlan orgPlan = new OrgPlan(wt);
    orgPlan.selectRow(node_id);
    toolStrip.flip();
    validatenewReq();
  }

  private void validatenewReq() {
  }

  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}

