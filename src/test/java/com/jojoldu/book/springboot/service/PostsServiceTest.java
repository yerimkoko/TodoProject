package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("gochi97@naver.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when: 실제 테스트 할 것
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void Dto데이터가_posts테이블에서_삭제된다() {
        // given
        Posts posts = Posts.builder()
                .content("content")
                .title("title")
                .build();
        postsRepository.save(posts);

        // when
        postsService.delete(posts.getId());

        // then
        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList).isEmpty(); // hasSize(0) 와 같다!
    }

    @Test
    public void 데이터가_posts테이블에서_수정된다() {
        //given
        Posts posts = Posts.builder()
                .content("content")
                .title("title")
                .build();
        postsRepository.save(posts);

        PostsUpdateRequestDto dto = PostsUpdateRequestDto.builder()
                .content("새벽코딩")
                .title("승호나라")
                .build();

        // when
        postsService.update(posts.getId(), dto);

        // then
        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList).hasSize(1);
        assertThat(postsList.get(0).getContent()).isEqualTo(dto.getContent());
        assertThat(postsList.get(0).getTitle()).isEqualTo(dto.getTitle());
    }
}