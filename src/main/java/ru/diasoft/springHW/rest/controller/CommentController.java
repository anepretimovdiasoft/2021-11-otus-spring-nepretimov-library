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

    @PostMapping("/comment")
    public CommentDto createNewComment(
            @RequestParam String content,
            @RequestParam int bookId
    ) {

        Comment comment = commentService.insert(content, bookId);

        return CommentDto.toDto(comment);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments() {

        return commentService
                .getAll()
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment/{id}/content")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String content
    ) {

        commentService.update(id, content);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteCommentById(@PathVariable int id) {

        commentService.deleteById(id);
    }

    @GetMapping("/book/{id}/comment")
    public List<CommentDto> getCommentsByBookId(@PathVariable int id) {

        return commentService
                .getByBookId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}
