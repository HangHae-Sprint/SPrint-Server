package com.example.sprintserver.sprintlike.controller;

import com.example.sprintserver.sprintlike.security.UserDetailsImpl;
import com.example.sprintserver.sprintlike.service.LikeService;
import com.example.sprintserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;


    @PostMapping("/api/like/{sprintId}")
    public ResponseEntity postLike(@PathVariable Long sprintId, UserDetailsImpl userDetails) {
        return likeService.sprintLike(sprintId, userDetails.getUser());
    }

}
