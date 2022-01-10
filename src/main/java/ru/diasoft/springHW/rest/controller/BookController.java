package ru.diasoft.springHW.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.rest.dto.BookDto;
import ru.diasoft.springHW.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/newBook")
    public BookDto createNewBook(
            @RequestParam String nameBook,
            @RequestParam String nameGenre,
            @RequestParam String nameAuthor
    ) {

        Book book = bookService.insert(nameBook, nameGenre, nameAuthor);
        return BookDto.toDto(book);
    }

    @GetMapping("/getAllBooks")
    public List<BookDto> getAllBooks() {

        return bookService
                .getAll()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/updateBookById")
    public BookDto updateBookById(
            @RequestParam int id,
            @RequestParam String newBookName,
            @RequestParam String newGenreName,
            @RequestParam String newAuthorName
    ) {

        Book book = bookService.update(
                id,
                newBookName,
                newGenreName,
                newAuthorName
        );

        return BookDto.toDto(book);
    }

    @GetMapping("/getBookById")
    public BookDto getBookById(@RequestParam int id) {

        return BookDto.toDto(bookService.getById(id));
    }

    @GetMapping("/getBookByName")
    public BookDto getBookByName(@RequestParam String name) {

        return BookDto.toDto(bookService.getByName(name));
    }

    @DeleteMapping("/deleteBookById")
    public void deleteBookById(@RequestParam int id) {

        bookService.deleteById(id);
    }

}
