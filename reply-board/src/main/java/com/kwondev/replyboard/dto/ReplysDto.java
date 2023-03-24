package com.kwondev.replyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReplysDto {

  private int postNo;
  private int replyNo;
  private String replyAuth;
  private String replyPW;
  private String replyCont;
  private String replyDate;
  private int regroup;
  private int relevel;
  private int restep;
  private int available;
}
