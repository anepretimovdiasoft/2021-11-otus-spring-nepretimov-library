package ru.diasoft.springHW.service;

import ru.diasoft.springHW.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment insert(String content, int bookId);

    List<Comment> getAll();

    Comment getById(int id);

    List<Comment> getByBookId(int id);

    void update(int id, String content);

    void deleteById(int id);
}
