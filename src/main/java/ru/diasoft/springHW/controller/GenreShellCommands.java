package ru.diasoft.springHW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.springHW.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreShellCommands {

    private final GenreService genreService;

    @ShellMethod(value = "add genre", key = {"ag", "addGenre"})
    public void addGenre(@ShellOption String name) {

        genreService.insert(name);
    }

    @ShellMethod(value = "get all genres", key = {"gg", "getGenres"})
    public void getGenres() {

        System.out.println(genreService.getAll());
    }

    @ShellMethod(value = "get genre by id", key = {"ggi", "getGenreById"})
    public void getGenre(@ShellOption int id) {

        System.out.println(genreService.getById(id));
    }

    @ShellMethod(value = "get genre by name", key = {"ggn", "getGenreByName"})
    public void getGenre(@ShellOption String name) {

        System.out.println(genreService.getByName(name));
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
