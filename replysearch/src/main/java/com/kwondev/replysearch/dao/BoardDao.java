package com.kwondev.replysearch.dao;

import com.kwondev.replysearch.dto.BoardDto;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
  public ArrayList<BoardDto> getPostList();

  public ArrayList<BoardDto> getPostList(HashMap<String, Object> map);

  public ArrayList<BoardDto> getBoardPage(HashMap<String, Object> map);

  public BoardDto getPost(int postNo);

  public int getPostTotal(String category, String searchTxt);

  public String checkPW(int postNo); // 수정 삭제시 필요

  public void insertPost(BoardDto boardDto);

  public void updateHits(int postNo);

  public void updatePost(BoardDto boardDto); // modify post 에서 요구

  public void deletePost(int postNo, String postPW);
}
