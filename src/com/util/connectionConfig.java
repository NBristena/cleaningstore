package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionConfig {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://85.204.18.140:3306/cleaningstore","cleaningstoreusr", "asd123");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
