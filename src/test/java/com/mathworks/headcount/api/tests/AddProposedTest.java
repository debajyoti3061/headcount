package com.mathworks.headcount.api.tests;

import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.*;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.*;

public class AddProposedTest extends TestBase {

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
  public void addProposedtest() throws SQLException, IOException {
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/headcounts?phase=plan");
    common.setHeaderCookie(Common.postrequest,cookie);

    requestData = new HeadcountModel();
    requestData = common.addProposed(requestData);

    Common.postrequest.setEntity(common.setEntity(requestData,mapper));
    restClient.executePost(Common.postrequest);


    System.out.println("Response:\n" + Common.responsestring);

    Assertions.assertEquals(201, Common.responsecode);
    headcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

  }



  @AfterEach
  public void shutdown() throws SQLException {
    // dbUtil.close_dbconnection();
  }
}
