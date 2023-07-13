package com.jdbcproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static String driver;
	public static String url;
    public static String un;	
	public static String password;
	
	private static Connection con=null;
  public static Connection getConnection() throws ClassNotFoundException {
	  driver="com.mysql.cj.jdbc.Driver";
	  url="jdbc:mysql://localhost:3306/lavanyadb";
	  un="root";
	  password="@Lavanya#2220";
	  
		Class.forName(driver);
		try {
			con=DriverManager.getConnection(url,un,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  return con;
	  
  }
}
