package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class AuthorDaoJPA implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author insert(Author author) {

        if (author.getId() == 0) {
            entityManager.persist(author);
            return author; // persist изменит автора на вставленного (у него появится id)
        } else
            return entityManager.merge(author);
    }

    @Override
    public void update(Author author) {

        Query query = entityManager.createQuery("UPDATE Author a " +
                "SET a.name=:name " +
                "WHERE a.id=:id");
        query.setParameter("id", author.getId());
        query.setParameter("name", author.getName());

        query.executeUpdate();
    }

    @Override
    public List<Author> getAll() {

        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);

        return query.getResultList();
    }

    @Override
    public Author getById(int id) {

        return entityManager.find(Author.class, id);
    }

    @Override
    public Author getByName(String name) {

        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a " +
                "WHERE a.name=:name", Author.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("DELETE FROM Author a " +
                "WHERE a.id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
