package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.domain.Book;

import javax.persistence.*;
import java.util.List;

@Repository
public class BookDaoJPA implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

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

        EntityGraph<?> entityGraph = entityManager.getEntityGraph("books-entity-graph");
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);

        return query.getResultList();
    }

    @Override
    public Book getById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Book getByName(String name) {

        EntityGraph<?> entityGraph = entityManager.getEntityGraph("books-entity-graph");
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b " +
                "WHERE b.name=:name", Book.class);
        query.setParameter("name", name);
        query.setHint("javax.persistence.fetchgraph", entityGraph);

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
