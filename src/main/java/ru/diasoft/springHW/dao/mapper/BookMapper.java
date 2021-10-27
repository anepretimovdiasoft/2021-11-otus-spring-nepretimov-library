package ru.diasoft.springHW.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.diasoft.springHW.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Book.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .author_id(rs.getInt("author_id"))
                .genre_id(rs.getInt("genre_id"))
                .build();
    }
}
