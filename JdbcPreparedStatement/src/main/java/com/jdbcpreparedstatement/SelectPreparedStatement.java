package com.jdbcpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPreparedStatement {
	public static int id;
	public static String name;
	public static int age;
	public static String email;
	public static float salary;
	public static long phone;
public static void main(String[] args) throws ClassNotFoundException {
	String driver="com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	Connection con=null;
	PreparedStatement pst=null;
	String sql;
	String url="jdbc:mysql://localhost:3306/lavanyadb";
	String un="root";
	String pass="@Lavanya#2220";
	
	try {
		con=DriverManager.getConnection(url,un,pass);
		sql="select * from employee";
		pst=con.prepareStatement(sql);
	    ResultSet rs=pst.executeQuery();
	    System.out.println("Eid\tename\teage\teemail\t\t\tesalary\tephone");
	    System.out.println("--------------------------------------------------------------------------");
	    
	    while(rs.next()) {
	    	id=rs.getInt(1);
	    	name=rs.getString(2);
	    	age=rs.getInt(3);
	    	email=rs.getString(4);
	    	salary=rs.getFloat(5);
	    	phone=rs.getLong(6);
	    	System.out.println(id+"\t"+name+"\t"+age+"\t"+email+"\t"+salary+"\t"+phone);
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
