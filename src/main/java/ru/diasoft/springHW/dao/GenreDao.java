package ru.diasoft.springHW.dao;

import ru.diasoft.springHW.domain.Genre;

import java.util.List;

public interface GenreDao {

    void insert(Genre genre);

    void update(Genre genre);

    List<Genre> getAll();

    Genre getById(int id);

    Genre getByName(String name);

    void deleteById(int id);
}
