package org.zerock.bookmarket.service;

import org.springframework.stereotype.Service;
import org.zerock.bookmarket.dto.BookDTO;

import java.util.List;

@Service
public interface BookService {
    void add (BookDTO bookDTO);
    List<BookDTO> getAllBooks ();
    BookDTO getOne(String id);
    void modify(BookDTO bookDTO);
    void delete(String id);
}
