package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.BookConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.repository.AuthorRepsitory;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /*
    Pagination - getting/fetching the records or data in the form of pages
    pagenumber - the number of page we want to see*(page number starts from 0)
    pagesize - total number of records in each page(fixed in each page)

    in database there are 28 books, pagesize-5
    0th page - 1-5
    1st page - 6-10
    2nd page - 11-15
    3rd page - 16-20
    4th page - 21-25
    5th page - 26-28

     in database there are 10 books, pagesize-3
    0th page - 1-3
    1st page - 4-6
    2nd page - 7-9
    3rd page - 10

    in database there are 10 books, pagesize-2
    0th page - 1-2
    1st page - 3-4
    2nd page - 5-6
    3rd page - 7-8
    4th page - 9-10

sorting - arranging the data based on ascedning or descending order of the field
     */
    

    public List<Book> getBookOnPagination(int pageNo, int pageSize, String sortParameter){
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortParameter).ascending()));
        List<Book> bookList = new ArrayList<>();
        for(Book book : bookPage){
            bookList.add(book);
        }
        return bookList;
    }

    public Book getBookByTitle(String title){
        Book book = bookRepository.findByTitle(title);
        return book;
    }

    public List<Book> getBookByGenre(String genre){
        List<Book> bookList = bookRepository.getBookByGenre(genre);
        return bookList;
    }

    public Book getBookByTitleAndPages(String title, int pages){
        Book book = bookRepository.findByTitleAndPages(title,pages);
        return book;
    }

}
