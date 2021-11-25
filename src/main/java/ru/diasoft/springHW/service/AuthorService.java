package ru.diasoft.springHW.service;

import ru.diasoft.springHW.domain.Author;

import java.util.List;

public interface AuthorService {

    void insert(String name);

    void update(int id, String firstName, String thirdName, String secondName);

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String firstName, String thirdName, String secondName);

    void deleteById(int id);
}
