package org.karyachkin.dao;

import org.karyachkin.dao.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublishYear(resultSet.getInt("publish_year"));
        book.setReadingStatus(resultSet.getString("reading_status"));
        book.setGenre(resultSet.getString("genre"));

        return book;
    }
}
