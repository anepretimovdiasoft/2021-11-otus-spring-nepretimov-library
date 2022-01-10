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

    @PostMapping("/newAuthor")
    public AuthorDto createNewAuthor(@RequestBody AuthorDto authorDto) {

        Author author = authorService.insert(AuthorDto.toDomainObject(authorDto));
        return AuthorDto.toDto(author);
    }

    @GetMapping("/getAllAuthors")
    public List<AuthorDto> getAllAuthors() {

        return authorService
                .getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getAuthorById")
    public AuthorDto getAuthorById(@RequestParam int id) {

        return AuthorDto.toDto(authorService.getById(id));
    }

    @GetMapping("/getAuthorByName")
    public AuthorDto getAuthorByName(@RequestParam String name) {

        return AuthorDto.toDto(authorService.getByName(name));
    }

    @PostMapping("/updateAuthorNameById")
    public AuthorDto updateNameById(
            @RequestParam int id,
            @RequestParam String name
    ) {

        return AuthorDto.toDto(
                authorService.update(id, name)
        );
    }

    @DeleteMapping("/deleteAuthorById")
    public void deleteAuthorById(@RequestParam int id) {

        authorService.deleteById(id);
    }

}
