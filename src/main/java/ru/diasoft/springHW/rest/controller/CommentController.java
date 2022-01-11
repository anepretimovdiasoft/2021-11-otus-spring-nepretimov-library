package ru.diasoft.springHW.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.rest.dto.CommentDto;
import ru.diasoft.springHW.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/newComment")
    public CommentDto createNewComment(
            @RequestParam String content,
            @RequestParam int bookId
    ) {

        Comment comment = commentService.insert(content, bookId);

        return CommentDto.toDto(comment);
    }

    @GetMapping("/getAllComments")
    public List<CommentDto> getAllComments() {

        return commentService
                .getAll()
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/updateCommentById")
    public void updateCommentById(
            @RequestParam int id,
            @RequestParam String content
    ) {

        commentService.update(id, content);
    }

    @DeleteMapping("/deleteCommentById")
    public void deleteCommentById(@RequestParam int id) {

        commentService.deleteById(id);
    }

    @GetMapping("/getCommentsByBookId")
    public List<CommentDto> getCommentsByBookId(@RequestParam int id) {

        return commentService
                .getByBookId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}
