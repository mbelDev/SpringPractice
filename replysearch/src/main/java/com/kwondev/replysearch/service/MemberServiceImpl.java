package com.kwondev.replysearch.service;

import com.kwondev.replysearch.dao.MemberDao;
import com.kwondev.replysearch.dto.MemberDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Value("${file.path}")
  private String uploadFolder;

  public int mem_join(MemberDto memberDto) {
    UUID uuid = UUID.randomUUID();
    // form에서 전달된 파일에서 이름을 추출함
    String userIconPath = memberDto.getUserIconFile().getOriginalFilename();
    // 중복 방지를 위해 새 이름을 전달
    String userIconReal = uuid + "_" + userIconPath;
    log.info("userIcon === {}", userIconPath);
    log.info("userIconReal === {}", userIconReal);

    Path imgFilePath = Paths.get(uploadFolder + userIconReal); // C:\tempStorage
    //저장되는 경로
    memberDto.setUserIconPath(userIconPath);
    memberDto.setUserIconReal(imgFilePath.toString());
    try {
      Files.write(imgFilePath, memberDto.getUserIconFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    int result = memberDao.mem_join(memberDto);
    return result;
  }
}
