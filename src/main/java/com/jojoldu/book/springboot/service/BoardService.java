package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.board.BoardRepository;
import com.jojoldu.book.springboot.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto dto){
        return boardRepository.save(dto.toEntity()).getId();
    }
}
