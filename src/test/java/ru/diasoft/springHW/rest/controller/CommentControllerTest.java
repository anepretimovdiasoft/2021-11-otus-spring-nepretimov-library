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
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.rest.dto.CommentDto;
import ru.diasoft.springHW.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(CommentController.class)
@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CommentService commentService;

    public static final String COMMENT_CONTENT_1 = "commentContent1";
    public static final Comment COMMENT1 = new Comment(1, COMMENT_CONTENT_1, null);
    public static final List<Comment> COMMENTS = List.of(COMMENT1);

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldCreateNewComment() throws Exception {

        given(commentService.insert(COMMENT_CONTENT_1, 1)).willReturn(COMMENT1);

        CommentDto expectedResult = CommentDto.toDto(COMMENT1);

        mvc.perform(post("/comment")
                        .param("content", COMMENT_CONTENT_1)
                        .param("bookId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldGetAllComments() throws Exception {

        given(commentService.getAll()).willReturn(COMMENTS);

        List<CommentDto> expectedResult = COMMENTS.stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());

        mvc.perform(get("/comment"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldUpdateCommentById() throws Exception {

        mvc.perform(post("/comment/1/content")
                        .param("content", COMMENT_CONTENT_1))
                .andExpect(status().isOk());

        verify(commentService, times(1)).update(1, COMMENT_CONTENT_1);
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldDeleteCommentById() throws Exception {

        mvc.perform(delete("/comment/" + 1))
                .andExpect(status().isOk());

        verify(commentService, times(1)).deleteById(1);
    }

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )
    @Test
    void shouldGetCommentsByBookId() {


    }
}