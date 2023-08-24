package com.board.web.service;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.entity.BoardEntity;
import com.board.web.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardEntity save(BoardSaveRequest request) {
        return boardRepository.save(getBoardEntity(request));
    }

    @Override
    public BoardEntity get(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException("Not Found This Board..")
        );
    }

    @Override
    @Transactional
    public BoardEntity update(Long boardId, BoardUpdateRequest request) {
        BoardEntity entity = get(boardId);
        updateBoardEntity(entity, request);
        return boardRepository.save(entity);
    }

    private BoardEntity getBoardEntity(BoardSaveRequest request) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        return entity;
    }

    private void updateBoardEntity(BoardEntity entity, BoardUpdateRequest request) {
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
    }

}
