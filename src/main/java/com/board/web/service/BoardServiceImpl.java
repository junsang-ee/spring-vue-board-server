package com.board.web.service;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.entity.BoardEntity;
import com.board.web.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public BoardEntity save(BoardSaveRequest request) {
        return boardRepository.save(getBoardEntity(request));
    }

    private BoardEntity getBoardEntity(BoardSaveRequest request) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        return entity;
    }
}
