package com.mathworks.headcount.api.tests;

import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.HeadcountModel;
import org.apache.http.client.methods.HttpPatch;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class UpdateManagertoICTest extends TestBase{
  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  public String cookie;

  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
  }

  @Test
  public void updateProposedManagertoICtest() throws IOException, InterruptedException {

    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + headcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);

    headcount = common.setManagertoIC(headcount,"QUE20I");

    Common.patchrequest.setEntity(common.setEntity(headcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println(Common.responsestring);
    Assertions.assertEquals(200, Common.responsecode);

    headcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);
    Thread.sleep(3000);

    Assertions.assertTrue(headcount.getNodeId().contains("PROPOSED"));
    Assertions.assertNull(headcount.getManagedSupervisoryOrgName());
  }
}
