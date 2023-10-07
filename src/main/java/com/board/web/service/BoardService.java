package com.board.web.service;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    BoardEntity save(BoardSaveRequest request);

    BoardEntity get(String boardId);

    List<BoardEntity> getList();

    BoardEntity update(String boardId, BoardUpdateRequest request);
}
