package com.mathworks.headcount.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.internal.headcount.model.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Common {

  public static HttpPost postrequest;
  public static HttpPut putrequest;
  public static HttpGet getrequest;
  public static HttpDelete deleterequest;
  public static HttpPatch patchrequest;
  public static HttpResponse response;
  public static int responsecode;


  public static HttpResponse getResponse() {
    return response;
  }

  public static void setResponse(HttpResponse response) {
    Common.response = response;
  }

  public static StringEntity params;
  public static Object responsestring;



  public StringEntity setEntity(HeadcountModel headcount, ObjectMapper mapper) throws IOException {
    String json = mapper.writeValueAsString(headcount);
    System.out.println("Request:\n" + json);
    return new StringEntity(json);
  }
  public StringEntity setEntity(List<HeadcountModel> headcount, ObjectMapper mapper) throws IOException {
    String json = mapper.writeValueAsString(headcount);
    System.out.println("Request:\n" + json);
    return new StringEntity(json);
  }

  public HeadcountModel addProposed(HeadcountModel headcount){
    headcount.setType("PROPOSED");
    headcount.setPlanData(true);
    headcount.setStatus(new HeadcountStatusModel());
    headcount.getStatus().setName("Active");

    headcount.setLocation(new LocationModel());
    headcount.getLocation().setId(19);
    headcount.getLocation().setName("US-Natick");
    headcount.getLocation().setCountry("US");

    headcount.setDepartment(new DepartmentModel("1510", "Quality Engineering"));

    headcount.setProductGroup(new ProductGroupModel());
    headcount.getProductGroup().setName(null);

    headcount.setReportsTo(new HeadcountManagerModel());
    headcount.getReportsTo().setType("STAFF");
    headcount.getReportsTo().setId(2590);
    headcount.getReportsTo().setName("Jessica Fairbanks");

    headcount.setSupervisoryOrg(new SupervisoryOrgModel());
    headcount.setSupervisoryOrg(new SupervisoryOrgModel());
    headcount.getSupervisoryOrg().setManagerId(2590);
    headcount.getSupervisoryOrg().setId("SUP_2590");
    headcount.getSupervisoryOrg().setName("EPS and LTC QE");
    headcount.getSupervisoryOrg().setParentSupervisoryOrgId("SUP_927");
    return headcount;
  }

  public HeadcountModel setICJobcode(HeadcountModel headcount){
    headcount.setDirectReports(0);
    headcount.setJobCode("QUE20I");
    headcount.setTotalAdds(0);
    headcount.setTotalReqs(0);
    headcount.setTotalVpDeferred(0);
    headcount.setTotalVpOther(0);
    headcount.setTotalVpRequested(0);
    return headcount;
  }

  public HeadcountModel setManagerJobcode(HeadcountModel headcount, SupervisoryOrgModel supervisoryOrg, String jobCode){
    headcount.setManagedSupervisoryOrgId(supervisoryOrg.getId());
    headcount.setJobCode(jobCode);
    //headcount.setRoleDesc(null);
    return headcount;
  }

  public HeadcountModel setManagertoIC(HeadcountModel headcount, String jobCode) {
    headcount.setManagedSupervisoryOrgId(null);
    headcount.setJobCode(jobCode);
    headcount.setRoleDesc(null);
    return  headcount;
  }

  public void setHeaderCookie(HttpRequestBase request, String cookie) {
    String cookieHeader = "inside-login=" + cookie;
    request.addHeader("Cookie", cookieHeader);
    request.addHeader("Content-Type", "application/json");
  }




  public String createsupOrg(HeadcountModel headcount, Date date, SimpleDateFormat formatter) throws UnsupportedEncodingException {
    String json = "{" +
        "\"managerId\":" + headcount.getId() + ",\n" +
        "\"managerName\": \"" + headcount.getName() + "\",\n" +
        "\"managerType\": \"PROPOSED\",\n" +
        "\"name\": \"Manages " + headcount.getName() +":"+ formatter.format(date) + "\",\n" +
        "\"parentSupervisoryOrgId\":\""+headcount.getSupervisoryOrg().getId()+"\",\n" +
        "\"planData\": true" +
        "}";
    System.out.println("Request "+ json);

    return json;
  }
}
