package ru.diasoft.springHW.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.diasoft.springHW.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Author.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }
}
