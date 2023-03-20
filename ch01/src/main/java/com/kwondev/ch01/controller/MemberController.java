package com.kwondev.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @GetMapping("/join")
    public String join(){
        return "/member/join";
    }
    @GetMapping("/login")
    public String login(){
        return "/member/login";
    }
    @GetMapping("/forgot")
    public String forgot(){
        return "/member/forgot";
    }
}
