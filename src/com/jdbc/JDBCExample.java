package com.jdbc;

import java.sql.*;

public class JDBCExample {
    static  String URL = "jdbc:mysql://localhost:3306/school";
    static String USER = "root";
    static String PASSWORD = "ahmad@632";

    public void connectDatabase() {

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        )
        {
            System.out.println("Connected to database successfully : " + conn);

        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

    public void readData()
    {
        String query = "select * from students";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        )
        {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println(
                        id + " " + name + " " + age + " " + course
                );
            }
        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

    public void addData()
    {
        String query = "insert into students (id, name, age, course) values (?, ?, ?, ?)";

        try(
                Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query);
                )
        {
            ps.setInt(1,7);
            ps.setString(2,"Aboozar");
            ps.setInt(3,11);
            ps.setString(4,"C++");


            int rows = ps.executeUpdate();
            System.out.println("Inserted " + rows + " rows into students table");
        }
        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

    public void updateData()
    {
        String query = "update students set name = ?, age = ?, course = ? where id = ?";

        try(
                Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query);
                )
        {
                ps.setString(1,"Neha");
                ps.setInt(2,28);
                ps.setString(3,"Advance JAVA");
                ps.setInt(4,8);

                int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " rows into students table");
        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

    public void  deleteData()
    {
        String query = "delete from students where id = ?";

        try(
                Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query);
                )
        {
            ps.setInt(1,7);

            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " rows into students table");
        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

}


