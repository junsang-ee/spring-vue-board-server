package com.board.web.controller;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.entity.BoardEntity;
import com.board.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public BoardEntity save(@RequestBody BoardSaveRequest request) {
        return boardService.save(request);
    }

    @GetMapping("/{boardId}")
    public BoardEntity get(@PathVariable Long boardId) {
        return boardService.get(boardId);
    }

    @PatchMapping("/{boardId}")
    public BoardEntity update(@PathVariable Long boardId, @RequestBody BoardUpdateRequest request) {
        return boardService.update(boardId, request);
    }

}
