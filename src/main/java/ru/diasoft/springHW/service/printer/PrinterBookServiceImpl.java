package ru.diasoft.springHW.service.printer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.domain.Book;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.service.BookService;
import ru.diasoft.springHW.util.StringShellUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrinterBookServiceImpl implements PrinterBookService {

    private final BookService bookService;

    @Override
    @Transactional
    public void getAllBook() {

        List<Book> books = bookService.getAll();
        for (Book book : books) {
            printBook(book);
        }
    }

    @Override
    @Transactional
    public void getById(int id) {

        printBook(bookService.getById(id));
    }

    @Override
    @Transactional
    public void getByName(String name) {

        printBook(bookService.getByName(StringShellUtil.stringNameNormalFormat(name)));
    }

    private void printBook(Book book) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("----------------- \n")
                .append("Название книги : ").append(book.getName()).append('\n')
                .append("Автор книги : ").append(book.getAuthor().getName()).append('\n')
                .append("Жанр книги : ").append(book.getGenre().getName()).append('\n');

        List<Comment> comments = book.getComments();
        if (comments != null && comments.size() != 0) {
            stringBuilder.append("Комментарии : ").append('\n');
            for (Comment comment : comments) {
                stringBuilder.append("\t").append(comment.getContent()).append('\n');
            }
        }

        System.out.println(stringBuilder);
    }
}
