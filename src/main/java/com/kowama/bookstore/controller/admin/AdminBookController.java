/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : AdminBookController
 * Last modified : 6/3/19 1:54 PM
 */

package com.kowama.bookstore.controller.admin;

import com.kowama.bookstore.controller.IndexController;
import com.kowama.bookstore.domain.Book;
import com.kowama.bookstore.service.BookService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {
    private Logger LOG = Logger.getLogger(AdminBookController.class.getName());

    private final BookService _bookService;

    public AdminBookController(BookService bookService) {
        _bookService = bookService;
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/admin/bookForm";
    }

    @GetMapping("/view")
    public String ViewBook(Model model,
                           @RequestParam(name = "category", defaultValue = "all", required = false) String category,
                           @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                           @RequestParam(name = "size", defaultValue = "12", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = _bookService.findAll(pageable);
        model.addAttribute("bookPage", bookPage);
        return "/admin/viewBooks";
    }

    @GetMapping("/edit")
    public String editBook(Model model, @RequestParam(name = "id") Long id) {
        Optional<Book> book = _bookService.findById(id);
        if (!book.isPresent()) {
            String msg = "book not found with id " + id;
            LOG.warning(msg);
            model.addAttribute("errorMessage", msg);
            return "redirect:/admin/book/list";
        }
        model.addAttribute("book", book.get());
        return "/admin/bookForm";
    }

    @PostMapping("/add")
    public String addBookPost(@ModelAttribute("book") Book book) {
        _bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/books/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admin/book/list";
    }

    @RequestMapping("/list")
    public String bookList(Model model) {

        model.addAttribute("books", _bookService.findAll());

        return "/admin/bookList";

    }
}
