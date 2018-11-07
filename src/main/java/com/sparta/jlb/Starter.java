package com.sparta.jlb;

public class Starter
{
    public static void main( String[] args ) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.getEmployee("191");

    }
}
