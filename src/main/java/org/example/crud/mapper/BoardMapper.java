package org.example.crud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.crud.data.dto.PageRequestDTO;
import org.example.crud.data.entity.Board;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    boolean insertBoard(@Param("board") Board board);
    Optional<Board> selectBoardById(int bno);
    List<Board> selectAllBoards(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    int selectAllBoardsCount(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    boolean updateBoard(@Param("b") Board board);
    boolean deleteBoardById(int bno);
}
