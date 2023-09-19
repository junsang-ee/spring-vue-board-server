package com.board.web.service;

import com.board.web.model.dto.request.ReplySaveRequest;
import com.board.web.model.entity.PostEntity;
import com.board.web.model.entity.ReplyEntity;
import com.board.web.repository.PostRepository;
import com.board.web.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    private final PostRepository postRepository;

    private final PostService postService;

    @Transactional
    @Override
    public ReplyEntity save(ReplySaveRequest request, String postId) {
        ReplyEntity entity = new ReplyEntity();
        setReplyEntity(entity, request, postId);
        return replyRepository.save(entity);
    }

    private void setReplyEntity(ReplyEntity entity, ReplySaveRequest request, String postId) {
        entity.setContent(request.getContent());
        entity.setParentPost(postService.get(postId));
    }

}
