package org.hibernate.dto;

import lombok.Data;
import org.hibernate.enums.Gender;
@Data
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private CourseDTO courseDTO;

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", courseDTO=" + courseDTO +
                '}';
    }

}
