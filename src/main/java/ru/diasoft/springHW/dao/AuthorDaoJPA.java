package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.domain.Author;

import javax.persistence.*;
import java.util.List;


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
    public Author getByName(String name) throws NoResultException {

        try {
            TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a " +
                    "WHERE a.name=:name", Author.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        } catch (NoResultException exception) {

            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("DELETE FROM Author a " +
                "WHERE a.id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
