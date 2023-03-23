package com.kwondev.replyboard.dao;

import com.kwondev.replyboard.dto.ReplysDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplysDao {
  List<ReplysDto> getReplys(int postNo);

  int getMaxRegroup();

  int insertReply(ReplysDto replysDto);

  int deleteReplys(int replyNo);
}
