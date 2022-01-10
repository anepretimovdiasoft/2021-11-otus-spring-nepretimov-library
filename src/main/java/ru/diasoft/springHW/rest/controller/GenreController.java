package ru.diasoft.springHW.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.springHW.domain.Genre;
import ru.diasoft.springHW.rest.dto.GenreDto;
import ru.diasoft.springHW.service.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/newGenre")
    public GenreDto createNewGenre(@RequestBody GenreDto genreDto) {

        Genre genre = genreService.insert(GenreDto.toDomainObject(genreDto));
        return GenreDto.toDto(genre);
    }

    @GetMapping("/getAllGenres")
    public List<GenreDto> getAllGenres() {

        return genreService
                .getAll()
                .stream()
                .map(GenreDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getGenreById")
    public GenreDto getGenreById(@RequestParam int id) {

        return GenreDto.toDto(genreService.getById(id));
    }

    @GetMapping("/getGenreByName")
    public GenreDto getGenreByName(@RequestParam String name) {

        return GenreDto.toDto(genreService.getByName(name));
    }

    @PostMapping("/updateGenreNameById")
    public GenreDto updateNameById(
            @RequestParam int id,
            @RequestParam String name
    ) {

        return GenreDto.toDto(
                genreService.update(id, name)
        );
    }

    @DeleteMapping("/deleteGenreById")
    public void deleteGenreById(@RequestParam int id) {

        genreService.deleteById(id);
    }

}
