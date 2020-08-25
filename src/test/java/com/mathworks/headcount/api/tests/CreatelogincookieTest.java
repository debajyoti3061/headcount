package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.headcount.api.response.InputCookie;
import com.mathworks.headcount.api.response.InsideLoginCookie;
import com.mathworks.headcount.api.utils.*;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatelogincookieTest extends TestBase {
  HttpRestClient restClient = new HttpRestClient();

  @BeforeEach
  public void initconfig() {
    initConfigurations();
  }

  @Test
  public String createLoginCookietest(String loggedinUser) throws IOException {

    Common.postrequest = new HttpPost("https://inside-services-test2.mathworks.com" + "/internalauthenticationws/service/login");
    Common.postrequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
    Common.postrequest.addHeader("Accept", "application/json");
    Common.postrequest.addHeader("MW_CALLER_ID", "BUSSEC");


    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("identifier", loggedinUser));
    params.add(new BasicNameValuePair("credentials", "Hello?"));
    params.add(new BasicNameValuePair("type", "LDAP"));
    params.add(new BasicNameValuePair("secure", "false"));
    Common.postrequest.setEntity(new UrlEncodedFormEntity(params));
    restClient.executePost(Common.postrequest);
    //System.out.println(Common.responsestring);
    Assertions.assertEquals(200, Common.responsecode);

    ObjectMapper mapper = new ObjectMapper();
    InsideLoginCookie cookie = mapper.readValue(Common.responsestring.toString(), InsideLoginCookie.class);

    InputCookie icookie = new InputCookie(cookie.getLoginIdentifier(), cookie.getTokenString(), "", "");
    String icookieString = mapper.writeValueAsString(icookie);
    //System.out.println(icookieString);
    return icookieString;
  }
}
