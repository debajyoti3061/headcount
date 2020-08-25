package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.SupervisoryOrgModel;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class UpdateSupervisoryOrgTest extends TestBase {
  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  public String cookie;

  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
  }

  @Test
  public void updatesupOrgtest() throws IOException {

    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.patchrequest = new HttpPatch(baseURI + "/v1/supervisoryorgs/"+supervisoryOrg.getId()+"?updateCounts=true");

    common.setHeaderCookie(Common.patchrequest,cookie);
    Common.patchrequest.setEntity(setEntity(supervisoryOrg,mapper));

    restClient.executePatch(Common.patchrequest);
    System.out.println(Common.responsestring);
    Assertions.assertEquals(200, Common.responsecode);
    ObjectMapper mapper = new ObjectMapper();
    supervisoryOrg = mapper.readValue(Common.responsestring.toString(), SupervisoryOrgModel.class);
    //return supervisoryOrg;
  }



  private HttpEntity setEntity(SupervisoryOrgModel supervisoryOrg, ObjectMapper mapper) throws UnsupportedEncodingException, JsonProcessingException {
    String json = mapper.writeValueAsString(supervisoryOrg);
    System.out.println("Request:\n" + json);
    return new StringEntity(json);
  }
}
