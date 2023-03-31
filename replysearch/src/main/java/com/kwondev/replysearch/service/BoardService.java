package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dto.BoardDto;
import com.kwondev.replysearch.dto.PageDto;
import java.util.ArrayList;
import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
  public ArrayList<BoardDto> getPostList(String category, String searchTxt);

  public ArrayList<BoardDto> getBoardPage(
    String category,
    String searchTxt,
    PageDto page
  );

  public void insertPost(BoardDto boardDto);

  public BoardDto getPost(int postNo);

  public String upload(MultipartFile uploadFile);
}
