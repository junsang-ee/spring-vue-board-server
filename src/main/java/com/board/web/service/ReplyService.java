package com.board.web.service;

import com.board.web.model.dto.request.ReplySaveRequest;
import com.board.web.model.entity.ReplyEntity;

public interface ReplyService {
    ReplyEntity save(ReplySaveRequest request, String postId);
}
