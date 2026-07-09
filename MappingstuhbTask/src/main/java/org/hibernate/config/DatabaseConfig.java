package org.hibernate.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Course;
import org.hibernate.entity.Student;
import org.hibernate.service.ServiceRegistry;


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class DatabaseConfig {

        private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);
        }

        public static SessionFactory getSessionFactory() {
            return SESSION_FACTORY;
        }
}
