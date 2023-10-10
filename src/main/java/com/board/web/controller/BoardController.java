package com.board.web.controller;

import com.board.web.model.dto.request.BoardSaveRequest;
import com.board.web.model.dto.request.BoardUpdateRequest;
import com.board.web.model.dto.request.PostSaveRequest;
import com.board.web.model.dto.response.BoardDetailResponse;
import com.board.web.model.entity.BoardEntity;
import com.board.web.model.entity.PostEntity;
import com.board.web.service.BoardService;
import com.board.web.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    private final PostService postService;

    @PostMapping
    public BoardEntity save(@RequestBody BoardSaveRequest request) {
        return boardService.save(request);
    }

    @GetMapping
    public List<BoardDetailResponse> getList() {
        return boardService.getList();
    }

    @GetMapping("/{boardId}")
    public BoardEntity get(@PathVariable String boardId) {
        return boardService.get(boardId);
    }

    @PatchMapping("/{boardId}")
    public BoardEntity update(@PathVariable String boardId,
                              @RequestBody BoardUpdateRequest request) {
        return boardService.update(boardId, request);
    }

    @PostMapping("/{boardId}/post")
    public PostEntity savePost(@PathVariable String boardId,
                               @RequestBody PostSaveRequest request) {
        return postService.save(request, boardId);
    }

    @GetMapping("/{boardId}/posts")
    public List<PostEntity> getPosts(@PathVariable String boardId) {
        return null;
    }

}
