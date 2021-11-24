package ru.diasoft.springHW.dao;

import org.springframework.stereotype.Repository;
import ru.diasoft.springHW.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentDaoJPA implements CommentDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Comment insert(Comment comment) {

        if (comment.getId() == 0) {
            entityManager.persist(comment);
            return comment; // persist изменит comment на вставленного (у него появится id)
        } else
            return entityManager.merge(comment);
    }

    @Override
    public void update(Comment comment) {
        Query query = entityManager.createQuery("UPDATE Comment c " +
                "SET c.content=:content " +
                "WHERE c.id=:id");
        query.setParameter("id", comment.getId());
        query.setParameter("content", comment.getContent());

        query.executeUpdate();
    }

    @Override
    public List<Comment> getAll() {

        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c", Comment.class);

        return query.getResultList();
    }

    @Override
    public Comment getById(int id) {

        return entityManager.find(Comment.class, id);
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("DELETE FROM Comment c " +
                "WHERE a.id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
