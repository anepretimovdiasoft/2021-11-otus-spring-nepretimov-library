package ru.diasoft.springHW.service.printer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.springHW.domain.Genre;
import ru.diasoft.springHW.service.GenreService;

@Service
@RequiredArgsConstructor
public class PrinterGenreServiceImpl implements PrinterGenreService {

    private final GenreService genreService;

    @Override
    public void getAll() {

        for (Genre genre : genreService.getAll()) {
            printGenre(genre);
        }
    }

    @Override
    public void getById(int id) {

        printGenre(genreService.getById(id));
    }

    @Override
    public void getByName(String nameGenre) {

        printGenre(genreService.getByName(nameGenre));
    }

    private void printGenre(Genre genre) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Genre ").append(genre.getId())
                .append(" : ").append(genre.getName());

        System.out.println(stringBuilder);
    }

}
