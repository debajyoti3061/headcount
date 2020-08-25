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
import java.util.ArrayList;
import java.util.Arrays;


@RunWith(SingleBrowserPerTest.class)
public class GroupByTest extends TestBaseUI{
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
    }

    @Test
    public void GroupByListPlan()  throws SQLException {
        LoginPage login = new LoginPage(wt);
        ListPlan listplan = new ListPlan(wt);
        OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
        ToolStrip toolStrip=new ToolStrip(wt);
        toolStrip.gotolistView();
        toolStrip.gotoplanView();
        listplan.selectAColumnAndSetRowGroups("type");
        validateRowGroups(listplan);
    }

    @Test
    public void GroupByListCurrent()  throws SQLException {
        LoginPage login = new LoginPage(wt);
        ListPlan listplan = new ListPlan(wt);
        OrgCurrent orgCurrent=login.doLogin("hrtest6","test");
        ToolStrip toolStrip=new ToolStrip(wt);
        toolStrip.gotolistView();
        toolStrip.gotocurrentView();
        listplan.selectAColumnAndSetRowGroups("type");
        validateRowGroups(listplan);
    }
    private void validateRowGroups(ListPlan listplan){

       Assert.assertTrue(listplan.singleLevelGroupValidation(new ArrayList<>(Arrays.asList(new String[]{"PROPOSED", "REQ","STAFF","ARCHIVED"}))));

    }

    @After
    public void afterThisTest() throws SQLException {
        tf.shutdown();
    }

}
