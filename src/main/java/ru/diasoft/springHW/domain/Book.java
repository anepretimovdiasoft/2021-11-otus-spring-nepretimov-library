package ru.diasoft.springHW.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private int id;

    private String name;

    private int author_id;

    private int genre_id;
}
