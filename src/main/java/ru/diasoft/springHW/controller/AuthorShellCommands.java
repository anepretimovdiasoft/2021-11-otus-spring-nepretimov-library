package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.AuthorService;
import ru.diasoft.springHW.service.printer.PrinterAuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorShellCommands {

    private final AuthorService authorService;
    private final PrinterAuthorService printerAuthorService;

    @ShellMethod(value = "add author", key = {"aa", "addAuthor"})
    public void addAuthor(@ShellOption String name) {

        authorService.insert(name);
    }

    @ShellMethod(value = "get all authors", key = {"ga", "getAuthors"})
    public void getAuthors() {

        printerAuthorService.getAll();
    }

    @ShellMethod(value = "get authors by id", key = {"gai", "getAuthorById"})
    public void getAuthor(@ShellOption int id) {

        printerAuthorService.getById(id);
    }

    @ShellMethod(value = "get authors by name", key = {"gan", "getAuthorsByName"})
    public void getAuthor(@ShellOption String name) {

        printerAuthorService.getByName(name);
    }


    @ShellMethod(value = "update author by id", key = {"ua", "updateAuthor"})
    public void updateAuthor(@ShellOption int id,
                          @ShellOption String newNameAuthor) {

        authorService.update(id, newNameAuthor);
    }

    @ShellMethod(value = "delete author by id", key = {"dai", "deleteAuthorById"})
    public void deleteAuthor(@ShellOption int id) {

        authorService.deleteById(id);
    }
}
