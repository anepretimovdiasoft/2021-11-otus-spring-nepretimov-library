package ru.diasoft.springHW.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.domain.Genre;
import ru.diasoft.springHW.rest.dto.BookDto;
import ru.diasoft.springHW.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(BookController.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    public static final int AUTHOR_ID1 = 1;
    public static final String AUTHOR_NAME_1 = "authorName1";
    public static final Author AUTHOR1 = new Author(AUTHOR_ID1, AUTHOR_NAME_1);
    public static final String GENRE_NAME_1 = "genreName1";
    public static final int GENRE_ID1 = 1;
    public static final Genre GENRE1 = new Genre(GENRE_ID1, GENRE_NAME_1);
    public static final Comment COMMENT1 = new Comment(1, "commentContent1", null);
    public static final List<Comment> COMMENTS = List.of(COMMENT1);
    public static final int BOOK_ID1 = 1;
    public static final String BOOK_NAME_1 = "bookName1";
    public static final Book BOOK1 = new Book(
            BOOK_ID1,
            BOOK_NAME_1,
            COMMENTS,
            AUTHOR1,
            GENRE1
    );

    public static final int BOOK_ID2 = 2;
    public static final String BOOK_NAME_2 = "bookName2";
    public static final Book BOOK2 = new Book(
            BOOK_ID2,
            BOOK_NAME_2,
            COMMENTS,
            AUTHOR1,
            GENRE1
    );

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BookService bookService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectCreateNewBook() throws Exception {

        given(bookService.insert(BOOK_NAME_1, GENRE_NAME_1, AUTHOR_NAME_1)).willReturn(BOOK1);

        BookDto expectedResult = BookDto.toDto(BOOK1);

        mvc.perform(post("/book")
                        .param("nameBook", BOOK_NAME_1)
                        .param("nameGenre", GENRE_NAME_1)
                        .param("nameAuthor", AUTHOR_NAME_1))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectGetAllBooks() throws Exception {

        List<Book> books = List.of(BOOK1, BOOK2);
        given(bookService.getAll()).willReturn(books);

        List<BookDto> expectedResult = books.stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());

        mvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));

    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectUpdateBookById() throws Exception {

        given(bookService.update(BOOK_ID1, BOOK_NAME_1, GENRE_NAME_1, AUTHOR_NAME_1)).willReturn(BOOK1);

        BookDto expectedResult = BookDto.toDto(BOOK1);

        mvc.perform(post("/book/1/")
                        .param("newBookName", BOOK_NAME_1)
                        .param("newGenreName", GENRE_NAME_1)
                        .param("newAuthorName", AUTHOR_NAME_1))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));

    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectGetBookById() throws Exception {

        given(bookService.getById(BOOK_ID1)).willReturn(BOOK1);

        BookDto expectedResult = BookDto.toDto(BOOK1);

        mvc.perform(get("/book/" + BOOK_ID1))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectGetBookByName() throws Exception {

        given(bookService.getByName(BOOK_NAME_1)).willReturn(BOOK1);

        BookDto expectedResult = BookDto.toDto(BOOK1);

        mvc.perform(get("/book/name")
                        .param("name", String.valueOf(BOOK_NAME_1)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCorrectDeleteBookById() throws Exception {

        mvc.perform(delete("/book/" + BOOK_ID1))
                .andExpect(status().isOk());

        verify(bookService, times(1)).deleteById(1);
    }
}