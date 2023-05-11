package com.example.sprintserver.user.service;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.user.dto.LoginRequestDto;
import com.example.sprintserver.user.dto.SignupRequestDto;
import com.example.sprintserver.user.entity.User;
import com.example.sprintserver.user.jwt.JwtUtil;
import com.example.sprintserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Message signup(SignupRequestDto signupRequestDto) {

        String username = signupRequestDto.getUsername();
        String nickname = signupRequestDto.getNickname();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String email = signupRequestDto.getEmail();

        // 회원 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("사용중인 아이디입니다.");
        }

        User user = new User(username, nickname, password, email);
        userRepository.save(user);

        return new Message("회원 가입 성공", HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public Message login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(jwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername(), "ADMIN"));
        return new Message("로그인 성공", HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Message signupExceptionHandler(Exception e) {
        return new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
