package com.tn.springapp6.bootstrap;

import com.tn.springapp6.domain.Author;
import com.tn.springapp6.domain.Book;
import com.tn.springapp6.domain.Publisher;
import com.tn.springapp6.repositories.AuthorRepository;
import com.tn.springapp6.repositories.BookRepository;
import com.tn.springapp6.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args)  {
        Book book1  = Book.builder()
                .title("Spring in Action, Seventh Edition 7th Edition")
                .isbn("978-1492078005")
                .build();
        Author author1 = Author.builder()
                .firstName(" Craig ")
                .lastName("Walls")
                .build();
        Author author2 = Author.builder()
                .firstName(" Eric")
                .lastName("Freeman")
                .build();

        if(null != book1.getAuthors()) {
            book1.getAuthors().add(author1);
            book1.getAuthors().add(author2);
        }

        if(null != author1.getBooks() && null != author2.getBooks()) {
            author1.getBooks().add(book1);
            author2.getBooks().add(book1);
        }


        bookRepository.save(book1);

        //Author authorSaved1 = authorRepository.save(author1);
       // Book bookSaved1 = bookRepository.save(book1);



       /* Book book2 = Book.builder()
                .title("Head First Design Patterns")
                .isbn("978-1492018004")
                .build();*/

        /*Author authorSaved2 = authorRepository.save(author2);
        Book bookSaved2 = bookRepository.save(book2);*/

        /*authorSaved1.getBooks().add(bookSaved1);
        authorSaved2.getBooks().add(bookSaved2);

        authorRepository.save(authorSaved1);
        authorRepository.save(authorSaved2);*/

        Publisher pub1 = Publisher.builder()
                .publisherName("Marvel")
                .address("LA")
                .city("LA")
                .state("CA")
                .zipcode("10002")
                .build();

        Publisher pub2 = Publisher.builder()
                .publisherName("DC")
                .address("WA")
                .city("Seattle")
                .state("WA")
                .zipcode("11002")
                .build();
        publisherRepository.save(pub1);
        publisherRepository.save(pub2);

        log.info("In Bootstrap..");
        log.info("Book count: {}", bookRepository.count());
        log.info("Publisher count: {}",publisherRepository.count());
        log.info("BookC");

    }
}
