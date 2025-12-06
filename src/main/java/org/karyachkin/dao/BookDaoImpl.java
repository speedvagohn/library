package org.karyachkin.dao;

import org.karyachkin.dao.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books ORDER BY id", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book findById(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(Book newBook) {
        jdbcTemplate.update("INSERT INTO books VALUES(nextval('books_id_seq'), ?, ?, ?, ?, ?)",
                newBook.getTitle(), newBook.getAuthor(), newBook.getPublishYear(),
                newBook.getReadingStatus(), newBook.getGenre());
    }

    @Override
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE books SET title = ?, author = ?, publish_year = ?," +
                " reading_status = ?, genre = ? WHERE id = ?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getPublishYear(),
                updatedBook.getReadingStatus(), updatedBook.getGenre(), id);
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);

    }

    @Override
    public List<Book> search(String searchTerm) {
        // Поиск по title ИЛИ author
        String sql = "SELECT * FROM books WHERE " +
                "LOWER(title) LIKE LOWER(?) OR " +
                "LOWER(author) LIKE LOWER(?) " +
                "ORDER BY id";

        String searchPattern = "%" + searchTerm + "%";

        return jdbcTemplate.query(sql,
                new Object[]{searchPattern, searchPattern},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
