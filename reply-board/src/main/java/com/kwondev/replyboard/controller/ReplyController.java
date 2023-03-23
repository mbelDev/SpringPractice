package com.kwondev.replyboard.controller;

import com.kwondev.replyboard.dto.ReplysDto;
import com.kwondev.replyboard.service.ReplysService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/reply")
@Slf4j
public class ReplyController {

  @Autowired
  ReplysService replysService;

  @GetMapping("/reply")
  public List<ReplysDto> getReplys(int postNo) {
    List<ReplysDto> replys = replysService.getReplys(postNo);
    return replys;
  }
}
