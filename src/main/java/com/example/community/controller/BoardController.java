package com.example.community.controller;

import com.example.community.model.entity.Board;
import com.example.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String getList(Model model) {
        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);
        return "board_list";
    }

    @GetMapping("/{boardId}")
    public String detail(Model model, @PathVariable("boardId") Long boardId) {
        Board board = this.boardService.getDetail(boardId);
        model.addAttribute("board", board);
        return "board_detail";
    }

    @GetMapping("/create")
    public String create() {
        return "board_form";
    }

    @PostMapping("/create")
    public String create(@RequestParam(value="title") String title,
                         @RequestParam(value="content") String content) {
        this.boardService.create(title, content);
        return "redirect:/board/list";
    }
}
