package com.board.web.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDetailResponse {
    private String boardId;
    private String name;
    private int postCount;
}
