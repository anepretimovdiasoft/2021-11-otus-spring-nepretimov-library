package ru.diasoft.springHW.dao;

import ru.diasoft.springHW.domain.Book;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    void update(Book book);

    List<Book> getAll();

    Book getById(int id);

    Book getByName(String name);

    void deleteById(int id);
}
