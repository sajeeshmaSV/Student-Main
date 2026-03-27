package student_management;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Studentmanage extends StudentDTO{
    Scanner sc= new Scanner(System.in);
    void management(){
        System.out.println("To Insert the Detail 'Enter 1'");
        System.out.println("To Delete the Detail 'Enter 2'");
        System.out.println("To Find the Detail 'Enter 3'");
        System.out.println("To Find All the Detail 'Enter 4'");
        System.out.println("To Exit 'Enter 0'");
    }
    void insert() throws SQLException {
        Connection con=DBconnection.dbconnection();
        String sql="insert into StudentDTO(name,regno,gender,dateOfBirth )values(?,?,?,?)";
        System.out.print("Enter the name: ");
        setName(sc.next());
        System.out.print("Enter the Register Number: ");
        setRegno(sc.nextInt());
        System.out.print("Enter the Gender in (M/F): ");
        setGender(sc.next().toUpperCase());
        System.out.print("Enter the Date Of Birth in (yyyy-mm-dd): ");
        setDate(sc.next());
        PreparedStatement st= con.prepareStatement(sql);
        st.setString(1,getName());
        st.setInt(2,getRegno());
        st.setString(3,getGender());
        st.setString(4,getDateOfBirth());
        st.execute();
        con.close();
        System.out.println("Inserted");
    }
    void delete() throws SQLException {
        Connection con=DBconnection.dbconnection();
        String sql="delete from StudentDTO where regno=?";
        PreparedStatement st=con.prepareStatement(sql);
        System.out.print("Enter Register Number to delete: ");
        setRegno(sc.nextInt());
        st.setInt(1,getRegno());
        st.execute();
        con.close();
        System.out.println("Deleted");


    }
    void find() throws SQLException {
        Connection con=DBconnection.dbconnection();
        String sql="Select * from StudentDTO where regno=?";
        PreparedStatement st= con.prepareStatement(sql);
        System.out.print("Enter Register Number to delete: ");
        setRegno(sc.nextInt());
        st.setInt(1,getRegno());
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            StudentDTO s = new StudentDTO(
                    rs.getString("name"),
                    rs.getInt("regno"),
                    rs.getString("gender"),
                    rs.getString("dateOfBirth")
            );
            System.out.println(s);
        } else {
            System.out.println("No record found");
        }
        con.close();


    }
    void findall() throws SQLException {
        Connection con = DBconnection.dbconnection();
        String sql = "SELECT * FROM StudentDTO";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        int flag = 0;
        while (rs.next()) {

            StudentDTO s = new StudentDTO(
                    rs.getString("name"),
                    rs.getInt("regno"),
                    rs.getString("gender"),
                    rs.getString("dateOfBirth")
            );
            System.out.println(s);
        }
        if (flag==0) {
            System.out.println("No records found");
        }
        con.close();
    }
}
