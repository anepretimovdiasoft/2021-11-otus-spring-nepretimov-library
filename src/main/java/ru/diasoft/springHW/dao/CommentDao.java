package ru.diasoft.springHW.dao;

import ru.diasoft.springHW.domain.Comment;

import java.util.List;

public interface CommentDao {

    Comment insert(Comment comment);

    void update(Comment comment);

    List<Comment> getAll();

    Comment getById(int id);

    void deleteById(int id);

}
