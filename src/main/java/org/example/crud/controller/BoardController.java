package org.example.crud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.crud.data.dto.BoardDTO;
import org.example.crud.data.dto.PageRequestDTO;
import org.example.crud.data.dto.PageResultDTO;
import org.example.crud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    String index(PageRequestDTO pageRequestDTO, Model model) {
        log.info(pageRequestDTO);

        PageResultDTO<BoardDTO> result = boardService.getAllBoards(pageRequestDTO);
        log.info(result);

        model.addAttribute("result", result);

        return "board/index";
    }

    @GetMapping("/create")
    void create() {}

    @PostMapping("/create")
    String create(@Valid BoardDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            log.info(result.toString());
            return "redirect:/board/create";
        }

        boardService.createBoard(dto);

        return "redirect:/board";
    }

    @GetMapping(value = {"/read", "/modify"})
    void read(int bno, Model model) {
        BoardDTO board = boardService.getBoard(bno);

        model.addAttribute("board", board);
    }

    @PostMapping("/modify")
    String modify(@Valid BoardDTO dto) {
        boolean result = boardService.modifyBoard(dto);

        log.info("modify result: {}", result);
        return "redirect:/board/read?bno=${dto.bno}";
    }

    @PostMapping("/delete")
    String delete(int bno) {
        boardService.deleteBoard(bno);

        return "redirect:/board";
    }

}
