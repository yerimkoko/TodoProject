package com.jojoldu.book.springboot.controller;

import com.jojoldu.book.springboot.dto.BoardSaveRequestDto;
import com.jojoldu.book.springboot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto dto) {
        return boardService.save(dto);
    }



}
