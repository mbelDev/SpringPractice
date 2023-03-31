package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
  public int mem_join(MemberDto memberDto);
}
