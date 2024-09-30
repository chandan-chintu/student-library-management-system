package com.example.student_library_management_system.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {

    // here we can take input parameters which are going inside request and not backend added fields

    private String name;
    private String country;
    private double rating;
    private int age;
}
