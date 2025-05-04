/*
 * Brian Preston
 * CSD-420 - Module 9
 * Purpose: Test MySQL 5 connection with Java using JDBC.
 */

import java.sql.*;

public class MySQLTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/databasedb";
        String dbUser = "student1";
        String dbPassword = "pass";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("✅ SUCCESS: Connected to MySQL database!");

            // Simple test query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CURRENT_USER();");

            while (rs.next()) {
                System.out.println("Connected as: " + rs.getString(1));
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

