package com.example.community.service;

import com.example.community.model.entity.Board;
import com.example.community.model.entity.Comment;
import com.example.community.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    public void create(Board board, String content) {
        Comment comment = Comment.builder()
                .board(board)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
        commentRepository.save(comment);
    }
}
