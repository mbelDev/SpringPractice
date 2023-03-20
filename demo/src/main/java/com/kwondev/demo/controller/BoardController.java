package com.kwondev.demo.controller;

import com.kwondev.demo.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @GetMapping("/list")
  public String list(BoardDto boardDto) {
    System.out.println(boardDto.toString());
    log.info("name", boardDto);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view() {
    return "/board/view";
  }
}
