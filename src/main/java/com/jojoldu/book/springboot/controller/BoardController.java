package com.jojoldu.book.springboot.controller;

import com.jojoldu.book.springboot.dto.BoardResponseDto;
import com.jojoldu.book.springboot.dto.BoardSaveRequestDto;
import com.jojoldu.book.springboot.dto.BoardUpdateDto;
import com.jojoldu.book.springboot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto dto) {
        return boardService.save(dto);
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto findById (@PathVariable Long id) {
        return boardService.findById(id);
    }

    @DeleteMapping("/api/v1/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

    @PutMapping("/api/v1/board/{id}")
    public void update(@PathVariable Long id, @RequestBody BoardUpdateDto dto) {
        boardService.update(id, dto);
    }



}
