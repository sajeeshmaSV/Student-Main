package org.hibernate.service.Impl;

import org.hibernate.dto.StudentDTO;
import org.hibernate.entity.Student;
import org.hibernate.exception.StudentNotFoundException;
import org.hibernate.repository.StudentRepository;
import org.hibernate.repository.impl.StudentRepositoryImpl;
import org.hibernate.service.StudentService;
import org.hibernate.util.MapperUtil;

public class StudentServiceImpl implements StudentService {

    private static StudentRepository studentRepository;

    public StudentServiceImpl() {
        studentRepository = new StudentRepositoryImpl();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = MapperUtil.convertStudentDtoToEntity(studentDTO);
        studentRepository.saveStudent(student);
    }

    @Override
    public StudentDTO findStudent(int studentId) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id : " + studentId);
        }
        return MapperUtil.convertStudentEntityToDto(student);
    }

    @Override
    public void updateCourserDetails(int studentId, String courseName) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.updateCourseDetails(studentId,courseName);
    }

    @Override
    public void deleteStudent(int studentId) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteStudent(studentId);
    }
}