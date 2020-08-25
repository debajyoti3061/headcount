package com.mathworks.headcount.api.tests;

import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.*;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class EditICReportsToTest extends TestBase {

  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();

  public String cookie;


  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
    //System.out.println(cookie);
  }

  @Test
  public void editReportsTotest() throws SQLException, IOException {
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/headcounts?phase=plan");
    common.setHeaderCookie(Common.postrequest,cookie);

    requestData = new HeadcountModel();
    requestData = common.addProposed(requestData);
    Common.postrequest.setEntity(common.setEntity(requestData, mapper));
    restClient.executePost(Common.postrequest);
    System.out.println("Response:\n" + Common.responsestring);
    Assertions.assertEquals(201, Common.responsecode);

    newICheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + newICheadcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);
    newICheadcount = common.setICJobcode(newICheadcount);
    Common.patchrequest.setEntity(common.setEntity(newICheadcount,mapper));
    restClient.executePatch(Common.patchrequest);

    newICheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + newICheadcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);
    newICheadcount.setReportsTo(new HeadcountManagerModel());
    newICheadcount.getReportsTo().setName(headcount.getName());
    newICheadcount.getReportsTo().setId(headcount.getId());
    newICheadcount.getReportsTo().setType("PROPOSED");
    newICheadcount.setSupervisoryOrg(new SupervisoryOrgModel());
    newICheadcount.getSupervisoryOrg().setName(supervisoryOrg.getName());
    newICheadcount.getSupervisoryOrg().setId(supervisoryOrg.getId());
    newICheadcount.getSupervisoryOrg().setManagerId(supervisoryOrg.getManagerId());
    newICheadcount.getSupervisoryOrg().setManagerName(supervisoryOrg.getManagerName());
    newICheadcount.getSupervisoryOrg().setManagerType(supervisoryOrg.getManagerType());
    newICheadcount.getSupervisoryOrg().setParentSupervisoryOrgId(supervisoryOrg.getParentSupervisoryOrgId());
    newICheadcount.getSupervisoryOrg().setPlanData(true);
    Common.patchrequest.setEntity(common.setEntity(newICheadcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println("Response"+Common.responsestring);
    Assertions.assertEquals(200, Common.responsecode);

    newICheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

  }
}