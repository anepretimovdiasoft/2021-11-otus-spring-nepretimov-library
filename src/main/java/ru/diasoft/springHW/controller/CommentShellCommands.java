package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.CommentService;
import ru.diasoft.springHW.service.CommentServiceImpl;

@ShellComponent
@RequiredArgsConstructor
public class CommentShellCommands {

    private final CommentService commentService;

    @ShellMethod(value = "add comment", key = {"ac", "addComment"})
    public void addGenre(@ShellOption String content, @ShellOption String nameBook) {

        commentService.insert(content, nameBook);
    }

    @ShellMethod(value = "get comments", key = {"gc", "getComments"})
    public void getComments() {

        System.out.println(commentService.getAll());
    }

}
