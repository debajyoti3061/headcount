package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.HeadcountModel;
import org.apache.http.client.methods.HttpPatch;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class UpdateICtoManagerExistingOrgTest extends TestBase {
  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  public String cookie;

  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
  }

  @Test
  public void updateICtoManagerExistingOrgtest() throws IOException {

    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + headcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);

    headcount = common.setManagerJobcode(headcount,supervisoryOrg,"QUE40S");

    headcount.setAncestorsPath(headcount.getSupervisoryOrg().getId()+","+headcount.getNodeId());

    Common.patchrequest.setEntity(common.setEntity(headcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println(Common.responsestring);

    Assertions.assertEquals(200, Common.responsecode);

    ObjectMapper mapper = new ObjectMapper();
    headcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

    Assertions.assertTrue(headcount.getNodeId().contains("SUP_PROP"));
    Assertions.assertTrue(headcount.getManagedSupervisoryOrgName().contains("Manages PROPOSED"));
  }
}