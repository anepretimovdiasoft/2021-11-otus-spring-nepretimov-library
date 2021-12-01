package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.BookDao;
import ru.diasoft.springHW.dao.CommentDao;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.util.StringShellUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final BookDao bookDao;

    @Override
    @Transactional
    public void insert(String content, String bookName) {

        Book book = bookDao.getByName(StringShellUtil.stringNameNormalFormat(bookName));

        Comment comment = Comment.builder()
                .content(content)
                .book(book)
                .build();

        commentDao.insert(comment);
    }

    @Override
    public List<Comment> getAll() {

        return commentDao.getAll();
    }

    @Override
    public Comment getById(int id) {

        return commentDao.getById(id);
    }

    @Override
    @Transactional
    public void update(int id, String content) {

        Comment comment = Comment.builder()
                .id(id)
                .content(content)
                .build();

        commentDao.update(comment);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        commentDao.deleteById(id);
    }
}
