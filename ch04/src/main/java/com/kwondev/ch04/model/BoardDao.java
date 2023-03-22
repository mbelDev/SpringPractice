package com.kwondev.ch04.model;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
  public ArrayList<BoardDto> getSelectAll(); // board list 에서 요구

  public BoardDto getSelectOne(int postNo); // view post 에서 요구

  public String checkPW(int postNo); // 수정 삭제시 필요

  public void insertBoard(BoardDto boardDto); // write post 에서 요구

  public void updateHits(int postNo);

  public void updatePost(BoardDto boardDto); // modify post 에서 요구

  public void deletePost(int postNo);
}
