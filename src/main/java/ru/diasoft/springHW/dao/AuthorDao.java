package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.diasoft.springHW.domain.Author;

@RepositoryRestResource(path = "author")
public interface AuthorDao extends JpaRepository<Author, Integer> {

    @RestResource(path = "name")
    Author findByName(String name);
}
