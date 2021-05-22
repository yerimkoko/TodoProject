package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.board.Board;
import com.jojoldu.book.springboot.domain.board.BoardRepository;
import com.jojoldu.book.springboot.dto.BoardResponseDto;
import com.jojoldu.book.springboot.dto.BoardSaveRequestDto;
import com.jojoldu.book.springboot.dto.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto dto) {
        return boardRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public BoardResponseDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        return new BoardResponseDto(board);
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        boardRepository.delete(board);
    }

    @Transactional
    public void update(Long id, BoardUpdateDto dto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        board.update(dto.getContent(), dto.getTitle());
    }

}
