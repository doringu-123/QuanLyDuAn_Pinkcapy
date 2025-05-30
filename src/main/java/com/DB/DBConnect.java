package com.DB;

import java.sql.*;

public class DBConnect {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://turntable.proxy.rlwy.net:33735/railway?useSSL=false&serverTimezone=UTC";
                String username = "root";
                String password = "fbXkWtHycVilvoqshuwnbcqgJMXzZvEw";

                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
