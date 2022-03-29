package ru.diasoft.springHW.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PostMapping("/book")
    public BookDto createNewBook(
            @RequestParam String nameBook,
            @RequestParam String nameGenre,
            @RequestParam String nameAuthor
    ) {

        Book book = bookService.insert(nameBook, nameGenre, nameAuthor);
        return BookDto.toDto(book);
    }

    @GetMapping("/book")
    public List<BookDto> getAllBooks() {

        //Попытки понять что нитак с ролями
        //UserDetails userDetails = (UserDetails) SecurityContextHolder
        //        .getContext().getAuthentication().getPrincipal();
        //System.out.println(userDetails.getAuthorities());

        return bookService
                .getAll()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/book/{id}/")
    public BookDto updateBookById(
            @PathVariable int id,
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

    @GetMapping("/book/{id}")
    public BookDto getBookById(@PathVariable int id) {

        return BookDto.toDto(bookService.getById(id));
    }

    @GetMapping("/book/name")
    public BookDto getBookByName(@RequestParam String name) {

        return BookDto.toDto(bookService.getByName(name));
    }

    @DeleteMapping("/book/{id}")
    //@PostMapping("/deleteBookById")
    public void deleteBookById(@PathVariable int id) {

        bookService.deleteById(id);
    }

}
