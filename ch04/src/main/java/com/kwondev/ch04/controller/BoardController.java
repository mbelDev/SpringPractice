package com.kwondev.ch04.controller;

import com.kwondev.ch04.model.BoardDto;
import com.kwondev.ch04.service.BoardService;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

  // 결합도 관련 이슈임

  // 싱글톤 패턴으로 하나 만들어서 계속 돌려 쓴다....
  @Autowired
  BoardService boardService;

  @GetMapping("/list")
  public String list(Model model) {
    ArrayList<BoardDto> boardList = boardService.getSelectAll();
    model.addAttribute("boardList", boardList);
    log.info("boardList === {}" + boardList);
    return "/board/list";
  }

  @GetMapping("/post")
  public String post(@RequestParam Integer postNo, Model model) {
    BoardDto boardDto = boardService.getSelectOne(postNo);
    boardService.updateHits(postNo);
    model.addAttribute("boardDto", boardDto);
    return "/board/view";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/write")
  public String writeProcess(BoardDto boardDto) {
    boardService.insertBoard(boardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/modify")
  public String modify() {
    return "/board/modify";
  }

  @GetMapping("/delete")
  public String delete(Model model, int postNo) {
    model.addAttribute("postNo", postNo);
    return "/board/delete";
  }

  @PostMapping("/delete")
  public String deleteCheckPW(int postNo, String postPW) {
    boolean result = boardService.checkPW(postNo, postPW);
    if (result) {
      boardService.deletePost(postNo);
      return "/board/list";
    } else {
      return "/board/delete";
    }
  }
}
