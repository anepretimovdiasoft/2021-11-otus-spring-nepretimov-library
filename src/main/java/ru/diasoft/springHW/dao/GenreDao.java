package ru.diasoft.springHW.dao;

import ru.diasoft.springHW.domain.Genre;

import javax.persistence.NoResultException;
import java.util.List;

public interface GenreDao {

    Genre insert(Genre genre);

    void update(Genre genre);

    List<Genre> getAll();

    Genre getById(int id);

    Genre getByName(String name);

    void deleteById(int id);
}
