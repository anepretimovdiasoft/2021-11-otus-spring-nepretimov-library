package ru.diasoft.springHW.service;

import ru.diasoft.springHW.domain.Comment;

import java.util.List;

public interface CommentService {
    void insert(String content, String bookName);

    List<Comment> getAll();

    Comment getById(int id);

    void update(int id, String content);

    void deleteById(int id);
}
