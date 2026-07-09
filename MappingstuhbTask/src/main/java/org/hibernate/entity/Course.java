package org.hibernate.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.enums.CourseType;
import org.hibernate.enums.Grade;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "course")
public class Course {

     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     private int id;

     @Column(nullable = false)
     private String courseName;

     @Column(nullable = false)
     private LocalDate enrollmentDate;

     @Enumerated(EnumType.STRING)
     @Column(name = "course_type")
     private CourseType courseType;


     @Enumerated(EnumType.STRING)
     private Grade grade;

     @OneToOne(mappedBy = "course")
     private Student student;

}
