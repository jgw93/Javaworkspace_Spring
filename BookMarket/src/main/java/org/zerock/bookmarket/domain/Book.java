package org.zerock.bookmarket.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String id;
    private String name;
    private String description;
    private String category;
    private String author;
    private String publisher;
    private String releaseDate;
    private int pages;
    private int unitPrice;
    private int unitInStock;
    private String imgFileName;
    private LocalDateTime createDate;
}
