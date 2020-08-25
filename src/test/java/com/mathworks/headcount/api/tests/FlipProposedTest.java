package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.HeadcountModel;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipProposedTest extends TestBase {


  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  public String cookie;


  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest3"), "UTF-8");
  }

  @Test
  public void flipICtest() throws  IOException {
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/reqs");
    common.setHeaderCookie(Common.postrequest,cookie);
    List<HeadcountModel> newIC = new ArrayList<>();
    newIC.add(newICheadcount);
    Common.postrequest.setEntity(common.setEntity(newIC,mapper));
    restClient.executePost(Common.postrequest);
    System.out.println("Response:\n" + Common.responsestring);
    Assertions.assertEquals(200, Common.responsecode);
    newICheadcount = getHeadcount(baseURI, newICheadcount,cookie,mapper);
  }

  private HeadcountModel getHeadcount(String baseURI, HeadcountModel hc, String cookie, ObjectMapper mapper) throws IOException {
    Common.getrequest = new HttpGet(baseURI+"v1/headcounts/PROPOSED/"+hc.getId()+"?phase=plan&view=list");
    common.setHeaderCookie(Common.getrequest,cookie);
    restClient.executeGet(Common.getrequest);
    hc = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);
    return hc;
  }

  @Test
  public void flipManagertest() throws  IOException {
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/reqs");
    common.setHeaderCookie(Common.postrequest,cookie);
    List<HeadcountModel> newMrg = new ArrayList<>();
    newMrg.add(newManagerheadcount);
    Common.postrequest.setEntity(common.setEntity(newMrg,mapper));
    restClient.executePost(Common.postrequest);
    Assertions.assertEquals(200, Common.responsecode);
    newManagerheadcount = getHeadcount(baseURI, newManagerheadcount,cookie,mapper);
  }



  @AfterEach
  public void shutdown() throws SQLException {
    // dbUtil.close_dbconnection();
  }
}
