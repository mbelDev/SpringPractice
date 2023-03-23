package com.kwondev.replyboard.controller;

import com.kwondev.replyboard.dto.BoardDto;
import com.kwondev.replyboard.dto.ReplysDto;
import com.kwondev.replyboard.service.BoardService;
import com.kwondev.replyboard.service.ReplysService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardService boardService;

  @Autowired
  ReplysService replysService;

  @GetMapping("/list")
  public String list(Model model) {
    ArrayList<BoardDto> boardList = boardService.getPostList();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view(Model model, int postNo) {
    BoardDto boardDto = boardService.getPost(postNo);
    List<ReplysDto> replysList = replysService.getReplys(postNo);
    model.addAttribute("boardDto", boardDto);
    model.addAttribute("replys", replysList);
    return "/board/view";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/write")
  public String writting(BoardDto boardDto) {
    boardService.insertPost(boardDto);
    return "redirect:/board/list";
  }

  @PostMapping("/writeReply")
  public String writtingReply(ReplysDto replysDto) {
    int maxRegroup = replysService.getMaxRegroup();
    replysDto.setRegroup(maxRegroup);
    replysDto.setRelevel(1);
    replysDto.setRestep(1);
    log.info("replys === " + replysDto);
    replysService.insertReply(replysDto);
    return "redirect:/board/list";
  }

  @GetMapping("/reply")
  public String reply(int postNo) {
    return "/board/reply";
  }
}
