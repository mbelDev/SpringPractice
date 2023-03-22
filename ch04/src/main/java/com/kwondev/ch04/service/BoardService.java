package com.kwondev.ch04.service;

import com.kwondev.ch04.model.BoardDao;
import com.kwondev.ch04.model.BoardDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {

  //실질적 코드 작성
  //Controller는 연결만 한다.
  //Dao는 Dto를 조작해서 Service에 넘겨준다.

  @Autowired // 외부에서 주입해온다 의존성주입. 찾아볼 것.
  BoardDao boardDao;

  public ArrayList<BoardDto> getSelectAll() {
    ArrayList<BoardDto> boardList = boardDao.getSelectAll();
    return boardList;
  }

  public BoardDto getSelectOne(int postNo) {
    BoardDto boardDto = boardDao.getSelectOne(postNo);
    log.info("POST NO === {}" + boardDto);
    return boardDto;
  }

  public String checkPW(int postNo, String postPW) {
    boolean result = false;
    Map<String, String> map = new HashMap<String, String>();
    map.put("postNo", Integer.toString(postNo));
    map.put("postPW", postPW);
    int count = boardDao.checekPW(map);
    return result;
  }

  public void insertBoard(BoardDto boardDto) {
    boardDao.insertBoard(boardDto);
    log.info("POSTING === {}" + boardDto);
  }

  public void updateHits(int postNo) {
    boardDao.updateHits(postNo);
  }

  public void updatePost(BoardDto boardDto) {
    boardDao.updatePost(boardDto);
    log.info("UPDATE === {}" + boardDto);
  }

  public void deletePost(int postNo) {
    boardDao.deletePost(postNo);
  }
}
