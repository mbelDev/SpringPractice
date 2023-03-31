package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dto.PageDto;

public interface PageService {
  public PageDto setData(Integer page);
  //   public PageDto setData(int page, int total, int listNum, int pageNum);
}
