package org.karyachkin.library.controller;

import org.karyachkin.dao.BookDaoImpl;
import org.karyachkin.dao.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {
    @Autowired
    public BookDaoImpl bookDao;

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("books", bookDao.findAll());
        return("books/starterPage");
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDao.findById(id));
        return ("books/findById");
    }

    @GetMapping("/newBook")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return("/books/newBook");
    }

    @PostMapping()
    public String create(@ModelAttribute("newBook") Book newBook){
        bookDao.save(newBook);
        return("redirect:/");
    }
}
