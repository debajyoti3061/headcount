package com.mathworks.headcount.api.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    AddProposedTest.class,
    UpdateProposedJobCodeICtoIC.class,
    CreateSupervisoryOrgTest.class,
    UpdateICtoManagerNewOrg.class,
    UpdateManagertoICTest.class,
    UpdateSupervisoryOrgTest.class,
    UpdateICtoManagerExistingOrgTest.class,
    EditICReportsToTest.class,
    EditManagerReportsToTest.class,
    //EditReportsToNewSupOrgTest.class
    FlipProposedTest.class,
    UpdateICReqReportstoToReqTest.class,
    UpdateICReqToManagerTest.class
})

public class SuiteRunerTest {


}
