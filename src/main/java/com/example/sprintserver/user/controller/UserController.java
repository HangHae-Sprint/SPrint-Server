package com.example.sprintserver.user.controller;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.user.dto.LoginRequestDto;
import com.example.sprintserver.user.dto.SignupRequestDto;
import com.example.sprintserver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @ResponseBody
    @PostMapping("/register")
    public Message signup(@Valid @RequestBody SignupRequestDto signupRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getDefaultMessage());
            }
            System.out.println(sb);
            return new Message(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        return userService.signup(signupRequestDto);
    }

    @ResponseBody
    @PostMapping("/login")
    public Message login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Message userExceptionHandler(Exception e) {
        return new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
