package org.hibernate.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.enums.Gender;


@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "Mobile_Number", nullable = false,unique = true,length = 10)
    private String mobileNumber;

    @Column(name = "Email_ID", nullable = false)
    private String emailId;


    @OneToOne(cascade = CascadeType.ALL,optional = false, orphanRemoval = true)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = true, unique = false)
    private Course course;
}