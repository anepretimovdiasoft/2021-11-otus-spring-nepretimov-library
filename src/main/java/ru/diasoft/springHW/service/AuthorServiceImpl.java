package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.AuthorDao;
import ru.diasoft.springHW.domain.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public void insert(String name) {

        /*StringBuilder name = new StringBuilder();

        if (!secondName.equals(""))

            name.append(firstName)
                    .append(" ")
                    .append(secondName)
                    .append(" ")
                    .append(thirdName);
        else

            name.append(firstName)
                    .append(" ")
                    .append(thirdName);*/

        Author author = Author.builder()
                .name(name.replace('#', ' '))
                .build();

        authorDao.insert(author);
    }

    @Override
    public void update(int id, String firstName, String thirdName, String secondName) {

        StringBuilder name = new StringBuilder();

        if (!secondName.equals(""))

            name.append(firstName)
                    .append(" ")
                    .append(secondName)
                    .append(" ")
                    .append(thirdName);
        else

            name.append(firstName)
                    .append(" ")
                    .append(thirdName);

        Author author = Author.builder()
                .id(id)
                .name(name.toString())
                .build();

        authorDao.update(author);
    }

    @Override
    public List<Author> getAll() {

        return authorDao.getAll();
    }

    @Override
    public Author getById(int id) {

        return authorDao.getById(id);
    }

    @Override
    public Author getByName(String firstName, String thirdName, String secondName) {

        StringBuilder name = new StringBuilder();

        if (!secondName.equals(""))

            name.append(firstName)
                    .append(" ")
                    .append(secondName)
                    .append(" ")
                    .append(thirdName);
        else

            name.append(firstName)
                    .append(" ")
                    .append(thirdName);

        return authorDao.getByName(name.toString());
    }

    @Override
    public void deleteById(int id) {

        authorDao.deleteById(id);
    }
}
