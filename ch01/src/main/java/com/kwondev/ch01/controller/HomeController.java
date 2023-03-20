package com.kwondev.ch01.controller;

import com.kwondev.ch01.model.MemberDto;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestController("/home")
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("name", "건담");
    return "/index/index";
  }

  @GetMapping("/member/list")
  public String list(Model model) {
    ArrayList<MemberDto> memberList = new ArrayList<>();
    memberList.add(
      new MemberDto(
        "gundam",
        "EFSFsaikou",
        "건담",
        "RX78@EFSF.com",
        "010-5520-5850",
        11363,
        "경기도 부천시 원미구 심곡동",
        "-",
        "-"
      )
    );
    return "/member/list";
  }

  @GetMapping("/mv")
  public ModelAndView home02() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("subject", "제목을 실어 보냅니다.");
    mav.setViewName("/index/index02");
    return mav;
  }

  @GetMapping("/intro")
  public String intro() {
    return "/intro/aboutus";
  }
  @GetMapping("/greeting")
  public String greeting() {
    return "/intro/greeting";
  }
  @GetMapping("/ideology")
  public String ideology() {
    return "/intro/ideology";
  }
  @GetMapping("/cleaners")
  public String cleaners() {
    return "/intro/cleaners";
  }
  @GetMapping("/greenflu")
  public String greenflu() {
    return "/intro/greenflu";
  }
  @GetMapping("/joe")
  public String joe() {
    return "/intro/joeferro";
  }
}
