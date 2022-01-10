package ru.diasoft.springHW.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.diasoft.springHW.domain.Author;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private int id;

    private String name;

    public static Author toDomainObject(AuthorDto authorDto) {

        return new Author(authorDto.getId(), authorDto.getName());
    }

    public static AuthorDto toDto(Author author) {

        return new AuthorDto(author.getId(), author.getName());
    }

}
