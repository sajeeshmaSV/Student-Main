package org.hibernate.repository;

import org.hibernate.entity.Student;

public interface StudentRepository {
    void saveStudent(Student student);

    Student findStudent(int studentId);

    void updateCourseDetails(int studentId, String courseName);

    void deleteStudent(int studentId);
}