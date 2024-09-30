package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    // converter - converts the requestdto into model classes
    public static Book convertBookRequestDtoIntoBookModel(BookRequestDto bookRequestDto){
        Book  book = Book.builder().pages(bookRequestDto.getPages()).genre(bookRequestDto.getGenre())
                .title(bookRequestDto.getTitle()).quantity(bookRequestDto.getQuantity()).build();
        return book;
    }

}
