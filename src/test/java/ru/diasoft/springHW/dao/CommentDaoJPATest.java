package ru.diasoft.springHW.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CommentDaoJPA")
@DataJpaTest
@Import({BookDaoJPA.class, GenreDaoJPA.class, AuthorDaoJPA.class, CommentDaoJPA.class})
class CommentDaoJPATest {

    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_CONTENT1 = "Нда....Я бы лучше написал";
    public static final String EXISTING_BOOK_NAME = "Ночной дозор";
    public static final int EXISTING_COMMENT_COUNT = 4;
    public static final String EXISTING_CONTENT2 = "frefregfregregre";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BookDao bookDao;

    @Test
    @DisplayName("должен вставлять комментарий")
    void insert() {

        Book book = bookDao.getById(1);

        Comment expectedComment = Comment.builder()
                .content(EXISTING_CONTENT2)
                .book(book)
                .build();

        commentDao.insert(expectedComment);

        Comment actualComment = commentDao.getById(5);

        assertThat(actualComment.getContent()).isEqualTo(expectedComment.getContent());
    }

    @Test
    @DisplayName("должен обновлять содержимое комментария по id")
    void update() {

        Comment expectedComment = Comment.builder()
                .id(EXISTING_ID1)
                .content(EXISTING_CONTENT2)
                .build();

        commentDao.update(expectedComment);

        Comment actualComment = commentDao.getById(EXISTING_ID1);

        assertThat(actualComment.getContent()).isEqualTo(expectedComment.getContent());
    }

    @Test
    @DisplayName("должен получать все комментарии")
    void getAll() {

        assertThat(commentDao.getAll().size()).isEqualTo(EXISTING_COMMENT_COUNT);
    }

    @Test
    @DisplayName("должен получать комментарий по id")
    void getById() {

        Comment expectedComment = Comment.builder()
                .id(EXISTING_ID1)
                .content(EXISTING_CONTENT1)
                .build();

        Comment actualComment = commentDao.getById(EXISTING_ID1);

        assertThat(actualComment.getId()).isEqualTo(expectedComment.getId());
        assertThat(actualComment.getContent()).isEqualTo(expectedComment.getContent());
        assertThat(actualComment.getBook().getName()).isEqualTo(EXISTING_BOOK_NAME);
    }

    @Test
    @DisplayName("должен удалять комментарий по id")
    void deleteById() {

        Comment comment = commentDao.getById(EXISTING_ID1);
        assertThat(comment).isNotNull();

        commentDao.deleteById(EXISTING_ID1);
        entityManager.detach(comment);

        comment = commentDao.getById(EXISTING_ID1);
        assertThat(comment).isNull();
    }
}