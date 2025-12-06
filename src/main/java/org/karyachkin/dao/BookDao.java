package org.karyachkin.dao;

import org.karyachkin.dao.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public List<Book> findAll() throws SQLException;
    public Book findById(int id) throws SQLException;
    public void save(Book newBook) throws SQLException;
    public void update(int id, Book updatedBook) throws SQLException;
    public void deleteById(int id) throws SQLException;
    void search();
}
