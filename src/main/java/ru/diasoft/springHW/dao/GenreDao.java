package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.springHW.domain.Genre;

public interface GenreDao extends JpaRepository<Genre, Integer> {

    Genre findByName(String name);
}
