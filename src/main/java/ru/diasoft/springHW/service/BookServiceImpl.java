package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diasoft.springHW.dao.AuthorDao;
import ru.diasoft.springHW.dao.BookDao;
import ru.diasoft.springHW.dao.GenreDao;
import ru.diasoft.springHW.domain.Book;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final GenreDao genreDao;
    private final BookDao bookDao;
    private final AuthorService authorService;

    @Override
    public void insert(String nameBook,
                       String nameGenre,
                       String firstName,
                       String thirdName,
                       String secondName) {

        Book book = Book.builder()
                .name(nameBook)
                //.author_id(authorService.getByName(firstName, thirdName, secondName).getId())
                //.genre_id(genreDao.getByName(nameGenre).getId())
                .build();

        bookDao.insert(book);
    }

    @Override
    public void update(int id,
                       String nameBook,
                       String nameGenre,
                       String firstName,
                       String thirdName,
                       String secondName) {

        Book book = Book.builder()
                .id(id)
                .name(nameBook)
                //.author_id(authorService.getByName(firstName, thirdName, secondName).getId())
                //.genre_id(genreDao.getByName(nameGenre).getId())
                .build();

        bookDao.update(book);
    }

    @Override
    public List<Book> getAll() {

        return bookDao.getAll();
    }

    @Override
    public Book getById(int id) {

        return bookDao.getById(id);
    }

    @Override
    public Book getByName(String name) {

        return bookDao.getByName(name);
    }

    @Override
    public void deleteById(int id) {

        bookDao.deleteById(id);
    }
}
