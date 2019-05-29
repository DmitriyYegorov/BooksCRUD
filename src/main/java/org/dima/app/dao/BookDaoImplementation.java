package org.dima.app.dao;

import org.dima.app.enitity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImplementation implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book order by Id", Book.class).list();
        return books;
    }
}
