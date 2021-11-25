package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.domain.Genre;

import javax.persistence.*;
import java.util.List;

@Repository
public class GenreDaoJPA implements GenreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre insert(Genre genre) throws NoResultException {

        if (genre.getId() == 0) {
            entityManager.persist(genre);
            return genre; // persist изменит genre на вставленного (у него появится id)
        } else
            return entityManager.merge(genre);
    }

    @Override
    public void update(Genre genre) {

        Query query = entityManager.createQuery("UPDATE Genre g " +
                "SET g.name=:name " +
                "WHERE g.id=:id");
        query.setParameter("id", genre.getId());
        query.setParameter("name", genre.getName());

        query.executeUpdate();
    }

    @Override
    public List<Genre> getAll() {

        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g", Genre.class);

        return query.getResultList();
    }

    @Override
    public Genre getById(int id) {

        return entityManager.find(Genre.class, id);
    }

    @Override
    public Genre getByName(String name) {

        try {
            TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g " +
                    "WHERE g.name=:name", Genre.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        }catch (NoResultException exception){

            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("DELETE FROM Genre g " +
                "WHERE g.id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
