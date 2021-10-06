package dev.andrylat.amikhaylov.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {

    public static void main(String[] args) {

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/module-summary.html

        // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/events_app", "", "")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}