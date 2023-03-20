package com.kwondev.ch01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

  private int postNO;
  private String postCteg;
  private String psotTitle;
  private String postAuth;
  private String postPW;
  private String postCont;
  private String postDate;
}
