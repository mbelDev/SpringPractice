package com.kwondev.replysearch.dao;

import com.kwondev.replysearch.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  MemberDto mem_info(MemberDto memberDto);
  int mem_join(MemberDto memberDto);
  void mem_update(MemberDto memberDto);
  void mem_redraw(MemberDto memberDto);
}
