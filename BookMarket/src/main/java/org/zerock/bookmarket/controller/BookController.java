package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.service.BookService;


import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("addBook")
    public void addBook() {

    }

    @PostMapping("addBook")
    public String addBookPage(@RequestParam("imageFile") MultipartFile imageFile,
                              @Valid BookDTO bookDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) throws IOException {
        if (imageFile.isEmpty()) {
            log.error("no image...");
            redirectAttributes.addFlashAttribute("error", "이미지를 선택해주세요.");
            return "redirect:/book/addBook";
        }

        bookDTO.setImgFileName(imageFile.getOriginalFilename());
        bookService.add(bookDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/book/addBook";
        }
        log.info(bookDTO);

        return "redirect:/book/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model, RedirectAttributes redirectAttributes) {
        try {
            List<BookDTO> dtoList = bookService.getAllBooks();
            model.addAttribute("books", dtoList);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/book/books";
        }
        return "/book/books";
    }

    @GetMapping("/book")
    public String read(String id, Model model) {
        BookDTO bookDTO = bookService.getOne(id);
        log.info(bookDTO);
        model.addAttribute("book", bookDTO);
        return "/book/book";

    }

    @GetMapping("/editBook")
    public String editBooks(Model model, RedirectAttributes redirectAttributes) {
        try {
            List<BookDTO> dtoList = bookService.getAllBooks();
            model.addAttribute("books", dtoList);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/book/editBook";
        }
        return "/book/editBook";
    }

    @GetMapping("/updateBook")
    public void updateBooks(String id,Model model) {
        bookService.getOne(id);
        model.addAttribute("book", bookService.getOne(id));
    }

    @PostMapping("/updateBook")
    public String update(@Valid BookDTO bookDTO,
                         @RequestParam("file") MultipartFile file,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            log.error("no image...");
            redirectAttributes.addFlashAttribute("error", "이미지를 선택해주세요.");
            return "redirect:/book/updateBook";
        }

        bookDTO.setImgFileName(file.getOriginalFilename());

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("id", bookDTO.getId());
            return "redirect:/book/updateBook";
        }
        bookDTO.setCreateDate(LocalDateTime.now());
        log.info(bookDTO);
        bookService.modify(bookDTO);
        redirectAttributes.addAttribute("id", bookDTO.getId());
        return "redirect:/book/book";
    }

    @GetMapping("/remove")
    public String remove(String id, RedirectAttributes redirectAttributes) {
        log.info("book Remove .......");
        bookService.delete(id);
        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/book/books";

    }
}





