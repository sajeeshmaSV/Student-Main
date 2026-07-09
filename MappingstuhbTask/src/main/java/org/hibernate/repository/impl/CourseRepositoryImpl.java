package org.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.config.DatabaseConfig;
import org.hibernate.entity.Course;
import org.hibernate.repository.CourseRepository;

public class CourseRepositoryImpl implements CourseRepository {

    private static final SessionFactory SESSION_FACTORY =
            DatabaseConfig.getSessionFactory();


    @Override
    public Course findCourse(int courseId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Course course = session.find(Course.class, courseId);
            return course;
        }
    }
}