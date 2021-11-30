package ru.diasoft.springHW.service.printer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.service.AuthorService;

@Service
@RequiredArgsConstructor
public class PrinterAuthorServiceImpl implements PrinterAuthorService {

    private final AuthorService authorService;

    @Override
    public void getAll() {

        for (Author author : authorService.getAll()) {

            printAuthor(author);
        }
    }

    @Override
    public void getById(int id) {

        printAuthor(authorService.getById(id));
    }

    @Override
    public void getByName(String nameAuthor) {

        printAuthor(authorService.getByName(nameAuthor));
    }

    private void printAuthor(Author author) {
        System.out.println("Author " + author.getId() + " : " + author.getName());
    }
}
