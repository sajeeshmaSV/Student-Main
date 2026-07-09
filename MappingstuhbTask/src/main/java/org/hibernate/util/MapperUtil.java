package org.hibernate.util;

import org.hibernate.dto.CourseDTO;
import org.hibernate.dto.StudentDTO;
import org.hibernate.entity.Course;
import org.hibernate.entity.Student;

public class MapperUtil {
    private MapperUtil() {

    }

    public static StudentDTO convertStudentEntityToDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setGender(student.getGender());
        studentDTO.setCity(student.getCity());
        studentDTO.setState(student.getState());
        studentDTO.setMobileNumber(student.getMobileNumber());
        studentDTO.setEmailId(student.getEmailId());
        CourseDTO courseDTO = convertCourseEntityToDto(student.getCourse());
        studentDTO.setCourseDTO(courseDTO);
        return studentDTO;
    }

    public static CourseDTO convertCourseEntityToDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourse_id(course.getId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setEnrollmentDate(course.getEnrollmentDate());
        courseDTO.setCourseType(course.getCourseType());
        courseDTO.setGrade(course.getGrade());
        courseDTO.setStudentDTO(convertStudentEntityToDtoWithoutCourse(course.getStudent()));
        return courseDTO;
    }

    public static StudentDTO convertStudentEntityToDtoWithoutCourse(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setGender(student.getGender());
        studentDTO.setCity(student.getCity());
        studentDTO.setState(student.getState());
        studentDTO.setMobileNumber(student.getMobileNumber());
        studentDTO.setEmailId(student.getEmailId());
        return studentDTO;
    }

    public static Student convertStudentDtoToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setGender(studentDTO.getGender());
        student.setCity(studentDTO.getCity());
        student.setState(studentDTO.getState());
        student.setMobileNumber(studentDTO.getMobileNumber());
        student.setEmailId(studentDTO.getEmailId());
        Course course = convertCourseDtoToEntity(studentDTO.getCourseDTO());
        student.setCourse(course);
        return student;
    }


    public static Course convertCourseDtoToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setEnrollmentDate(courseDTO.getEnrollmentDate());
        course.setCourseType(courseDTO.getCourseType());
        course.setGrade(courseDTO.getGrade());
        return course;
    }
}