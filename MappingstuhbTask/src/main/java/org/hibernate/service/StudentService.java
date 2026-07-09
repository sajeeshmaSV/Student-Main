package org.hibernate.service;

import java.time.LocalDate;

import org.hibernate.dto.StudentDTO;
import org.hibernate.entity.Student;
import org.hibernate.exception.StudentNotFoundException;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);

    StudentDTO findStudent(int studentId) throws StudentNotFoundException;

    void updateCourserDetails(int studentId, String courseName) throws StudentNotFoundException;

    void deleteStudent(int studentId) throws StudentNotFoundException;

}