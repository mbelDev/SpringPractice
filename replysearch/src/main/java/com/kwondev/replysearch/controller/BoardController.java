package com.kwondev.replysearch.controller;

import com.kwondev.replysearch.dto.BoardDto;
import com.kwondev.replysearch.dto.PageDto;
import com.kwondev.replysearch.dto.ReplysDto;
import com.kwondev.replysearch.service.BoardServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardServiceImpl boardService;

  @GetMapping("/list")
  public String list(
    Model model,
    String category,
    String searchTxt,
    Integer page
  ) {
    if (page == null) {
      page = 1;
    }
    PageDto pageInfo = new PageDto(
      page,
      boardService.getPostTotal(category, searchTxt)
    );
    log.info("pageInfo === {}", pageInfo);
    ArrayList<BoardDto> boardList = boardService.getBoardPage(
      category,
      searchTxt,
      pageInfo
    );
    model.addAttribute("boardList", boardList);
    model.addAttribute("pageInfo", pageInfo);
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
    log.info("boardDto (1) === {}", boardDto);
    boardService.insertPost(boardDto);
    return "redirect:/board/list";
  }

  @PostMapping("/writeReply")
  public String writtingReply(
    Model model,
    @RequestParam Map<String, String> map
  ) {
    //여기서 덧글을 DB에 비동기로 넘기고 JSON이든 뭐든 BODY에 실어서 돌려주면
    //거기서 비동기로 다시 읽어야하는데.
    int postNo = Integer.parseInt(map.get("postNo"));
    int result = boardService.insertReply(map);
    BoardDto boardDto = boardService.getPost(postNo);
    List<ReplysDto> replysList = boardService.getReplys(postNo);
    model.addAttribute("boardDto", boardDto);
    model.addAttribute("replys", replysList);
    // 리다이렉트 테스트. 왜냐면 콘트롤러가 너무 복잡함.
    String target = "/board/view :: #reply-container";
    return target;
  }

  @PostMapping("/upload")
  @ResponseBody
  public Map<String, Object> uploadIMG(MultipartFile uploadFile) {
    log.info("========get File======");
    Map<String, Object> map = new HashMap<>();
    String result = boardService.upload(uploadFile);
    map.put("fileUrl", result);
    return map;
  }

  @DeleteMapping("deleteReply")
  public String deleteReply(
    @RequestParam Map<String, String> map,
    RedirectAttributes resp,
    Model model
  ) {
    int postNo = Integer.parseInt(map.get("postNo"));
    int replyNo = Integer.parseInt(map.get("replyNo"));
    int result = boardService.deleteReplys(replyNo);
    String msg = "";
    if (result > 0) {
      msg = "덧글이 삭제되었습니다.";
    } else {
      msg = "삭제에 실패했습니다. 잠시 후 다시 시도해 주세요.";
    }
    resp.addFlashAttribute("msg", msg);
    List<ReplysDto> replysList = boardService.getReplys(postNo);
    model.addAttribute("replys", replysList);
    return "/board/view :: #reply-container";
  }
}
