package ru.diasoft.springHW.service;

import ru.diasoft.springHW.domain.Book;

import java.util.List;

public interface BookService {

    void insert(String nameBook,
                String nameGenre,
                String nameAuthor);

    void update(int id,
                String nameBook,
                String nameGenre,
                String nameAuthor);

    List<Book> getAll();

    Book getById(int id);

    Book getByName(String name);

    void deleteById(int id);
}
