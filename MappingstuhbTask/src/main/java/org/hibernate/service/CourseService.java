package org.hibernate.service;

import org.hibernate.dto.CourseDTO;
import org.hibernate.exception.StudentNotFoundException;

public interface CourseService {
    CourseDTO findCourse(int courseId) throws StudentNotFoundException;
}
