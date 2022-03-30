package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.diasoft.springHW.domain.Genre;

@RepositoryRestResource(path = "genre")
public interface GenreDao extends JpaRepository<Genre, Integer> {

    @RestResource(path = "name")
    Genre findByName(String name);
}
