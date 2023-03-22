package com.kwondev.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String index() {
    return "/index/index.html";
  }

  @GetMapping("/test")
  public String test() {
    return "/index/index02.html";
  }
}
