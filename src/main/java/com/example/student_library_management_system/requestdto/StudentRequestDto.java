package com.example.student_library_management_system.requestdto;

import lombok.Data;

@Data
public class StudentRequestDto {

    // here we can take input parameters which are going inside request and not backend added fields

    private String name;
    private int age;
    private String email;
    private String mobile;
    private String gender;
}
