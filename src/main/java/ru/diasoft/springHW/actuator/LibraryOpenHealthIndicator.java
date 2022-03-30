package ru.diasoft.springHW.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import ru.diasoft.springHW.service.BookService;

@Component
@RequiredArgsConstructor
public class LibraryOpenHealthIndicator implements HealthIndicator {

    private final BookService bookService;

    @Override
    public Health health() {

        //Проверяем наличие книг в библиотеке
        if (bookService.getAll().size() > 0)
            return Health.up().build();
        else
            return Health.down().build();
    }
}
