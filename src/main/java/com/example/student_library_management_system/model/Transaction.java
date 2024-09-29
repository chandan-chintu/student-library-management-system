package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.TransactionName;
import com.example.student_library_management_system.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    @Enumerated(value = EnumType.STRING)
    private TransactionName transactionName;// purchase/return

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name="fine")
    private double fine;

    @Column(name="transaction_date")
    @CreationTimestamp
    private Date transactionDate;

    @Column(name="due_date")
    private Date dueDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Card card;
}
