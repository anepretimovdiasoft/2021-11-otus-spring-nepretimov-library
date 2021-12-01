package ru.diasoft.springHW.service;

import ru.diasoft.springHW.domain.Author;

import java.util.List;

public interface AuthorService {

    void insert(String name);

    void update(int id, String newNameAuthor);

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String nameAuthor);

    void deleteById(int id);
}
