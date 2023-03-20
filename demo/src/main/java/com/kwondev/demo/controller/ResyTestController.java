package com.kwondev.demo.controller;

import com.kwondev.demo.dto.MemberDto;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResyTestController {

  // @Controller와 차이
  // @Controller는 파일로 응답을 한다. html, jsp등.(web)
  // @RestController는 Body에다 응답을 한다.(json)
  // @Controller + @ResponseBody 와 같은 역할을 한다.

  public String returnTxt() {
    return "hello";
  }

  @GetMapping("/txt01")
  public String returnJson() {
    return "{\"name\":\"mbel\"}";
  }

  @GetMapping("/txt02")
  public HashMap<String, String> returnHash() {
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("name", "mbel");
    hashMap.put("gender", "man");
    hashMap.put("tall", "m");
    return hashMap;
  }

  @GetMapping("/txt03")
  public MemberDto returnMember() {
    MemberDto memberDto = new MemberDto();
    memberDto.setUserID("gundam");
    memberDto.setUserPW("EFSFsaikou0079");
    memberDto.setUserNM("건담");
    memberDto.setUserEM("RX78@EFSF.com");
    memberDto.setUserHP("010-9545-2800");
    memberDto.setUserZIP(11363);

    return memberDto;
  }

  @GetMapping("/returnArray")
  public ArrayList returnArray() {
    ArrayList<MemberDto> arrayList = new ArrayList<>();
    MemberDto member01 = new MemberDto();
    member01.setUserID("gundam");
    member01.setUserPW("EFSFsaikou0079");
    member01.setUserNM("건담");
    member01.setUserEM("RX78@EFSF.com");
    member01.setUserHP("010-9545-2800");
    member01.setUserZIP(11363);

    arrayList.add(member01);

    MemberDto member02 = new MemberDto();
    member02.setUserID("jaku");
    member02.setUserPW("ZEONsaikou0079");
    member02.setUserNM("자쿠");
    member02.setUserEM("MS06@ZEON.com");
    member02.setUserHP("020-9545-2800");
    member02.setUserZIP(11363);

    arrayList.add(member02);

    return arrayList;
  }
}
