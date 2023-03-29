package com.tn.springapp6.bootstrap;

import com.tn.springapp6.domain.Author;
import com.tn.springapp6.domain.Book;
import com.tn.springapp6.repositories.AuthorRepository;
import com.tn.springapp6.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args)  {
        Author author1 = Author.builder()
                .firstName(" Craig ")
                .lastName("Walls")
                .build();
        Book book1  = Book.builder()
                .title("Spring in Action, Sixth Edition 6th Edition")
                .isbn("978-1492078005")
                .build();

        Author authorSaved1 = authorRepository.save(author1);
        Book bookSaved1 = bookRepository.save(book1);

        Author author2 = Author.builder()
                .firstName(" Eric")
                .lastName("Freeman")
                .build();

        Book book2 = Book.builder()
                .title("Head First Design Patterns")
                .isbn("978-1492018004")
                .build();

        Author authorSaved2 = authorRepository.save(author2);
        Book bookSaved2 = bookRepository.save(book2);

        authorSaved1.getBooks().add(bookSaved1);
        authorSaved2.getBooks().add(bookSaved2);

        authorRepository.save(authorSaved1);
        authorRepository.save(authorSaved2);


        log.info("In Bootstrap..");
        log.info("Author count: {}", authorRepository.count());
        log.info("BookC");

    }
}
