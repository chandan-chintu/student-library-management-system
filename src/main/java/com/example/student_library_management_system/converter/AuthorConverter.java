package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.StudentRequestDto;

public class AuthorConverter {

    // converter - converts the requestdto into model classes
    public static Author convertAuthorRequestDtoIntoAuthorModel(AuthorRequestDto authorRequestDto){
        Author author = Author.builder().name(authorRequestDto.getName()).country(authorRequestDto.getCountry())
                .age(authorRequestDto.getAge()).rating(authorRequestDto.getRating()).build();
        return author;
    }

}
