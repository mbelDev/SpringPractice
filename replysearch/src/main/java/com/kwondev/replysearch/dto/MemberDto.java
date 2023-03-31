package com.kwondev.replysearch.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDto {

  private int no;

  @NotBlank(message = "필수 입력사항 입니다.") // 무조건 채워야 함.
  @Size(min = 4, max = 12, message = "아이디는 4-12글자 사이로 적어주세요.") // 글자 수 제한.
  private String userID;

  @NotBlank(message = "필수 입력사항 입니다.") // 무조건 채워야 함.
  @Email // e-mail형식을 갖춰야 함.
  //@Pattern(regexp ="정규식", message="에러 메세지") //정규식을 사용한 Valid
  private String userEM;

  @NotBlank(message = "필수 입력사항 입니다.") // 무조건 채워야 함.
  @Size(min = 4, max = 12, message = "비밀번호는 4-12글자 사이로 적어주세요.") // 글자 수 제한.
  private String userPW;

  @NotBlank(message = "필수 입력사항 입니다.") // 무조건 채워야 함.
  private String userNM;

  private MultipartFile userIconFile; // 실제 파일
  private String userIconPath; // 업로드한 파일의 이름
  private String userIconReal; // 업로드 폴더 경로 + 수정된 파일 명
}
