package com.kwondev.demo.dto;

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
  private String postCTGR;
  private String postAuth;
  private String postPW;
  private String postTitle;
  private String postCont;
}
