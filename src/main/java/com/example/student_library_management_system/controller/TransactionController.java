package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;
import com.example.student_library_management_system.service.AuthorService;
import com.example.student_library_management_system.service.TransactionServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionServeice transactionServeice;

    @PostMapping("/create")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto) throws ParseException {
        String response = transactionServeice.createTransaction(transactionRequestDto);
        return response;
    }
}
