package com.kwondev.demo.dto;

public class MemberDto {

  private String userID;
  private String userPW;
  private String userNM;
  private String userHP;
  private String userEM;
  private int userZIP;
  private String userAD;
  private String userIcon;
  private String userIconReal;

  @Override
  public String toString() {
    return (
      "{" +
      " userID='" +
      getUserID() +
      "'" +
      ", userPW='" +
      getUserPW() +
      "'" +
      ", userNM='" +
      getUserNM() +
      "'" +
      ", userHP='" +
      getUserHP() +
      "'" +
      ", userEM='" +
      getUserEM() +
      "'" +
      ", userZIP='" +
      getUserZIP() +
      "'" +
      ", userAD='" +
      getUserAD() +
      "'" +
      ", userIcon='" +
      getUserIcon() +
      "'" +
      ", userIconReal='" +
      getUserIconReal() +
      "'" +
      "}"
    );
  }

  public String getUserID() {
    return this.userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getUserPW() {
    return this.userPW;
  }

  public void setUserPW(String userPW) {
    this.userPW = userPW;
  }

  public String getUserNM() {
    return this.userNM;
  }

  public void setUserNM(String userNM) {
    this.userNM = userNM;
  }

  public String getUserHP() {
    return this.userHP;
  }

  public void setUserHP(String userHP) {
    this.userHP = userHP;
  }

  public String getUserEM() {
    return this.userEM;
  }

  public void setUserEM(String userEM) {
    this.userEM = userEM;
  }

  public int getUserZIP() {
    return this.userZIP;
  }

  public void setUserZIP(int userZIP) {
    this.userZIP = userZIP;
  }

  public String getUserAD() {
    return this.userAD;
  }

  public void setUserAD(String userAD) {
    this.userAD = userAD;
  }

  public String getUserIcon() {
    return this.userIcon;
  }

  public void setUserIcon(String userIcon) {
    this.userIcon = userIcon;
  }

  public String getUserIconReal() {
    return this.userIconReal;
  }

  public void setUserIconReal(String userIconReal) {
    this.userIconReal = userIconReal;
  }

  public MemberDto(
    String userID,
    String userPW,
    String userNM,
    String userHP,
    String userEM,
    int userZIP,
    String userAD,
    String userIcon,
    String userIconReal
  ) {
    this.userID = userID;
    this.userPW = userPW;
    this.userNM = userNM;
    this.userHP = userHP;
    this.userEM = userEM;
    this.userZIP = userZIP;
    this.userAD = userAD;
    this.userIcon = userIcon;
    this.userIconReal = userIconReal;
  }

  public MemberDto() {
    super();
  }
}
