package com.board.web.service;

import com.board.web.model.dto.request.PostSaveRequest;
import com.board.web.model.entity.PostEntity;

public interface PostService {
    PostEntity save(PostSaveRequest request, String boardId);

    PostEntity get(String postId);
}
