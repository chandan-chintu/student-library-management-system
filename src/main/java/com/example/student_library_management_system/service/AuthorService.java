package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.AuthorConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.repository.AuthorRepsitory;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepsitory authorRepsitory;

    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author author = AuthorConverter.convertAuthorRequestDtoIntoAuthorModel(authorRequestDto);
        authorRepsitory.save(author);
        return "Author saved successfully";
    }
}
