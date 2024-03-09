package com.example.community.service;

import com.example.community.model.entity.Board;
import com.example.community.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getList() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public Board getDetail(Long id) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        return board;
    }

    public void create(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
        this.boardRepository.save(board);
    }
}
