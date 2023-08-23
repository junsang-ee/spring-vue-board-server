package com.board.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/board")
@RestController
public class BoardController {

    @GetMapping
    public void test() {
        log.info("test http method");
    }
}
