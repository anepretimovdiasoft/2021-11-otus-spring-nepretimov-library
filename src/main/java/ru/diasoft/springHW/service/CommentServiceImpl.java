package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.BookDao;
import ru.diasoft.springHW.dao.CommentDao;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final BookDao bookDao;

    @Override
    public void insert(String content, String bookName) {

        Book book = bookDao.getByName(bookName.replace('#', ' '));


        Comment comment = Comment.builder()
                .content(content)
                .build();

        book.getComments().add(comment);

        bookDao.insert(book);
        //commentDao.insert(comment);
    }

    @Override
    public List<Comment> getAll() {

        return null;
    }

    @Override
    public Comment getById(int id) {

        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
