package com.mathworks.headcount.api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathworks.internal.headcount.model.HeadcountModel;
import com.mathworks.internal.headcount.model.SupervisoryOrgModel;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestBase implements java.io.Serializable {
  protected static Properties keys = null;
  ObjectMapper mapper = new ObjectMapper();
/*  public static AddProposed addProposed = null;
  public static SupervisoryOrg supOrg = null;*/
  public static HeadcountModel requestData=null;
  public static HeadcountModel headcount=null;
  public static HeadcountModel newICheadcount= null;
  public static HeadcountModel newManagerheadcount=null;
  public static SupervisoryOrgModel supervisoryOrg=null;


  private static String getDate() {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    return timeStamp;
  }

  protected static String baseURI = null;


  public void initConfigurations() {
    if (keys == null) {
      keys = new Properties();
      try {
        FileInputStream fs = new FileInputStream(
            "C://pass//dbconfig.properties");
        keys.load(fs);
      } catch (Exception e) {
        e.getMessage();
      }
    }

  }

}
