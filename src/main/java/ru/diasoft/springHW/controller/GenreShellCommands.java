package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.GenreService;
import ru.diasoft.springHW.service.printer.PrinterGenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreShellCommands {

    private final GenreService genreService;
    private final PrinterGenreService printerGenreService;

    @ShellMethod(value = "add genre", key = {"ag", "addGenre"})
    public void addGenre(@ShellOption String name) {

        genreService.insert(name);
    }

    @ShellMethod(value = "get all genres", key = {"gg", "getGenres"})
    public void getGenres() {

        printerGenreService.getAll();
    }

    @ShellMethod(value = "get genre by id", key = {"ggi", "getGenreById"})
    public void getGenre(@ShellOption int id) {

        printerGenreService.getById(id);
    }

    @ShellMethod(value = "get genre by name", key = {"ggn", "getGenreByName"})
    public void getGenre(@ShellOption String name) {

        printerGenreService.getByName(name);
    }

    @ShellMethod(value = "update genre by id", key = {"ug", "updateGenre"})
    public void updateGenre(@ShellOption int id,
                            @ShellOption String name) {

        genreService.update(id, name);
    }

    @ShellMethod(value = "delete genre by id", key = {"dgi", "deleteGenreById"})
    public void deleteGenre(@ShellOption int id) {

        genreService.deleteById(id);
    }
}
