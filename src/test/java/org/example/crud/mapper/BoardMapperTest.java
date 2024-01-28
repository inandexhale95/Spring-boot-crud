package org.example.crud.mapper;

import org.example.crud.data.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;


    @Test
    void insertBoard() {
        IntStream.rangeClosed(101, 300)
                .forEach(i -> {
                    Board board = Board.builder()
                            .title("BOARD TITLE..." + i)
                            .content("BOARD CONTENT..." + i)
                            .author("USER" + i)
                            .build();

                    boardMapper.insertBoard(board);
                });
    }

    @Test
    void selectBoardById() {
    }

    @Test
    void selectAllBoards() {
    }

    @Test
    void updateBoard() {
    }

    @Test
    void deleteBoardById() {
    }
}