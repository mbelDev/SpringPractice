package com.kwondev.replysearch.dao;

import com.kwondev.replysearch.dto.ReplysDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplysDao {
  List<ReplysDto> getReplys(int postNo);

  int getMaxRegroup();

  int insertReply(ReplysDto replysDto);

  int deleteReply(int replyNo);
}
