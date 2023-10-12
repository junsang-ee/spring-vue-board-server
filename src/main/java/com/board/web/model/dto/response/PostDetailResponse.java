package com.board.web.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class PostDetailResponse {
    private String postId;
    private String title;
    private String writer;
    private Instant createdAt;
}
