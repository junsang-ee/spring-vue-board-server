package com.board.web.service;

import com.board.web.model.dto.request.PostSaveRequest;
import com.board.web.model.entity.PostEntity;
import com.board.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final BoardService boardService;
    @Override
    @Transactional
    public PostEntity save(PostSaveRequest request, String boardId) {
        PostEntity entity = new PostEntity();
        setPostEntity(entity, request, boardId);
        return postRepository.save(entity);
    }

    @Override
    public PostEntity get(String postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("not found the post")
        );
    }

    private void setPostEntity(PostEntity entity, PostSaveRequest request, String boardId) {
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        entity.setParentBoard(boardService.get(boardId));
    }
}
