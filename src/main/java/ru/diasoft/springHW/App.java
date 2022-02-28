package ru.diasoft.springHW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

// url h2 консоли: http://localhost:8080/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        //Console.main(args);
    }

}
