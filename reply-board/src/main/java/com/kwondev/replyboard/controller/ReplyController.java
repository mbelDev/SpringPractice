package com.kwondev.replyboard.controller;

import com.kwondev.replyboard.dto.ReplysDto;
import com.kwondev.replyboard.service.ReplysServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {

  @Autowired
  ReplysServiceImpl replysService;

  @GetMapping("/reply")
  public List<ReplysDto> getReplys(int postNo) {
    List<ReplysDto> replys = replysService.getReplys(postNo);
    return replys;
  }
}
