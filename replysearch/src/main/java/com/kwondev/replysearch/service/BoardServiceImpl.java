package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dao.BoardDao;
import com.kwondev.replysearch.dao.MemberDao;
import com.kwondev.replysearch.dao.ReplysDao;
import com.kwondev.replysearch.dto.BoardDto;
import com.kwondev.replysearch.dto.PageDto;
import com.kwondev.replysearch.dto.ReplysDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService, ReplysService {

  @Autowired
  BoardDao boardDao;

  @Autowired
  ReplysDao replysDao;

  @Autowired
  MemberDao memberDao;

  public ArrayList<BoardDto> getPostList(String category, String searchTxt) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("category", category);
    map.put("searchTxt", searchTxt);
    ArrayList<BoardDto> boardList = boardDao.getPostList(map);
    log.info("==========get post list==========");
    return boardList;
  }

  public ArrayList<BoardDto> getBoardPage(
    String category,
    String searchTxt,
    PageDto pageInfo
  ) {
    int page = pageInfo.getPage();
    HashMap<String, Object> map = new HashMap<>();
    map.put("category", category);
    map.put("searchTxt", searchTxt);
    map.put("start", pageInfo.getStart());
    map.put("end", pageInfo.getEnd());
    ArrayList<BoardDto> boardList = boardDao.getBoardPage(map);
    log.info("==========get post page==========");
    return boardList;
  }

  public void insertPost(BoardDto boardDto) {
    // log.info("==========posting process==========");
    log.info("boardDto ==== {}", boardDto);
    boardDao.insertPost(boardDto);
  }

  @Value("${file.path}")
  private String uploadFolder;

  public String upload(MultipartFile uploadFile) {
    log.info("=========upload========");
    UUID uuid = UUID.randomUUID();
    String userIconPath = uploadFile.getOriginalFilename();
    String userIconReal = uuid + "_" + userIconPath;

    Path imgFilePath = Paths.get(uploadFolder + userIconReal); // C:\tempStorage
    //저장되는 경로
    try {
      Files.write(imgFilePath, uploadFile.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "/upload/" + userIconReal;
  }

  public BoardDto getPost(int postNo) {
    log.info("==========get post one==========");
    BoardDto boardDto = boardDao.getPost(postNo);
    return boardDto;
  }

  public int getPostTotal(String category, String searchTxt) {
    int result = boardDao.getPostTotal(category, searchTxt);
    return result;
  }

  public List<ReplysDto> getReplys(int postNo) {
    log.info("==========get Replys==========");
    List<ReplysDto> replyList = replysDao.getReplys(postNo);
    return replyList;
  }

  public int getMaxRegroup() {
    int result = 0;
    result = replysDao.getMaxRegroup();
    return result;
  }

  // #####################################[  reply service implement   ]##############################################

  public int insertReply(@RequestParam Map<String, String> map) {
    log.info("check map === {}", map);
    int result = 0;
    String msg = "";
    int postNo = Integer.parseInt(map.get("postNo"));
    String replyAuth = map.get("replyAuth");
    String replyCont = map.get("replyCont");

    int maxRegroup = getMaxRegroup();
    ReplysDto replysDto = new ReplysDto();
    replysDto.setPostNo(postNo);
    replysDto.setReplyAuth(replyAuth);
    replysDto.setReplyPW("replyAuth");
    replysDto.setReplyCont(replyCont);
    replysDto.setRegroup(maxRegroup);
    replysDto.setRelevel(1);
    replysDto.setRestep(1);
    log.info("replys === {}", replysDto);
    result = replysDao.insertReply(replysDto);
    if (result > 0) {
      msg = "등록되었습니다.";
    } else {
      msg = "등록에 실패했습니다.";
    }

    return result;
  }

  public int deleteReplys(int replyNo) {
    int result = 0;
    String msg = "";
    result = replysDao.deleteReply(replyNo);
    log.info("==========delete reply one==========");
    return result;
  }
  // #####################################[  member service implement   ]##############################################

  // @Override

}
