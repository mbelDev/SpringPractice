package com.kwondev.replysearch.controller;

import com.kwondev.replysearch.dto.ReplysDto;
import com.kwondev.replysearch.service.ReplysServiceImpl;
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
