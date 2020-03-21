package com.company;


import java.sql.*;

public class Main {


    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {

            String url = "jdbc:mysql://0.0.0.0:3306/user1?useUnicode=true&serverTimezone=UTC";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection (url,"user1","user1");
            System.out.println ("Database connection established");
            // Statements allow to issue SQL queries to the database
            statement = conn.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from Gorod");
            writeResultSet(resultSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            String column1 = resultSet.getString(2);
            //Date date = resultSet.getDate("datum");
            System.out.println("Name: " + column1);

        }
    }
}
