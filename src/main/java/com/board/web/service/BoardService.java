package com.board.web.service;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.entity.BoardEntity;

public interface BoardService {
    BoardEntity save(BoardSaveRequest request);

    BoardEntity get(Long boardId);

    BoardEntity update(Long boardId, BoardUpdateRequest request);
}
