package org.hibernate.util;

import lombok.Data;
import org.hibernate.dto.CourseDTO;
import org.hibernate.dto.StudentDTO;
import org.hibernate.enums.CourseType;
import org.hibernate.enums.Gender;
import org.hibernate.enums.Grade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
@Data
public class InputUtil {
    private InputUtil() {

    }

    public static int acceptMenuOption(Scanner scanner) {
        System.out.println("Press 1 to add new Student.");
        System.out.println("Press 2 to fetch Student details.");
        System.out.println("Press 3 to update Student details of owner.");
        System.out.println("Press 4 to delete Student details.");
        System.out.println("Press 5 to fetch Course details.");
        int menuOption = scanner.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5) {
            return menuOption;
        } else {
            return acceptMenuOption(scanner);
        }
    }

    public static boolean wantToContinue(Scanner scanner) {
        System.out.println("Press Y to continue and N to exit.");
        char choice = scanner.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static StudentDTO acceptStudentDetailsToSave(Scanner scanner) {
        System.out.println("Enter first name of student:");
        String firstName = scanner.next();
        System.out.println("Enter last name of student:");
        String lastName = scanner.next();
        System.out.println("Enter gender of student:" + Arrays.asList(Gender.values()).toString());
        String gender = scanner.next().toUpperCase();
        System.out.println("Enter city of student:");
        String city = scanner.next();
        System.out.println("Enter state of student:");
        String state = scanner.next();
        System.out.println("Enter mobile number of student:");
        String mobileNumber = scanner.next();
        System.out.println("Enter email id of student:");
        String emailId = scanner.next();
        try {
            StudentDTO ownerDTO = new StudentDTO();
            ownerDTO.setFirstName(firstName);
            ownerDTO.setLastName(lastName);
            ownerDTO.setGender(Gender.valueOf(gender));
            ownerDTO.setCity(city);
            ownerDTO.setState(state);
            ownerDTO.setMobileNumber(mobileNumber);
            ownerDTO.setEmailId(emailId);
            return ownerDTO;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return acceptStudentDetailsToSave(scanner);
        }
    }

    public static CourseDTO acceptCourseDetailsToSave(Scanner scanner) {
        System.out.println("Enter name of Course:");
        String courseName = scanner.next();
        System.out.println("Enter date of birth of Enrollment (dd-MM-yyyy):");
        String DateOfEnrollment = scanner.next();
        System.out.println("Enter Course Type:" + Arrays.asList(CourseType.values()).toString());
        String course = scanner.next().toUpperCase();
        System.out.println("Enter Grade:" + Arrays.asList(Grade.values()).toString());
        String grade = scanner.next().toUpperCase();


        try {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseName(courseName);
            courseDTO.setEnrollmentDate(convertStringToDate(DateOfEnrollment));
            courseDTO.setCourseType(CourseType.valueOf(course));
            courseDTO.setGrade(Grade.valueOf(grade));
            return courseDTO;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return acceptCourseDetailsToSave(scanner);
        }
    }

    public static String acceptCourseDetailsToUpdate(Scanner scanner) {
        System.out.println("Enter updated name of course:");
        return scanner.next();
    }

    public static int acceptStudentIdToOperate(Scanner scanner) {
        System.out.println("Enter id of student:");
        return scanner.nextInt();
    }

    public static int acceptCourseIdToOperate(Scanner scanner) {
        System.out.println("Enter id of course:");
        return scanner.nextInt();
    }

    public static LocalDate convertStringToDate(String stringDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(stringDate, format);
    }
}