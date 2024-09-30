package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    // converter - converts the requestdto into model classes
    public static Transaction convertTransactionRequestDtoIntoTransactionModel(TransactionRequestDto transactionRequestDto){
        Transaction transaction =Transaction.builder().transactionName(transactionRequestDto.getTransactionName())
                .transactionStatus(transactionRequestDto.getTransactionStatus()).build();
        return transaction;
    }

}
