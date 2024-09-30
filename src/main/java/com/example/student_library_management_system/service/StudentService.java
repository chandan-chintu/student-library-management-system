package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // to save the students
    // when we save students it should also save card for that student
    public String saveStudents(StudentRequestDto studentRequestDto){
        Student student = StudentConverter.convertStudentRequestDtoIntoStudentModel(studentRequestDto);

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

        // save student object
        studentRepository.save(student);
        return "Student and card saved successfully";
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }
}
