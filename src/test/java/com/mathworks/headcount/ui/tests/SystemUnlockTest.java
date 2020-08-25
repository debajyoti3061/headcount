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

@RunWith(SingleBrowserPerTest.class)
public class SystemUnlockTest extends  TestBaseUI {

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
        public void SystemUnlockTest()  throws SQLException {
            LoginPage login = new LoginPage(wt);
            ListPlan listPlan = new ListPlan(wt);
            ToolStrip toolStrip = new ToolStrip(wt);

            OrgCurrent orgCurrent=login.doLogin("hrtest3","test");

            Boolean isLocked = toolStrip.isLocked();
            if(isLocked){
                toolStrip.setLockButton();
            }
            toolStrip.logout();
            login = new LoginPage(wt);
            orgCurrent=login.doLogin("hrtest6","test");
            toolStrip.gotoplanView();toolStrip.gotolistView();
            listPlan.selectRow("PROPOSED");
            validateUnLock(toolStrip);
        }

    private void validateUnLock(ToolStrip toolStrip){
        Assert.assertFalse
                (toolStrip.getProperty("Add","Mui-disabled Mui-disabled")
                || toolStrip.getProperty("Edit","Mui-disabled Mui-disabled")
                || toolStrip.getProperty("Remove","Mui-disabled Mui-disabled")
                || toolStrip.getProperty("EditGroup","Mui-disabled Mui-disabled")
                || toolStrip.getProperty("Archive","Mui-disabled Mui-disabled")
        );
    }


        @After
        public void afterThisTest() throws SQLException {
            tf.shutdown();
        }

    }


