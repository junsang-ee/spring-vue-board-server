package com.board.web.controller;

import com.board.web.model.dto.request.PostSaveRequest;
import com.board.web.model.entity.PostEntity;
import com.board.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostEntity save(@RequestBody PostSaveRequest request) {
        return postService.save(request);
    }
}
