package org.hibernate.repository;

import org.hibernate.entity.Course;

public interface CourseRepository {


    Course findCourse(int courseId);

}
