package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.AuthorDao;
import ru.diasoft.springHW.domain.Author;
import ru.diasoft.springHW.util.StringShellUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    @Transactional
    public void insert(String name) {

        Author author = Author.builder()
                .name(StringShellUtil.stringNameNormalFormat(name))
                .build();

        authorDao.insert(author);
    }


    @Override
    @Transactional
    public void update(int id, String newNameAuthor) {


        Author author = Author.builder()
                .id(id)
                .name(StringShellUtil.stringNameNormalFormat(newNameAuthor))
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
    public Author getByName(String nameAuthor) {

        return authorDao.getByName(StringShellUtil.stringNameNormalFormat(nameAuthor));
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        authorDao.deleteById(id);
    }
}
