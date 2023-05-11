package com.example.sprintserver.sprintlike.controller;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.common.security.UserDetailsImpl;
import com.example.sprintserver.sprintlike.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/sprint/{sprintId}")
    public Message postLike(@PathVariable Long sprintId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return likeService.sprintLike(sprintId, userDetails.getUser());
    }
}