package org.zerock.bookmarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.bookmarket.domain.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    void insert (Book book);
    List<Book> selectAll();
    Book selectOne(String id);
    void update(Book book);
    void delete(String id);
}
