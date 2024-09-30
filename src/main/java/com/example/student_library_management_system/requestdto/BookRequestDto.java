package com.example.student_library_management_system.requestdto;

import com.example.student_library_management_system.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookRequestDto {

    private String title;
    private int pages;
    private Genre genre;
    private int quantity;
    private int cardId;
    private int authorId;
}
