package ru.diasoft.springHW.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.domain.Genre;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private int id;

    private String name;


    private Author author;

    private Genre genre;

    public static Book toDomainObject(BookDto bookDto, List<Comment> comments) {

        return new Book(
                bookDto.getId(),
                bookDto.getName(),
                comments,
                bookDto.getAuthor(),
                bookDto.getGenre()
        );
    }

    public static BookDto toDto(Book book) {

        return new BookDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre()
        );
    }
}
