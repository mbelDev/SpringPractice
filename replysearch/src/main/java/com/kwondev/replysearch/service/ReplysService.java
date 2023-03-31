package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dto.ReplysDto;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReplysService {
  List<ReplysDto> getReplys(int postNo);

  int getMaxRegroup();

  int insertReply(@RequestParam Map<String, String> map);

  int deleteReplys(int replyNo);
}
