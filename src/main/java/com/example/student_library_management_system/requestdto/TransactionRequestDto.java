package com.example.student_library_management_system.requestdto;

import com.example.student_library_management_system.enums.TransactionName;
import com.example.student_library_management_system.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionName transactionName;// purchase/return
    private TransactionStatus transactionStatus;
    private int bookId;
    private int cardId;
}
