package ru.diasoft.springHW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.springHW.dao.GenreDao;
import ru.diasoft.springHW.domain.Genre;
import ru.diasoft.springHW.util.StringShellUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    @Transactional
    public void insert(String name) {

        Genre genre = Genre.builder()
                .name(StringShellUtil.stringNameNormalFormat(name))
                .build();

        genreDao.insert(genre);
    }

    @Override
    @Transactional
    public void update(int id, String name) {

        Genre genre = Genre.builder()
                .id(id)
                .name(StringShellUtil.stringNameNormalFormat(name))
                .build();

        genreDao.update(genre);
    }

    @Override
    public List<Genre> getAll() {

        return genreDao.getAll();
    }

    @Override
    public Genre getById(int id) {

        return genreDao.getById(id);
    }

    @Override
    public Genre getByName(String name) {

        return genreDao.getByName(StringShellUtil.stringNameNormalFormat(name));
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        genreDao.deleteById(id);
    }
}
