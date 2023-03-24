package com.jdbcConnectionAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static private String url = "jdbc:mysql://localhost:3306/test";
	static private String userName = "root";
	static private String password = "";

	public static Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

    /*public static void main(String[] args) {
        try {
            Connection con = getConn();
            System.out.println(con);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}



