package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.springHW.domain.Book;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    @Override
    @EntityGraph(attributePaths = {"genre", "author", "comments"})
    List<Book> findAll();

    Book findByName(String name);
}
