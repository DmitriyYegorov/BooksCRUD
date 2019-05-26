package org.dima.app.controller;

import org.dima.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.dima.app.enitity.Book;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/addNew")
    public String addForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBookForm";
    }

    @RequestMapping(value = "/addingBook", method = RequestMethod.POST)
    public String addingBook(@ModelAttribute("book") Book book, BindingResult result) {
        boolean error = checkFields(book, result);
        if (error) {
            return "addBookForm";
        } else {
            bookService.addBook(book);
            return "success";
        }
    }

    @RequestMapping(value = "/updateForm")
    public String updateForm(@RequestParam("bookId") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "updateBook";
    }

    @RequestMapping(value = "/updatingBook", method = RequestMethod.POST)
    public String updatingUser(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "success";
    }

    @RequestMapping(value = "/success")
    public String success() {
        return "success";
    }

    public boolean checkFields(Book book, BindingResult result) {
        boolean error = false;

        if (book.getName().isEmpty()) {
            result.rejectValue("name", "error.name");
            error = true;
        }

        if (book.getAuthor().isEmpty()) {
            result.rejectValue("author", "error.author");
            error = true;
        }

        if (book.getYear() == 0) {
            result.rejectValue("year", "error.year");
            error = true;
        }

        if (book.getGenre().isEmpty()) {
            result.rejectValue("genre", "error.genre");
            error = true;
        }
        return error;
    }
}
