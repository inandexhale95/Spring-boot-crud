package org.example.crud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.crud.data.dto.BoardDTO;
import org.example.crud.data.dto.PageRequestDTO;
import org.example.crud.data.dto.PageResultDTO;
import org.example.crud.data.entity.Board;
import org.example.crud.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public boolean createBoard(BoardDTO dto) {
        Board board = dtoToEntity(dto);

        return boardMapper.insertBoard(board);
    }

    @Override
    public BoardDTO getBoard(int bno) {
        Board board = boardMapper.selectBoardById(bno)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        return entityToDto(board);
    }

    @Override
    public PageResultDTO<BoardDTO> getAllBoards(PageRequestDTO pageRequestDTO) {

        List<BoardDTO> dtoList = boardMapper.selectAllBoards(pageRequestDTO)
                .stream()
                .map(this::entityToDto)
                .toList();

        int totalCount = boardMapper.selectAllBoardsCount(pageRequestDTO);

        return new PageResultDTO<>(
                dtoList,
                totalCount,
                pageRequestDTO
        );
    }

    @Override
    public int getAllBoardsCount(PageRequestDTO pageRequestDTO) {
        return boardMapper.selectAllBoardsCount(pageRequestDTO);
    }

    @Override
    public boolean modifyBoard(BoardDTO dto) {
        getBoard(dto.getBno());

        Board board = dtoToEntity(dto);

        return boardMapper.updateBoard(board);
    }

    @Override
    public boolean deleteBoard(int bno) {
        getBoard(bno);

        return boardMapper.deleteBoardById(bno);
    }
}
