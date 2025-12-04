package org.karyachkin.dao;

import org.karyachkin.dao.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao{
    private List<Book> books;
    private static int BOOKS_COUNT;

    {
        books = new ArrayList<>();

        books.add(new Book(++BOOKS_COUNT, "A", "Autor 1", 2020, "genre 1", "Status 1"));
        books.add(new Book(++BOOKS_COUNT, "B", "Autor 2", 2020, "genre 1", "Status 1"));
        books.add(new Book(++BOOKS_COUNT, "C", "Autor 3", 2020, "genre 1", "Status 1"));
        books.add(new Book(++BOOKS_COUNT, "D", "Autor 4", 2020, "genre 1", "Status 1"));

    }

    @Override
    public List<Book> findAll() {
            return books;
    }

    @Override
    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public void search() {

    }
}
