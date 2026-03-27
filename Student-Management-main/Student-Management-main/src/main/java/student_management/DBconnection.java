package student_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DBconnection {
    static Connection dbconnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Student";
        String unmae = "root";
        String password = "eswar2310";
        return DriverManager.getConnection(url,unmae,password);

  }
}
