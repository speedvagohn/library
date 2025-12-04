package org.karyachkin.dao;

import org.karyachkin.dao.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findAll();
    public Book findById(int id);
    public void save();
    public void update();
    public void deleteById();
    void search();
}
