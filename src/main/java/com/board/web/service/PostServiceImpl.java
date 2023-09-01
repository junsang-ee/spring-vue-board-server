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

    @Override
    @Transactional
    public PostEntity save(PostSaveRequest request) {
        return postRepository.save(getPostEntity(request));
    }

    private PostEntity getPostEntity(PostSaveRequest request) {
        PostEntity result = new PostEntity();
        result.setTitle(request.getTitle());
        result.setContent(request.getContent());
        return result;
    }
}
