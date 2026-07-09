package org.hibernate.service.Impl;

import org.hibernate.dto.CourseDTO;
import org.hibernate.entity.Course;
import org.hibernate.exception.CourseNotFoundException;
import org.hibernate.repository.CourseRepository;
import org.hibernate.repository.impl.CourseRepositoryImpl;
import org.hibernate.service.CourseService;
import org.hibernate.util.MapperUtil;

import java.util.Objects;

public class CourseServiceImpl implements CourseService {

    private static CourseRepository courseRepository;
    public CourseServiceImpl(){
        this.courseRepository =new CourseRepositoryImpl();
    }

    @Override
    public CourseDTO findCourse(int courseId) throws CourseNotFoundException {
        Course course=courseRepository.findCourse(courseId);
        if(Objects.isNull(course)){
            throw new CourseNotFoundException("Course not found");
        }

        return MapperUtil.convertCourseEntityToDto(course);
    }
}