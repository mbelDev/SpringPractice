package com.kwondev.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/")
public class MemberController {

  @GetMapping("/login")
  public String login(
    @RequestParam String userID,
    @RequestParam String userPW
  ) {
    System.out.println("userID===" + userID + ", userPW===" + userPW);
    return "/member/login";
  }

  @GetMapping("/join")
  public String join() {
    return "/member/join";
  }

  @GetMapping("/list")
  public String list(@RequestParam int page) {
    System.out.println("page===" + page);
    return "/member/list";
  }

  @GetMapping("/info/{id}")
  public String info(@PathVariable("id") String userID) {
    System.out.println("id===" + userID);
    return "member/info";
  }
  // GetMapping에서 /info/id 로 적으면 id를 주소로 인식
  // 따라서 /info/{id}로 적어야 파라미터 경로값으로 인식한다.
}
