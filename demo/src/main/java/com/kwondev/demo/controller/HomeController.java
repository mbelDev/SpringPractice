package com.kwondev.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String home() {
    return "home"; // 파일 명. home.html 이든 homr.jsp든.
  }

  @GetMapping("/intro")
  public String intro() {
    return "intro";
  }

  @GetMapping("/work")
  public String work() {
    return "work";
  }
}
