package com.kwondev.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

  @GetMapping("/list")
  public String list() {
    return "/board/list";
  }

  @GetMapping("/write")
  public String write() {
    return "board/write";
  }

  @GetMapping("/board/modify")
  public String modify() {
    return "/board/modify";
  }

  @GetMapping("/board/remove")
  public String remove() {
    return "/board/remove";
  }
}
