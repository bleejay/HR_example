package com.sparta.jlb;

import java.sql.*;

public class EmployeeDAO {

    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "hr";
    private final String PASSWORD = "hr";
    private final String QUERY = "select e.first_name, e.last_name From employees e where e.employee_id > ?";

    public void getEmployee(String id){

        try(Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                System.out.println("Name is: " + firstName + " " + lastName);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
