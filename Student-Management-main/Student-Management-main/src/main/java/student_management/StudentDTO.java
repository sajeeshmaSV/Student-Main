package student_management;

import java.time.LocalDate;

public class StudentDTO {
    String name;
    int regno;
    String gender;
    String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDate(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public StudentDTO() {

    }
    public StudentDTO(String name, int regno, String gender, String dateOfBirth) {
        this.name = name;
        this.regno = regno;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ",gender="+gender+
                ", regno=" + regno +
                ", date=" + dateOfBirth +
                '}';
    }
}
