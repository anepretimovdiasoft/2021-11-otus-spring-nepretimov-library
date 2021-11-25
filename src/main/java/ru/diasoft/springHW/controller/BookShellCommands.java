package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookShellCommands {

    private final BookService bookService;

    @ShellMethod(value = "get books", key = {"gb", "getBooks"})
    public void getBooks() {

        System.out.println(bookService.getAll());
    }

    @ShellMethod(value = "add books", key = {"ab", "addBook"})
    public void addBook(
            @ShellOption String nameBook,
            @ShellOption String nameGenre,
            @ShellOption String nameAuthor
            ) {

        bookService.insert(nameBook, nameGenre, nameAuthor);
    }

    @ShellMethod(value = "update book", key = {"ub", "updateBook"})
    public void updateBook(
            @ShellOption int id,
            @ShellOption String nameBook,
            @ShellOption String nameGenre,
            @ShellOption String firstName,
            @ShellOption String thirdName,
            @ShellOption(defaultValue = "") String secondName
    ) {

        bookService.update(id, nameBook, nameGenre, firstName,  thirdName, secondName);
    }

    @ShellMethod(value = "get book by id", key = {"gbi", "getBookById"})
    public void getBook(@ShellOption int id) {

        System.out.println(bookService.getById(id));
    }

    @ShellMethod(value = "get book by name", key = {"gbn", "getBookByName"})
    public void getBook(@ShellOption String name) {

        System.out.println(bookService.getByName(name));
    }

    @ShellMethod(value = "delete book by id", key = {"dbi", "deleteBookById"})
    public void deleteBook(@ShellOption int id) {

        bookService.deleteById(id);
    }
}
