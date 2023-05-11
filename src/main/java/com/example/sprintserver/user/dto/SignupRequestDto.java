package com.example.sprintserver.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SignupRequestDto {

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z]).{2,15}$",
            message = "아이디는 2-15자 알파벳 소문자, 숫자로 입력해주세요.")
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z]).{2,15}$",
            message = "비밀번호는 2-15자 알파벳 소문자, 숫자로 입력해주세요.")
    private String password;

    @NotNull(message = "닉네임을 한글자 이상 입력해주세요.")
    private String nickname;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "이메일 형식이 올바르지 않습니다.")
    private String email;
}
