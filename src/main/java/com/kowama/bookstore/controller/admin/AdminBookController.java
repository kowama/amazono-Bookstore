/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/1/2019
 * Time : 2 : 32
 * Project : bookstore
 * Class : AdminBookController
 * Last modified : 1/6/17 3:40 PM
 */

package com.kowama.bookstore.controller.admin;

import com.kowama.bookstore.domain.Book;
import com.kowama.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {

    private final BookService _bookService;

    public AdminBookController(BookService bookService) {
        _bookService = bookService;
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @PostMapping("/add")
    public String addBookPost(@ModelAttribute("book") Book book) {
        _bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:bookList";
    }

    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = _bookService.findAll();

        model.addAttribute("books", bookList);

        return "bookList";

    }

}
