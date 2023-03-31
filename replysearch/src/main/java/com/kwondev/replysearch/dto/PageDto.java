package com.kwondev.replysearch.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageDto {

  private int page;
  private int total; // post 총 갯수
  private int pageTotal; // page 총 갯수
  private int listNum; // 각 페이지 별 보여줄 게시글 갯수
  private int pageNum; // 한 번에 보여줄 페이지 버튼 갯수
  private String category; // 현재 보여줄 게시판의 카테고리
  private int start;
  private int end;
  private int pageStart;
  private int pageEnd;
  private int pageLast;
  private int pagePre;
  private int pageNxt;

  public PageDto(int page, int total) {
    this.page = page;
    this.total = total;
    this.listNum = 10;
    this.pageNum = 10;
    this.start = (page - 1) * listNum + 1;
    this.end = start + listNum - 1;
    if (end > total) {
      end = total;
    }

    this.pageTotal = (int) (Math.ceil(total / listNum)) + 1;
    this.pageStart = (int) ((page - 1) / pageNum) * pageNum + 1;
    this.pageEnd = pageStart + pageNum - 1;
    this.pageLast = 0; // 아래쪽 페이지(pageBox)의 전체 갯수

    if (total % listNum == 0) {
      pageLast = (int) (total / listNum);
    } else {
      pageLast = (int) (total / listNum) + 1;
    }

    if (pageEnd > pageLast) {
      pageEnd = pageLast;
    } else {
      pageEnd = pageStart + listNum - 1;
    }
    this.pagePre = 0;

    this.pageNxt = 0;
    if (page - pageNum > 0) pagePre = (int) (page / pageNum) * pageNum;
    if ((int) (page - 1) / pageNum < (int) (pageTotal / pageNum)) pageNxt =
      (int) ((page + pageNum) / pageNum) * pageNum;
  }
}
