package com.jdbcConnectionAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
		 static private String url="jdbc:mysql://localhost:3306/newDb";
		 static private String UserName="root";
		 static private String Password="";
		 
		 public static  Connection getConn() throws SQLException
		   {
			 Connection conn=DriverManager.getConnection(url,UserName,Password);
			 return conn;
		   }	
		 }
	


