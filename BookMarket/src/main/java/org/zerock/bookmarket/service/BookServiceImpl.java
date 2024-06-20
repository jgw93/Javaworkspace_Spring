package org.zerock.bookmarket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.domain.Book;
import org.zerock.bookmarket.domain.Member;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.dto.MemberDTO;
import org.zerock.bookmarket.mapper.BookMapper;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookMapper bookMapper;
    private final ModelMapper modelMapper;

    @Override
    public void add(BookDTO bookDTO) {
        log.info(modelMapper);
        Book book  = modelMapper.map(bookDTO, Book.class);
        log.info(book);
        bookMapper.insert(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> dtoList = bookMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, BookDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public BookDTO getOne(String id) {
        Book book = bookMapper.selectOne(id);
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

    @Override
    public void modify(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        bookMapper.update(book);
    }

    @Override
    public void delete(String id){bookMapper.delete(id);}


}
