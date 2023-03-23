package com.kwondev.replyboard.dao;

import com.kwondev.replyboard.dto.BoardDto;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
  public ArrayList<BoardDto> getPostList();

  public BoardDto getPost(int postNo);

  public String checkPW(int postNo); // 수정 삭제시 필요

  public void insertPost(BoardDto boardDto);

  public void updateHits(int postNo);

  public void updatePost(BoardDto boardDto); // modify post 에서 요구

  public void deletePost(int postNo, String postPW);
}
