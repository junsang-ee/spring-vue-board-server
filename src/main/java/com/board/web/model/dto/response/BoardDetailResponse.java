package com.board.web.model.dto.response;

import com.board.web.constants.BoardActivationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class BoardDetailResponse {
    private String boardId;
    private String name;
}
