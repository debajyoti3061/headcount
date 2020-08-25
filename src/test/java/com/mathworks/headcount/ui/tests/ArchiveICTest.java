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
import java.util.*;

@RunWith(SingleBrowserPerTest.class)
public class ArchiveICTest extends TestBaseUI{
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
  public void archive1ICTest()  throws SQLException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6",dbconfig.getProperty("managerPassword"));
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    toolStrip.gotolistView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectRow(icID); // get name of the previously added row
    toolStrip.archive();
    validateArchivedIC();
  }

  @Test
  public void archiveMultipleICTest()  throws SQLException {
    LoginPage login = new LoginPage(wt);
    OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
    ToolStrip toolStrip = new ToolStrip(wt);
    toolStrip.gotoplanView();
    toolStrip.gotolistView();
    ListPlan listPlan = new ListPlan(wt);
    listPlan.selectMultiRows(new ArrayList<>(Arrays.asList(new String[]{"proposed1", "proposed2"})));
    toolStrip.archive();
    validateArchivedIC();
  }

  private void validateArchivedIC() {
  }

  @After
  public void afterThisTest() throws SQLException {
    close_dbconnection();
    tf.shutdown();
  }
}
