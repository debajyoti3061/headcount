package com.mathworks.headcount.ui.tests;

import com.sun.xml.internal.ws.addressing.policy.AddressingPolicyMapConfigurator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   /* AddICTest.class,
    CommentsTest.class,
    ConfidentialNotesTest.class,
    EditLocationTest.class,
    JustificationTest.class,
    EditDepartmentTest.class,
    RoleDescriptionTest.class,
    ProductGroupTest.class,
    UserFieldsTest.class,
    ManagerPriorityTest.class,
    DirectorPriorityTest.class,
    SrDirectorPriorityTest.class,
    VpPriorityTest.class,
    DirectorReviewStatusTest.class,
    SrDirectorReviewStatusTest.class,
    VpReviewStatusTest.class,
    BudgettingApprovalStatusTest.class,
    FlipICtoReqTest.class,

    AddICTest.class,
    ArchiveICTest.class,
    //unarchive
    RemoveProposedTest.class,*/

/*    AddICTest.class,
    ICtoManagerManagesNewGrpTest.class,

    AddICTest.class,
    ICtoManagerManagesExistingGrpTest.class, //a

    AddManagerTest.class, //b
    EditManagerReportsToTest.class, //a->b
    FlipManagertoReqTest.class,*/

   // AddManagerTest.class,
   // ArchiveManagerTest.class,

    AddManagerTest.class, //x
    AddICTest.class, //y
    EditReportsToTest.class, // y->x
    FlipManagertoReqTest.class,
    FlipICtoReqTest.class

})

public class SuiteRunner {
}