package com.board.web.service;

import com.board.web.constants.BoardActivationStatus;
import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.dto.response.BoardDetailResponse;
import com.board.web.model.entity.BoardEntity;
import com.board.web.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    public BoardEntity get(String boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("Not Found This Board..")
        );
    }

    @Override
    public List<BoardDetailResponse> getList() {
        List<BoardEntity> entities = boardRepository.findAllByStatus(
                BoardActivationStatus.NORMAL
        );
        return getBoardDetailList(entities);
    }

    @Override
    @Transactional
    public BoardEntity update(String boardId, BoardUpdateRequest request) {
        BoardEntity entity = get(boardId);
        updateBoardEntity(entity, request);
        return boardRepository.save(entity);
    }

    private BoardEntity getBoardEntity(BoardSaveRequest request) {
        BoardEntity entity = new BoardEntity();
        entity.setName(request.getName());
        return entity;
    }

    private void updateBoardEntity(BoardEntity entity, BoardUpdateRequest request) {
        entity.setName(request.getTitle());
    }

    private List<BoardDetailResponse> getBoardDetailList(List<BoardEntity> boardEntities) {
        return boardEntities.stream()
                .map(this::getBoardDetail)
                .collect(Collectors.toList());

    }

    private BoardDetailResponse getBoardDetail(BoardEntity entity) {
        return new BoardDetailResponse(
                entity.getId(),
                entity.getName()
        );
    }

}
