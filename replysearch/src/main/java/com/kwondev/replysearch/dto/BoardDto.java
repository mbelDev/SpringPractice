package com.kwondev.replysearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

  private int postNo;
  private String postAuth;
  private String postPW;
  private String postCTGR;
  private String postTitle;
  private String postCont;
  private String regDate;
  private int postHits;
}
