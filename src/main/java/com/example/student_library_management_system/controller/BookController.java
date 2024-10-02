package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import com.example.student_library_management_system.service.AuthorService;
import com.example.student_library_management_system.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    /*
    Loggers - displays the messages in console which helps in track the application flow
    different levels of loggers
    info - displays the information(general information are displayed)
    error - display error or exception messages
    warn - warning messages
    debug - while running in debug mode this will display
     */

    // declaring the loggers
    Logger logger = LoggerFactory.getLogger(BookController.class);

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

    @GetMapping("/findPage")
    public List<Book> getAllBookBasedOnPagination(@RequestParam("pageno") int pageNo, @RequestParam("pagesize") int pageSize,@RequestParam("sortparam") String sortParam){
        List<Book> bookList= bookService.getBookOnPagination(pageNo,pageSize,sortParam);
        return bookList;
    }

    @GetMapping("/findByTitle")
    public ResponseEntity<?> getBookByTitle(@RequestParam("title") String title){
        logger.info("getBookByTitle API started");
        try {
            Book book = bookService.getBookByTitle(title);
            logger.info("getBookByTitle API ended");
            return ResponseEntity.ok(book);
        }catch (Exception e){
            logger.error("getBookByTitle got some error : {}",e.getMessage());
            return ResponseEntity.internalServerError().body("Some exception occured "+e.getMessage());
        }
    }

    @GetMapping("/findByGenre")
    public List<Book> getBookByGenre(@RequestParam("genre") String genre){
        List<Book> bookList= bookService.getBookByGenre(genre);
        return bookList;
    }

    @GetMapping("/findByTitleAndPages")
    public Book getBookByTitle(@RequestParam("title") String title, @RequestParam("pages") int pages){
        Book book= bookService.getBookByTitleAndPages(title,pages);
        return book;
    }


}