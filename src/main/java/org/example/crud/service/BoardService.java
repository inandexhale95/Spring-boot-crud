package org.example.crud.service;

import org.example.crud.data.dto.BoardDTO;
import org.example.crud.data.dto.PageRequestDTO;
import org.example.crud.data.dto.PageResultDTO;
import org.example.crud.data.entity.Board;

import java.util.List;

public interface BoardService {
    boolean createBoard(BoardDTO dto);
    BoardDTO getBoard(int bno);
    PageResultDTO<BoardDTO> getAllBoards(PageRequestDTO pageRequestDTO);
    int getAllBoardsCount(PageRequestDTO pageRequestDTO);
    boolean modifyBoard(BoardDTO dto);
    boolean deleteBoard(int bno);

    default Board dtoToEntity(BoardDTO dto) {
        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .createDate(dto.getCreateDate())
                .build();
    }

    default BoardDTO entityToDto(Board entity) {
        return BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createDate(entity.getCreateDate())
                .build();
    }
}
