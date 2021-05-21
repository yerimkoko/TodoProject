package com.jojoldu.book.springboot.domain.board;

import com.jojoldu.book.springboot.domain.board.Board;
import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Posts> {

}
