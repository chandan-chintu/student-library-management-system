package com.example.student_library_management_system.repository;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // writing our own methods for performing database queries using fields/attributes of model class

    public Book findByTitle(String title);

    public List<Book> findByPages(int pages);

    public Book findByTitleAndPages(String title, int pages);


    // writing our own methods for performing database queries using our own customized queries
    //SELECT * FROM student_library_management.book where genre="DRAMA"
    @Query(nativeQuery = true, value = "SELECT * FROM book where genre= :inputGenre")
    public List<Book> getBookByGenre(String inputGenre);

}
