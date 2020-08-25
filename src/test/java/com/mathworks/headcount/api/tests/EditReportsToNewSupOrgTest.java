package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EditReportsToNewSupOrgTest extends TestBase {

  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  HeadcountModel newICheadcount;
  SupervisoryOrgModel newsupOrg;
  public String cookie;


  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
  }

  @Test
  public void editReportsToNewSupOrgtest() throws  IOException {
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

    Common.postrequest = new HttpPost(baseURI +"/v1/supervisoryorgs");
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy HH:mm");
    supervisoryOrg.setName("Manages SUP "+formatter.format(date));
    common.setHeaderCookie(Common.postrequest,cookie);
    Common.postrequest.setEntity(setEntity(supervisoryOrg,mapper));
    restClient.executePost(Common.postrequest);
    System.out.println(Common.responsestring);
    Assertions.assertEquals(201, Common.responsecode);
    newsupOrg = mapper.readValue(Common.responsestring.toString(), SupervisoryOrgModel.class);


    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + newICheadcount.getId() + "?phase=plan");
    common.setHeaderCookie(Common.patchrequest,cookie);

    newICheadcount.setReportsTo(new HeadcountManagerModel());
    newICheadcount.getReportsTo().setName(newManagerheadcount.getName());
    newICheadcount.getReportsTo().setId(newManagerheadcount.getId());
    newICheadcount.getReportsTo().setType("PROPOSED");

    newICheadcount.setSupervisoryOrg(new SupervisoryOrgModel());
    newICheadcount.getSupervisoryOrg().setName(newsupOrg.getName());
    newICheadcount.getSupervisoryOrg().setId(newsupOrg.getId());
    newICheadcount.getSupervisoryOrg().setManagerId(newsupOrg.getManagerId());
    newICheadcount.getSupervisoryOrg().setManagerName(newsupOrg.getManagerName());
    newICheadcount.getSupervisoryOrg().setManagerType(newsupOrg.getManagerType());
    newICheadcount.getSupervisoryOrg().setParentSupervisoryOrgId(newsupOrg.getParentSupervisoryOrgId());
    newICheadcount.getSupervisoryOrg().setPlanData(true);

    Common.patchrequest.setEntity(common.setEntity(newICheadcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println("Response"+Common.responsestring);

    Assertions.assertEquals(200, Common.responsecode);



  }

  private HttpEntity setEntity(SupervisoryOrgModel supervisoryOrg, ObjectMapper mapper) throws UnsupportedEncodingException, JsonProcessingException {
    String json = mapper.writeValueAsString(supervisoryOrg);
    System.out.println("Request:\n" + json);
    return new StringEntity(json);
  }
}
