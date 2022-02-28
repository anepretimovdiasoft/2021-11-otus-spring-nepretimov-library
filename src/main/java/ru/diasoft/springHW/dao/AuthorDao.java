package ru.diasoft.springHW.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.springHW.domain.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {

    Author findByName(String name);
}
