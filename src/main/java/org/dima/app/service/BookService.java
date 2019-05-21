package org.dima.app.service;

import org.dima.app.enitity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();
}
