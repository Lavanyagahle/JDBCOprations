package com.jdbcpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MainDeletePreparedStatement {
public static void main(String[] args) {
	String driver="com.mysql.cj.jdbc.Driver";
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/lavanyadb";
	PreparedStatement pst=null;
	String un="root";
	String password="@Lavanya#2220";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter id");
	int id=sc.nextInt();
	try {
		Class.forName(driver);
		con=DriverManager.getConnection(url,un,password);
		String s="select * from employee where eid=?";
		pst=con.prepareStatement(s);
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			
			int id1=rs.getInt(1);
			System.out.println("id "+id1);
				String sql="delete from employee where eid=?";
	 pst=con.prepareStatement(sql);
	 pst.setInt(1,id);
	 int i=pst.executeUpdate();
	 if(i>0) {
		 System.out.println("Record is deleted");
	 }}
		else {
			System.out.println("Does not exist");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
