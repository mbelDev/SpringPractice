package com.kwondev.replyboard.service;

import com.kwondev.replyboard.dto.BoardDto;
import java.util.ArrayList;

public interface BoardService {
  public ArrayList<BoardDto> getPostList();

  public void insertPost(BoardDto boardDto);

  public BoardDto getPost(int postNo);
}
