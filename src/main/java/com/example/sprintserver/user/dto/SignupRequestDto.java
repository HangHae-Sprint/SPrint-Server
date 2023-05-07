package com.example.sprintserver.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SignupRequestDto {

//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z]).{4,10}$",
//            message = "아이디는 4-10자 알파벳 소문자, 숫자로 작성해주세요.")
    private String username;

//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+|<>?:{}])(?=\\S+$).{8,15}$",
//            message = "비밀번호는 8-15자 알파벳 대소문자, 숫자, 특수문자로 작성해주세요.")
    private String password;

    private String nickname;

//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
//            message = "이메일 형식이 올바지르 않습니다.")
    private String email;
}
