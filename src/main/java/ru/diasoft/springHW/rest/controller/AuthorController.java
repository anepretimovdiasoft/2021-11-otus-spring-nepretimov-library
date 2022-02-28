package ru.diasoft.springHW.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.rest.dto.AuthorDto;
import ru.diasoft.springHW.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/author")
    public AuthorDto createNewAuthor(@RequestBody AuthorDto authorDto) {

        Author author = authorService.insert(AuthorDto.toDomainObject(authorDto));
        return AuthorDto.toDto(author);
    }

    @GetMapping("/author")
    public List<AuthorDto> getAllAuthors() {

        return authorService
                .getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable int id) {

        return AuthorDto.toDto(authorService.getById(id));
    }

    @GetMapping("/author/name")
    public AuthorDto getAuthorByName(@RequestParam String name) {

        return AuthorDto.toDto(authorService.getByName(name));
    }

    @PostMapping("/author/{id}/name")
    public AuthorDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return AuthorDto.toDto(
                authorService.update(id, name)
        );
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthorById(@PathVariable int id) {

        authorService.deleteById(id);
    }

}
