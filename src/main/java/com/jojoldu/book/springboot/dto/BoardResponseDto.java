package com.jojoldu.book.springboot.dto;

import com.jojoldu.book.springboot.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;

    public BoardResponseDto(Board entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();

    }
}
