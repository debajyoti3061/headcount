package com.mathworks.headcount.ui.tests;

import com.mathworks.headcount.ui.pages.*;
import com.mathworks.test.tools.mwhtmlguitest.ElementTester;
import com.mathworks.test.tools.mwhtmlguitest.TesterFactory;
import com.mathworks.test.tools.mwhtmlguitest.WindowTester;
import com.mathworks.test.tools.mwwebguitesttools.browsersupport.SupportedBrowser;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.BeforeBrowserSession;
import com.mathworks.test.tools.mwwebguitesttools.junitextensions.SingleBrowserPerTest;
import org.junit.*;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.*;

import static com.mathworks.headcount.ui.tests.TestBaseUI.TESTURL;
public class FilterTest extends TestBaseUI{
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
    public void FilterTest()  throws SQLException {
        LoginPage login = new LoginPage(wt);
        ListPlan listplan = new ListPlan(wt);
        ToolStrip toolStrip = new ToolStrip(wt);

        OrgCurrent orgCurrent=login.doLogin("hrtest3","test");


    }

    private void validateLock(ToolStrip toolStrip){


    }

    @After
    public void afterThisTest() throws SQLException {
        tf.shutdown();
    }

}
