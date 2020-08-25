package com.mathworks.headcount.ui.tests;

import java.io.FileInputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class TestBaseUI {

  protected static String TESTURL = null;
  protected static Properties env = null;
  protected static Connection conn = null;
  protected static Properties dbconfig = null;
  protected static PreparedStatement pstmt;
  protected static ResultSet rs;
  protected static Statement stmt;
  protected static String icID= null;
  protected static String managerID = null;
  protected static String ic_managerID= null;
  protected static String node_id=null;
  protected static String headcount_id=null;
  protected static String manages_sup =null;
  protected static String icName=null;
  protected static String managerName=null;

  public void initConfigurations() {
    if (dbconfig == null) {
      dbconfig = new Properties();
      try {
        FileInputStream fs = new FileInputStream("C:\\pass\\dbconfig.properties");
        dbconfig.load(fs);
      } catch (Exception e) {

        e.getMessage();
      }
    }

    if (env == null) {

      // config.prop
      env = new Properties();
      try {
        FileInputStream fs = new FileInputStream(
            System.getProperty("user.dir") + "//src//test//resources//env.properties");
        env.load(fs);
      } catch (Exception e) {

        e.getMessage();
      }
    }


  }

  /** Establishes db connection **/
  protected void init_dbconnection() throws SQLException {
    String url = env.getProperty("url");
    String dbName = env.getProperty("dbName");
    String driver = dbconfig.getProperty("driver");
    String userName = dbconfig.getProperty("userName");
    String password = dbconfig.getProperty("password");

    try {

      Class.forName(driver).newInstance();// create object of Driver
      conn = DriverManager.getConnection(url + dbName, userName, password);
        System.out.println(url+dbName);
      System.out.println("connection established");

    } catch (Exception e) {
      System.out.println("could not establish connection");
      e.printStackTrace();
    }
  }

  /** Terminates db connection **/
  protected void close_dbconnection() throws SQLException {
    try {
      conn.close();
      System.out.println("connection closed");
    } catch (Exception e) {
      System.out.println("could not close connection");
    }

  }

  public void initenv() {
    switch (env.getProperty("env")) {
      case "test1":
        TESTURL = "https://inside-apps-test1.mathworks.com/headcount/login";
        break;
      case "test2":
        TESTURL = "https://inside-apps-test2.mathworks.com/headcount/login";
        break;
      case "test3":
        TESTURL = "https://inside-apps-test3.mathworks.com/headcount/login";
        break;
      case "stage":
        TESTURL = "https://inside-apps-stage.mathworks.com/headcount/login";
        break;
      default:
        System.out.println("enter valid environment in config.property");
        break;
    }
  }

  protected String getCurrentTime(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formatDateTime = now.format(formatter);
    return formatDateTime;
  }

}
