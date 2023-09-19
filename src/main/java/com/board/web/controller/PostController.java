package com.board.web.controller;

import com.board.web.model.dto.request.ReplySaveRequest;
import com.board.web.model.entity.ReplyEntity;
import com.board.web.service.PostService;
import com.board.web.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostController {

    private final ReplyService replyService;

    @PostMapping("/{postId}/reply")
    public ReplyEntity saveReply(@RequestBody ReplySaveRequest request,
                                 @PathVariable String postId) {
        return replyService.save(request, postId);
    }
}
