package com.example.community.controller;

import com.example.community.model.entity.Board;
import com.example.community.service.BoardService;
import com.example.community.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final BoardService boardService;
    private final CommentService commentService;

    @PostMapping("/create/{boardId}")
    public String createAnswer(Model model,
                               @PathVariable("boardId") Long id,
                               @RequestParam(value="content") String content) {
        Board board = this.boardService.getDetail(id);
        this.commentService.create(board, content);
        return String.format("redirect:/board/%s", id);
    }
}
