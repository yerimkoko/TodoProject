package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.board.Board;
import com.jojoldu.book.springboot.domain.board.BoardRepository;
import com.jojoldu.book.springboot.dto.BoardResponseDto;
import com.jojoldu.book.springboot.dto.BoardSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @After
    public void cleanUp() {
        boardRepository.deleteAll();
    }

    @Test
    public void board에_글을_저장한다() {
        // given
        BoardSaveRequestDto dto = BoardSaveRequestDto.builder()
                .content("글을 저장합니다.")
                .title("제목")
                .build();

        // when
        boardService.save(dto);

        // then
        Board board = boardRepository.findAll().get(0);
        assertThat(board.getContent()).isEqualTo(dto.getContent());
        assertThat(board.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void board에_글을_삭제한다() {
        // given


        // when

        // then
    }

}
