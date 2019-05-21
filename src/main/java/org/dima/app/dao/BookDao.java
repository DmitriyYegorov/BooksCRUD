package org.dima.app.dao;

import org.dima.app.enitity.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();
}
