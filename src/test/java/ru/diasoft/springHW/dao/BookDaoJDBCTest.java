package ru.diasoft.springHW.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.diasoft.springHW.domain.Book;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Класс BookDaoJDBCTest")
@JdbcTest
//@Import(BookDaoJDBC.class)
class BookDaoJDBCTest {
/*

    private static final int EXISTING_ID1 = 1;
    private static final int EXISTING_AUTHOR_COUNT = 4;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final int EXISTING_ID4 = 4;
    public static final String EXISTING_NAME1 = "Ночной дозор";
    public static final String EXISTING_NAME2 = "Лабиринты отражения";
    public static final String EXISTING_NAME3 = "Горе от ума";
    public static final String EXISTING_NAME4 = "Неукротимая планета";
    public static final int AUTHOR_ID1 = 1;
    public static final int GENRE_ID1 = 1;
    public static final int AUTHOR_ID2 = 2;
    public static final int GENRE_ID2 = 2;
    public static final int AUTHOR_ID3 = 3;
    public static final int GENRE_ID3 = 3;

    @Autowired
    BookDao dao;

    @DisplayName("должен добавлять книгу")
    @Test
    void shouldInsertBook() {

        Book expectedBook = Book.builder()
                .id(5)
                .name("qwer")
                //.author_id(AUTHOR_ID2)
                //.genre_id(GENRE_ID2)
                .build();

        dao.insert(expectedBook);
        Book actualBook = dao.getById(5);

        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @DisplayName("должен обновлять книгу")
    @Test
    void shouldUpdateBook() {

        Book expectedBook1 = Book.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                //.author_id(AUTHOR_ID2)
                //.genre_id(GENRE_ID2)
                .build();

        dao.update(expectedBook1);
        Book actualBook = dao.getById(EXISTING_ID1);

        assertThat(actualBook).isEqualTo(expectedBook1);
    }

    @DisplayName("должен возвращать все книги")
    @Test
    void shouldGetAllBooks() {

        Book expectedBook1 = Book.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                //.author_id(AUTHOR_ID1)
                //.genre_id(GENRE_ID1)
                .build();
        Book expectedBook2 = Book.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                //.author_id(AUTHOR_ID1)
                //.genre_id(GENRE_ID1)
                .build();
        Book expectedBook3 = Book.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                //.author_id(AUTHOR_ID2)
                //.genre_id(GENRE_ID2)
                .build();

        Book expectedBook4 = Book.builder()
                .id(EXISTING_ID4)
                .name(EXISTING_NAME4)
                //.author_id(AUTHOR_ID3)
                //.genre_id(GENRE_ID3)
                .build();


        assertThat(dao.getAll().size()).isEqualTo(EXISTING_AUTHOR_COUNT);
        assertThat(dao.getAll())
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2, expectedBook3, expectedBook4);

    }

    @DisplayName("должен возвращать книгу по id")
    @Test
    void shouldGetBookById() {

        Book expectedBook1 = Book.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                //.author_id(AUTHOR_ID1)
                //.genre_id(AUTHOR_ID1)
                .build();

        Book actualBook = dao.getById(EXISTING_ID1);

        assertThat(actualBook).isEqualTo(expectedBook1);
    }

    @DisplayName("должен возвращать книгу по имени")
    @Test
    void shouldGetAuthorByName() {

        Book expectedBook1 = Book.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                //.author_id(AUTHOR_ID1)
                //.genre_id(AUTHOR_ID1)
                .build();

        Book actualBook = dao.getByName(EXISTING_NAME1);

        assertThat(actualBook).isEqualTo(expectedBook1);
    }

    @DisplayName("должен удалять книгу по id")
    @Test
    void shouldDeleteBookById() {

        assertThatCode(() -> dao.getById(EXISTING_ID1)).doesNotThrowAnyException();

        dao.deleteById(EXISTING_ID1);

        assertThatThrownBy(() -> dao.getById(EXISTING_ID1))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
*/
}