package com.mathworks.headcount.api.response;

public class InsideLoginCookie {
  public String authenticationDate;
  public String expirationDate;
  public String loginIdentifierType;
  public String referenceId;
  public String loginIdentifier;
  public String referenceType;
  public String source;
  public String tokenString;
  public Long id;

  public String getAuthenticationDate() {
    return authenticationDate;
  }

  public void setAuthenticationDate(String authenticationDate) {
    this.authenticationDate = authenticationDate;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getLoginIdentifierType() {
    return loginIdentifierType;
  }

  public void setLoginIdentifierType(String loginIdentifierType) {
    this.loginIdentifierType = loginIdentifierType;
  }

  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public String getLoginIdentifier() {
    return loginIdentifier;
  }

  public void setLoginIdentifier(String loginIdentifier) {
    this.loginIdentifier = loginIdentifier;
  }

  public String getReferenceType() {
    return referenceType;
  }

  public void setReferenceType(String referenceType) {
    this.referenceType = referenceType;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTokenString() {
    return tokenString;
  }

  public void setTokenString(String tokenString) {
    this.tokenString = tokenString;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
