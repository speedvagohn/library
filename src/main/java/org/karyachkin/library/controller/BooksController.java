package org.karyachkin.library.controller;

import org.karyachkin.dao.BookDaoImpl;
import org.karyachkin.dao.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        model.addAttribute("newBook", new Book());
        return("/books/newBook");
    }

    @PostMapping()
    public String create(@ModelAttribute("newBook") @Valid Book newBook, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ("books/newBook");
        }

        bookDao.save(newBook);
        return("redirect:/");
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookDao.findById(id));
        return("books/edit");
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book updatedBook, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return ("books/edit");
        }

        bookDao.update(id, updatedBook);
        return("redirect:/");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDao.deleteById(id);
        return("redirect:/");
    }
}
