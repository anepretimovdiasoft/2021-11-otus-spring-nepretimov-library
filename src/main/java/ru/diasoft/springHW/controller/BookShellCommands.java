package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.BookService;
import ru.diasoft.springHW.service.printer.PrinterBookService;

@ShellComponent
@RequiredArgsConstructor
public class BookShellCommands {

    private final BookService bookService;
    private final PrinterBookService printerBookService;

    @ShellMethod(value = "get books", key = {"gb", "getBooks"})
    public void getBooks() {

        printerBookService.getAllBook();
    }

    @ShellMethod(value = "add books", key = {"ab", "addBook"})
    public void addBook(
            @ShellOption String nameBook,
            @ShellOption String nameGenre,
            @ShellOption String nameAuthor
    ) {

        bookService.insert(nameBook, nameGenre, nameAuthor);
    }

    @ShellMethod(value = "update book name", key = {"ub", "updateBook"})
    public void updateBook(
            @ShellOption int id,
            @ShellOption String newNameBook,
            @ShellOption String nameGenre,
            @ShellOption String nameAuthor
    ) {

        bookService.update(id, newNameBook, nameGenre, nameAuthor);
    }

    @ShellMethod(value = "get book by id", key = {"gbi", "getBookById"})
    public void getBook(@ShellOption int id) {

        printerBookService.getById(id);
    }

    @ShellMethod(value = "get book by name", key = {"gbn", "getBookByName"})
    public void getBook(@ShellOption String name) {

        printerBookService.getByName(name);
    }

    @ShellMethod(value = "delete book by id", key = {"dbi", "deleteBookById"})
    public void deleteBook(@ShellOption int id) {

        bookService.deleteById(id);
    }
}
