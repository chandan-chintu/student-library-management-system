package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="pages")
    private int pages;

    @Column(name="genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name="quantity")
    private int quantity;

}
