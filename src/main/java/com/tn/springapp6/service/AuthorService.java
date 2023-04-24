package com.tn.springapp6.service;

import com.tn.springapp6.domain.Author;
import com.tn.springapp6.domain.Book;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Iterable<Author> findAll();
}
