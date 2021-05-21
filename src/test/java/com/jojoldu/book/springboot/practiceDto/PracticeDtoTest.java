package com.jojoldu.book.springboot.practiceDto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PracticeDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "yerimkoko";
        int amount = 100;

        //when
        PracticeResponseDto dto = new PracticeResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }

}
