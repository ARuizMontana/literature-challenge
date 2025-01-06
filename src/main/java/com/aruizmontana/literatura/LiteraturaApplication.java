package com.aruizmontana.literatura;


import com.aruizmontana.literatura.domain.repository.AuthorRepository;
import com.aruizmontana.literatura.domain.repository.BookRepository;
import com.aruizmontana.literatura.ui.MyApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        MyApp app = new MyApp(bookRepository, authorRepository);
        app.runApplication();
    }
}
