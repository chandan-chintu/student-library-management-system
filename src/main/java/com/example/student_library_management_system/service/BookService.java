package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.BookConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.repository.AuthorRepsitory;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepsitory authorRepsitory;

    @Autowired
    private BookRepository bookRepository;

    public String saveBook(BookRequestDto bookRequestDto){

        Book book = BookConverter.convertBookRequestDtoIntoBookModel(bookRequestDto);

        // we find the author details with the id and set it inside book
        Author author = authorRepsitory.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);
        bookRepository.save(book);
        return "Book saved";

    }

    public List<Book> getAllBook(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }
}
