package student_management;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        Studentmanage sm=new Studentmanage();
        StudentDTO sd= new StudentDTO();
        sm.management();
        System.out.print("Enter the Number: ");
        int n= sc.nextInt();
        while(n!=0) {
            if (n == 1) {
                sm.insert();
            } else if (n == 2) {
                sm.delete();

            } else if (n == 3) {
                sm.find();
            } else if (n == 4) {
                sm.findall();
            }
            System.out.println();
            System.out.print("Enter the Number: ");
            n= sc.nextInt();
        }



    }
}
