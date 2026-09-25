package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {
    static  String URL = "jdbc:mysql://localhost:3306/school";
    static String USER = "root";
    static String PASSWORD = "ahmad@632";

    static Scanner sc = new Scanner(System.in);

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

    public void viewAllData()
    {
        String query = "select * from students";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        )
        {
            System.out.println("===================================================================");
            System.out.println("==========================[ ALL STUDENTS ]=========================");
            System.out.println("===================================================================");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println("[ ID: " + id+ " ] [ Name: " + name + " ] [ Age: " + age + " ] [ Course: " + course+" ]");
            }
            System.out.println("===================================================================");
            System.out.println("===================================================================");
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
            System.out.print("Enter Student ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Course : ");
            String course = sc.nextLine();


            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setString(4,course);


            int rows = ps.executeUpdate();
            if(rows > 0)
                {
                    System.out.println("Inserted " + rows + " rows into students table");
                }

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

            System.out.print("Enter Student ID to update : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Set Student Name : ");
            String name = sc.nextLine();

            System.out.print("Set Student Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Set Student Course : ");
            String course = sc.nextLine();

                ps.setString(1,name);
                ps.setInt(2,age);
                ps.setString(3,course);
                ps.setInt(4,id);

                int rows = ps.executeUpdate();

                if(rows > 0)
                    {
                        System.out.println("Updated " + rows + " rows into students table");
                    }
                else
                    {
                        System.out.println("Student with ID " + id + " does not exist");
                    }
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
            System.out.print("Enter Student ID to delete Student's Data : ");
            int id = sc.nextInt();

            ps.setInt(1,id);

            int rows = ps.executeUpdate();
            if(rows > 0)
                System.out.println("Deleted " + rows + " rows into students table");
            else
                System.out.println("Student with ID " + id + " does not exist");

        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

    public void searchData()
    {
        String query = "select * from students where id = ?";

        try(
                Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query);

                )
        {
            System.out.print("Enter Student ID to search : ");
            int id = sc.nextInt();

            ps.setInt(1,id);

           try(ResultSet rs = ps.executeQuery();) {
               if (rs.next()) {
                   System.out.println("============================================");
                   System.out.println("==============[STUDENT FOUND]===============");
                   System.out.println("============================================");

                   System.out.println("ID     : " + rs.getInt("id"));
                   System.out.println("Name   : " + rs.getString("name"));
                   System.out.println("Age    : " + rs.getInt("age"));
                   System.out.println("Course : " + rs.getString("course"));

                   System.out.println("============================================");
                   System.out.println("============================================");
               } else {
                   System.out.println("Student with ID " + id + " does not exist");
               }
           }
        }

        catch (SQLException e)
        {
            System.out.println("Error connecting to database : " + e);
        }
    }

}


