package ru.diasoft.springHW.service.printer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.springHW.domain.Comment;
import ru.diasoft.springHW.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrinterCommentServiceImpl implements PrinterCommentService {

    private final CommentService commentService;

    @Override
    public void getAll() {

        List<Comment> comments = commentService.getAll();

        for (Comment comment : comments) {

            printComment(comment);
        }
    }

    @Override
    public void getById(int id) {

        Comment comment = commentService.getById(id);

        printComment(comment);
    }

    private void printComment(Comment comment) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Comment ").append(comment.getId())
                .append(" : ").append(comment.getContent());

        System.out.println(stringBuilder);
    }
}
