package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.diasoft.springHW.domain.Book;

import java.util.List;

@RepositoryRestResource(path = "book")
public interface BookDao extends JpaRepository<Book, Integer> {

    @Override
    @EntityGraph(attributePaths = {"genre", "author", "comments"})
    List<Book> findAll();

    @RestResource(path = "name")
    Book findByName(String name);
}
