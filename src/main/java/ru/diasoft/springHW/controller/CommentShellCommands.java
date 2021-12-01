package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.CommentService;
import ru.diasoft.springHW.service.printer.PrinterCommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentShellCommands {

    private final CommentService commentService;
    private final PrinterCommentService printerCommentService;

    @ShellMethod(value = "add comment", key = {"ac", "addComment"})
    public void addComment(@ShellOption String content, @ShellOption String nameBook) {

        commentService.insert(content, nameBook);
    }

    @ShellMethod(value = "get comments", key = {"gc", "getComments"})
    public void getComments() {

        printerCommentService.getAll();
    }

    @ShellMethod(value = "get comment by id", key = {"gci", "getCommentById"})
    public void getCommentById(@ShellOption int id) {

        printerCommentService.getById(id);
    }

    @ShellMethod(value = "update comment by id", key = {"uc", "updateComment"})
    public void updateComment(@ShellOption int id,
                              @ShellOption String newContent) {

        commentService.update(id, newContent);
    }

    @ShellMethod(value = "delete comment by id", key = {"dci", "deleteCommentById"})
    public void deleteComment(@ShellOption int id) {

        commentService.deleteById(id);
    }

}
