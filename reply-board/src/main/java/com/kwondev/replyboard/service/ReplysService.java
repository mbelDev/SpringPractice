package com.kwondev.replyboard.service;

import com.kwondev.replyboard.dao.ReplysDao;
import com.kwondev.replyboard.dto.ReplysDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplysService {

  @Autowired
  ReplysDao replysDao;

  public ReplysService() {
    log.info("==========ReplyService==========");
  }

  public int insertReply(ReplysDto replysDto) {
    return replysDao.insertReply(replysDto);
  }

  public int getMaxRegroup() {
    int result = 0;
    result = replysDao.getMaxRegroup();
    return result;
  }

  public List<ReplysDto> getReplys(int postNo) {
    log.info("==========get Replys==========");
    List<ReplysDto> replyList = replysDao.getReplys(postNo);
    return replyList;
  }
}
