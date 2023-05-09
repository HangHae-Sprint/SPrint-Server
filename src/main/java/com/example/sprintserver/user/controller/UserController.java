package com.example.sprintserver.user.controller;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.user.dto.LoginRequestDto;
import com.example.sprintserver.user.dto.SignupRequestDto;
import com.example.sprintserver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @ResponseBody
    @PostMapping("/register")
    public Message signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    @ResponseBody
    @PostMapping("/login")
    public Message login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);
    }

}
