package ru.diasoft.springHW.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.dao.mapper.AuthorMapper;
import ru.diasoft.springHW.domain.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJDBC implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public void insert(Author author) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", author.getName());

        jdbc.update("INSERT INTO author (name) VALUES (:name)", param);
    }

    @Override
    public void update(Author author) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", author.getId());
        param.put("name", author.getName());

        jdbc.update("UPDATE author SET name=:name WHERE id=:id", param);
    }

    @Override
    public List<Author> getAll() {

        return jdbc.query(
                "SELECT * FROM author",
                new AuthorMapper()
        );
    }

    @Override
    public Author getById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        return jdbc.queryForObject(
                "SELECT * FROM author WHERE id=:id",
                param,
                new AuthorMapper()
        );
    }

    @Override
    public Author getByName(String name) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);

        return jdbc.queryForObject(
                "SELECT * FROM author WHERE name=:name",
                param,
                new AuthorMapper());
    }

    @Override
    public void deleteById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        jdbc.update("DELETE FROM author WHERE id=:id", param);
    }
}
