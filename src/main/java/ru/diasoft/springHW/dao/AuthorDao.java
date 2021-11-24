package ru.diasoft.springHW.dao;

import ru.diasoft.springHW.domain.Author;

import java.util.List;

public interface AuthorDao {

    Author insert(Author author);

    void update(Author author);

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String name);

    void deleteById(int id);
}
