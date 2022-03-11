package ru.diasoft.springHW.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.rest.dto.AuthorDto;
import ru.diasoft.springHW.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest(AuthorController.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {

    public static final int AUTHOR_ID1 = 1;
    public static final String AUTHOR_NAME_1 = "authorName1";
    public static final Author AUTHOR1 = new Author(AUTHOR_ID1, AUTHOR_NAME_1);
    public static final int AUTHOR_ID2 = 2;
    public static final String AUTHOR_NAME_2 = "authorName2";
    public static final Author AUTHOR2 = new Author(AUTHOR_ID2, AUTHOR_NAME_2);

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private AuthorService authorService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCreateNewAuthor() throws Exception {

        given(authorService.insert(AUTHOR1)).willReturn(AUTHOR1);

        AuthorDto expectedResult = AuthorDto.toDto(AUTHOR1);

        mvc.perform(post("/author").contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(expectedResult)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldGetAllAuthors() throws Exception {

        List<Author> authors = List.of(AUTHOR1, AUTHOR2);
        given(authorService.getAll()).willReturn(authors);

        List<AuthorDto> expectedResult = authors.stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());

        mvc.perform(get("/author"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldGetAuthorById() throws Exception {

        given(authorService.getById(AUTHOR_ID1)).willReturn(AUTHOR1);

        AuthorDto expectedResult = AuthorDto.toDto(AUTHOR1);

        mvc.perform(get("/author/" + AUTHOR_ID1))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldGetAuthorByName() throws Exception {

        given(authorService.getByName(AUTHOR_NAME_1)).willReturn(AUTHOR1);

        AuthorDto expectedResult = AuthorDto.toDto(AUTHOR1);

        mvc.perform(get("/author/name")
                        .param("name", String.valueOf(AUTHOR_NAME_1)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldUpdateNameById() throws Exception {

        given(authorService.update(AUTHOR_ID1, AUTHOR_NAME_1)).willReturn(AUTHOR1);

        AuthorDto expectedResult = AuthorDto.toDto(AUTHOR1);

        mvc.perform(post("/author/1/name")
                        .param("name", AUTHOR_NAME_1))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldDeleteAuthorById() throws Exception {

        mvc.perform(delete("/author/" + AUTHOR_ID1))
                .andExpect(status().isOk());

        verify(authorService, times(1)).deleteById(1);
    }
}