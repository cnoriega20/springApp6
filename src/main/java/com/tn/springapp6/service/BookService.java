package com.tn.springapp6.service;

import com.tn.springapp6.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
