package ru.diasoft.springHW.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.dao.mapper.BookMapper;
import ru.diasoft.springHW.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoJDBC implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public void insert(Book book) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", book.getName());
        param.put("author_id", book.getAuthor_id());
        param.put("genre_id", book.getGenre_id());

        jdbc.update("INSERT INTO book (name, author_id, genre_id) " +
                "VALUES (:name, :author_id, :genre_id)", param);
    }

    @Override
    public void update(Book book) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", book.getId());
        param.put("name", book.getName());
        param.put("author_id", book.getAuthor_id());
        param.put("genre_id", book.getGenre_id());

        jdbc.update(
                "UPDATE book " +
                        "SET name=:name, author_id=:author_id, genre_id=:genre_id " +
                        "WHERE id=:id", param);
    }

    @Override
    public List<Book> getAll() {

        return jdbc.query(
                "SELECT * FROM book",
                new BookMapper()
        );
    }

    @Override
    public Book getById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        return jdbc.queryForObject(
                "SELECT * FROM book WHERE id=:id",
                param,
                new BookMapper()
        );
    }

    @Override
    public Book getByName(String name) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);

        return jdbc.queryForObject(
                "SELECT * FROM book WHERE name=:name",
                param,
                new BookMapper());
    }

    @Override
    public void deleteById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        jdbc.update("DELETE FROM book WHERE id=:id", param);
    }
}
