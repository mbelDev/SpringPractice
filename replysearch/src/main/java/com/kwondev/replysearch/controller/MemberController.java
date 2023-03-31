package com.kwondev.replysearch.controller;

import com.kwondev.replysearch.dto.MemberDto;
import com.kwondev.replysearch.service.MemberService;
import java.io.IOException;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

  @Autowired
  MemberService memberService;

  @GetMapping("/join")
  public String join(Model model) {
    model.addAttribute("memberDto", new MemberDto());
    return "/member/join";
  }

  @PostMapping("/join")
  public String joinProcess(
    @Valid @ModelAttribute("memberDto") MemberDto memberDto,
    BindingResult bindingResult,
    Model model,
    RedirectAttributes redirectAttributes
  ) throws IOException {
    log.info("memberDto === {}", memberDto);
    int result = memberService.mem_join(memberDto);
    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "회원가입 되었습니다.");
      return "redirect:/member/login";
    } else {
      return null;
    }
  }

  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }
}
