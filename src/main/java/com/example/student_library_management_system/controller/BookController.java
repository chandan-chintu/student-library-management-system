package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import com.example.student_library_management_system.service.AuthorService;
import com.example.student_library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response = bookService.saveBook(bookRequestDto);
        return response;
    }

    @GetMapping("/findAll")
    public List<Book> getAllBook(){
        List<Book> bookList= bookService.getAllBook();
        return bookList;
    }

}