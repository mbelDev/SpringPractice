package com.kwondev.ch01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

  private String userID;
  private String userPW;
  private String userNM;
  private String userEM;
  private String userHP;
  private int userZIP;
  private String userAD;
  private String userIcon;
  private String userIconReal;
}
