package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDaoJPA implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Book insert(Book book) {

        if (book.getId() == 0) {
            entityManager.persist(book);
            return book; // persist изменит book на вставленного (у него появится id)
        } else
            return entityManager.merge(book);
    }

    @Override
    public void update(Book book) {

        Query query = entityManager.createQuery("UPDATE Book b " +
                "SET b.name=:name " +
                "WHERE b.id=:id");
        query.setParameter("id", book.getId());
        query.setParameter("name", book.getName());

        query.executeUpdate();
    }

    @Override
    public List<Book> getAll() {

        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);

        return query.getResultList();
    }

    @Override
    public Book getById(int id) {

        return entityManager.find(Book.class, id);
    }

    @Override
    public Book getByName(String name) {

        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b " +
                "WHERE b.name=:name", Book.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("DELETE FROM Book b " +
                "WHERE b.id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
