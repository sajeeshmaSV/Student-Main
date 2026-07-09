package org.hibernate.dto;

import lombok.Data;
import org.hibernate.enums.CourseType;
import org.hibernate.enums.Grade;

import java.time.LocalDate;

@Data
public class CourseDTO {
        private int course_id;
        private String courseName;
        private LocalDate enrollmentDate;
        private CourseType courseType;
        private Grade grade;
        private StudentDTO studentDTO;

    @Override
    public String toString() {
        return "CourseDTO{" +
                "course_id=" + course_id +
                ", courseName='" + courseName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", course=" + courseType +
                ", grade=" + grade +
                ", studentDTO=" + studentDTO +
                '}';
    }
}

