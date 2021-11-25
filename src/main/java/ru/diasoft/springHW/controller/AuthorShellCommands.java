package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.AuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorShellCommands {

    private final AuthorService authorService;

    @ShellMethod(value = "add author", key = {"aa", "addAuthor"})
    public void addAuthor(@ShellOption String name) {

        authorService.insert(name);
    }

    @ShellMethod(value = "get all authors", key = {"ga", "getAuthors"})
    public void getAuthors() {

        System.out.println(authorService.getAll());
    }

    @ShellMethod(value = "get authors by id", key = {"gai", "getAuthorById"})
    public void getAuthor(@ShellOption int id) {

        System.out.println(authorService.getById(id));
    }

    @ShellMethod(value = "get authors by name", key = {"gan", "getAuthorsByName"})
    public void getAuthor(@ShellOption String firstName,
                          @ShellOption String thirdName,
                          @ShellOption(defaultValue = "") String secondName) {

        System.out.println(authorService.getByName(firstName, thirdName, secondName));
    }


    @ShellMethod(value = "update author by id", key = {"ua", "updateAuthor"})
    public void updateAuthor(@ShellOption int id,
                          @ShellOption String firstName,
                          @ShellOption String thirdName,
                          @ShellOption(defaultValue = "") String secondName) {

        authorService.update(id, firstName, thirdName, secondName);
    }

    @ShellMethod(value = "delete author by id", key = {"dai", "deleteAuthorById"})
    public void deleteAuthor(@ShellOption int id) {

        authorService.deleteById(id);
    }
}
