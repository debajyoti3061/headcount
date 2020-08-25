package com.mathworks.headcount.api.response;

public class InputCookie {
  public String loginId;
  public String token;
  public String firstName;

  public InputCookie(String loginId, String token, String firstName, String lastName) {
    this.loginId = loginId;
    this.token = token;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String lastName;
}
