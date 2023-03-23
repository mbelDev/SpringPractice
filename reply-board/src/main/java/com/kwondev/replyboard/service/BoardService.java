package com.kwondev.replyboard.service;

import com.kwondev.replyboard.dao.BoardDao;
import com.kwondev.replyboard.dto.BoardDto;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {

  @Autowired
  BoardDao boardDao;

  public ArrayList<BoardDto> getPostList() {
    ArrayList<BoardDto> boardList = boardDao.getPostList();
    log.info("==========get post list==========");
    return boardList;
  }

  public void insertPost(BoardDto boardDto) {
    boardDao.insertPost(boardDto);
  }

  public BoardDto getPost(int postNo) {
    log.info("==========get post one==========");
    BoardDto boardDto = boardDao.getPost(postNo);
    return boardDto;
  }
}
