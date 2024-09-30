package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="created_on")
    @CreationTimestamp // when card gets created it will add the time automatically from the system
    private Date createdOn;

    @Column(name="updated_on")
    @UpdateTimestamp // when card gets updates it will add the time automatically from the system
    private Date updatedOn;

    @Column(name="card_status")
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @JsonBackReference
    @OneToOne
    @JoinColumn
    private Student student;

    @JsonManagedReference
    @OneToMany(mappedBy = "card",  cascade = CascadeType.ALL)
    private List<Book> booksAssignedToCard = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "card",  cascade = CascadeType.ALL)
    private List<Transaction> transactionsForCard = new ArrayList<>();
}
