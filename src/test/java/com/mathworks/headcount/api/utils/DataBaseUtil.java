package com.mathworks.headcount.api.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseUtil {
  public static String DB_CONFIG_FILE_PATH = "C://pass//dbconfig.properties";
  protected static Properties dbconfig = null;
  public static Properties env = null;
  public static Connection conn = null;

  /**
   * Initializes config files
   **/
  public void initConfigurations() {
    if (dbconfig == null) {
      dbconfig = new Properties();
      try {
        FileInputStream fs = new FileInputStream(DB_CONFIG_FILE_PATH);
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

  /**
   * Establishes db connection
   **/
  public void init_dbconnection() throws SQLException {
    String url = env.getProperty("url");
    String dbName = env.getProperty("dbName");
    String driver = dbconfig.getProperty("driver");
    String userName = dbconfig.getProperty("userName");
    String password = dbconfig.getProperty("password");

    try {
      Class.forName(driver).newInstance();// create object of Driver
      conn = DriverManager.getConnection(url + dbName, userName, password);
      //System.out.println("connection established");
    } catch (Exception e) {
      System.out.println("could not establish connection");
      e.printStackTrace();
    }
  }

  /**
   * Terminates db connection
   **/
  public void close_dbconnection() throws SQLException {
    try {
      conn.close();
    } catch (Exception e) {
      System.out.println("could not close connection");
    }

  }
}
