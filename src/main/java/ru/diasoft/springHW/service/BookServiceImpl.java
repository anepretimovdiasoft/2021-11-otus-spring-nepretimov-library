package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.AuthorDao;
import ru.diasoft.springHW.dao.BookDao;
import ru.diasoft.springHW.dao.GenreDao;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Genre;
import ru.diasoft.springHW.util.StringShellUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final GenreDao genreDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Override
    @Transactional
    public void insert(String nameBook,
                       String nameGenre,
                       String nameAuthor) {


        nameBook = StringShellUtil.stringNameNormalFormat(nameBook);
        nameAuthor = StringShellUtil.stringNameNormalFormat(nameAuthor);
        nameGenre = StringShellUtil.stringNameNormalFormat(nameGenre);

        //на скок адекватно делать так? не придумал иначе
        Author author = authorDao.getByName(nameAuthor);
        if (author == null) {
            author = Author.builder()
                    .name(nameAuthor)
                    .build();
        }

        Genre genre = genreDao.getByName(nameGenre);
        if (genre == null){
            genre = Genre.builder()
                    .name(nameGenre)
                    .build();
        }

        Book book = Book.builder()
                .name(nameBook)
                .author(author)
                .genre(genre)
                .build();

        bookDao.insert(book);
    }


    @Override
    @Transactional
    public void update(int id,
                       String nameBook,
                       String nameGenre,
                       String nameAuthor) {

        nameBook = StringShellUtil.stringNameNormalFormat(nameBook);

        Book book = Book.builder()
                .id(id)
                .name(nameBook)
                .author(authorService.getByName(nameAuthor))
                .genre(genreService.getByName(nameGenre))
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

    @Transactional
    @Override
    public void deleteById(int id) {

        bookDao.deleteById(id);
    }
}
