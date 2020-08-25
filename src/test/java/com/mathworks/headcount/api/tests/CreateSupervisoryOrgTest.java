package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.SupervisoryOrgModel;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSupervisoryOrgTest extends TestBase {
  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  public String cookie;

  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
  }

  @Test
  public void createsupOrgtest() throws IOException {
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm");
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/supervisoryorgs");
    common.setHeaderCookie(Common.postrequest,cookie);
    String json = "{" +
        "\"managerId\":" + headcount.getId() + ",\n" +
        "\"managerName\": \"" + headcount.getName() + "\",\n" +
        "\"managerType\": \"PROPOSED\",\n" +
        "\"name\": \"Manages " + headcount.getName() +":"+ formatter.format(date) + "\",\n" +
        "\"parentSupervisoryOrgId\":\""+headcount.getSupervisoryOrg().getId()+"\",\n" +
        "\"planData\": true" +
        "}";

    System.out.println("Request "+ json);
    StringEntity entity = new StringEntity(json);
    Common.postrequest.setEntity(entity);
    restClient.executePost(Common.postrequest);
    System.out.println(Common.responsestring);
    Assertions.assertEquals(201, Common.responsecode);
    ObjectMapper mapper = new ObjectMapper();
    supervisoryOrg = mapper.readValue(Common.responsestring.toString(), SupervisoryOrgModel.class);
    //return supervisoryOrg;
  }
}
