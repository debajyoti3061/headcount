package com.mathworks.headcount.api.tests;

import com.mathworks.headcount.api.utils.Common;
import com.mathworks.headcount.api.utils.HttpRestClient;
import com.mathworks.internal.headcount.model.*;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditManagerReportsToTest extends TestBase {

  CreatelogincookieTest cl = new CreatelogincookieTest();
  HttpRestClient restClient = new HttpRestClient();
  Common common = new Common();
  CreateSupervisoryOrgTest createSupOrgTest;

  SupervisoryOrgModel managesSupOrg;
  public String cookie;


  @BeforeEach
  public void setup() throws IOException, SQLException {
    cookie = URLEncoder.encode(cl.createLoginCookietest("hrtest6"), "UTF-8");
    //System.out.println(cookie);
  }

  @Test
  public void editManagerAdd_ReportsTotest() throws SQLException, IOException {
    String baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/headcounts?phase=plan");
    common.setHeaderCookie(Common.postrequest,cookie);

    requestData = new HeadcountModel();
    requestData = common.addProposed(requestData);

    Common.postrequest.setEntity(common.setEntity(requestData, mapper));
    restClient.executePost(Common.postrequest);

    System.out.println("Response:\n" + Common.responsestring);
    Assertions.assertEquals(201, Common.responsecode);
    newManagerheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yy HH:mm");
    //baseURI = "https://inside-apps-test2.mathworks.com/headcount/api";
    Common.postrequest = new HttpPost(baseURI + "/v1/supervisoryorgs");
    common.setHeaderCookie(Common.postrequest,cookie);

    String json = common.createsupOrg(newManagerheadcount,date,formatter);
    StringEntity entity = new StringEntity(json);
    Common.postrequest.setEntity(entity);
    restClient.executePost(Common.postrequest);
    System.out.println(Common.responsestring);
    Assertions.assertEquals(201, Common.responsecode);

    managesSupOrg = mapper.readValue(Common.responsestring.toString(), SupervisoryOrgModel.class);

    newManagerheadcount = common.setManagerJobcode(newManagerheadcount,managesSupOrg,"QUE30S");
    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + newManagerheadcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);

    Common.patchrequest.setEntity(common.setEntity(newManagerheadcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println(Common.responsestring);

    Assertions.assertEquals(200, Common.responsecode);


    newManagerheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

    Common.patchrequest = new HttpPatch(baseURI + "/v1/headcounts/PROPOSED/" + newManagerheadcount.getId() + "?phase=plan&updateCounts=false");
    common.setHeaderCookie(Common.patchrequest,cookie);

    newManagerheadcount.setReportsTo(new HeadcountManagerModel());
    newManagerheadcount.getReportsTo().setName(headcount.getName());
    newManagerheadcount.getReportsTo().setId(headcount.getId());
    newManagerheadcount.getReportsTo().setType("PROPOSED");

    newManagerheadcount.setSupervisoryOrg(new SupervisoryOrgModel());
    newManagerheadcount.getSupervisoryOrg().setName(supervisoryOrg.getName());
    newManagerheadcount.getSupervisoryOrg().setId(supervisoryOrg.getId());
    newManagerheadcount.getSupervisoryOrg().setManagerId(supervisoryOrg.getManagerId());
    newManagerheadcount.getSupervisoryOrg().setManagerName(supervisoryOrg.getManagerName());
    newManagerheadcount.getSupervisoryOrg().setManagerType(supervisoryOrg.getManagerType());
    newManagerheadcount.getSupervisoryOrg().setParentSupervisoryOrgId(supervisoryOrg.getParentSupervisoryOrgId());
    newManagerheadcount.getSupervisoryOrg().setPlanData(true);


    Common.patchrequest.setEntity(common.setEntity(newManagerheadcount,mapper));
    restClient.executePatch(Common.patchrequest);
    System.out.println("Response"+Common.responsestring);
    newManagerheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);
    Assertions.assertEquals(200, Common.responsecode);

    newManagerheadcount = mapper.readValue(Common.responsestring.toString(), HeadcountModel.class);

  }
}
