package com.jojoldu.book.springboot.practiceDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final만 생성자를 만들어준다.
public class PracticeResponseDto {

    private final String name;
    private final int amount;

}
