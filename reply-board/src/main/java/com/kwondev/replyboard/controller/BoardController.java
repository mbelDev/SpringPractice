package com.kwondev.replyboard.controller;

import com.kwondev.replyboard.dto.BoardDto;
import com.kwondev.replyboard.dto.ReplysDto;
import com.kwondev.replyboard.service.BoardServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardServiceImpl boardService;

  @GetMapping("/list")
  public String list(Model model) {
    ArrayList<BoardDto> boardList = boardService.getPostList();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view(Model model, int postNo) {
    BoardDto boardDto = boardService.getPost(postNo);
    List<ReplysDto> replysList = boardService.getReplys(postNo);
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
  public String writtingReply(
    Model model,
    @RequestParam Map<String, String> map
  ) {
    int result = 0;
    int postNo = Integer.parseInt(map.get("postNo"));
    result = boardService.insertReply(map);
    //여기서 덧글을 DB에 비동기로 넘기고 JSON이든 뭐든 BODY에 실어서 돌려주면
    //거기서 비동기로 다시 읽어야하는데.
    BoardDto boardDto = boardService.getPost(postNo);
    List<ReplysDto> replysList = boardService.getReplys(postNo);
    model.addAttribute("boardDto", boardDto);
    model.addAttribute("replys", replysList);
    String target = "/board/view :: #reply-container";
    return target;
  }
}
