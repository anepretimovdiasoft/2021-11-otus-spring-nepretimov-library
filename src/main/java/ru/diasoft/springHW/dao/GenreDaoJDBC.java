package ru.diasoft.springHW.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.dao.mapper.GenreMapper;
import ru.diasoft.springHW.domain.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GenreDaoJDBC implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public void insert(Genre genre) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", genre.getName());

        jdbc.update("INSERT INTO genre (name) VALUES (:name)", param);
    }

    @Override
    public void update(Genre genre) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", genre.getId());
        param.put("name", genre.getName());

        jdbc.update("UPDATE genre SET name=:name WHERE id=:id", param);
    }

    @Override
    public List<Genre> getAll() {

        return jdbc.query(
                "SELECT * FROM genre",
                new GenreMapper()
        );
    }

    @Override
    public Genre getById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        return jdbc.queryForObject(
                "SELECT * FROM genre WHERE id=:id",
                param,
                new GenreMapper()
        );
    }

    @Override
    public Genre getByName(String name) {

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);

        return jdbc.queryForObject(
                "SELECT * FROM genre WHERE name=:name",
                param,
                new GenreMapper());
    }

    @Override
    public void deleteById(int id) {

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);

        jdbc.update("DELETE FROM genre WHERE id=:id", param);
    }
}
