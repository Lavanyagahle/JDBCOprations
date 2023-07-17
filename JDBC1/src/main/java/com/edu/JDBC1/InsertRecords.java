package com.edu.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecords {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String driver="com.mysql.cj.jdbc.Driver";
	//load driver
	Scanner sc= new Scanner(System.in);
	
	
	
	int sid;
	String sname;
    int sage;
    String gender;
    Long sphone;
    System.out.println("Enter Student id");
    sid=sc.nextInt();
    System.out.println("Enter Student name");
    sname=sc.next();
    System.out.println("Enter student age");
    sage=sc.nextInt();
    System.out.println("Enter student gender");
    gender=sc.next();
    System.out.println("Enter student phone");
    sphone=sc.nextLong();
    System.out.println();
	Class.forName(driver);
	//Make connection
	String url="jdbc:mysql://localhost:3306/lavanyadb";
	String user="root";
	String password="@Lavanya#2220";
	Connection con=DriverManager.getConnection(url, user, password);

	if(con!=null) {
		System.out.println("Database connection successful");
		
        
		Statement st=con.createStatement();
		String sel="select * from student where sname= '"+sname+"'";
		
		ResultSet rs=st.executeQuery(sel);
		//System.out.println("Sid\tSname\tSage\tGender\tsphone");
		if(!rs.next()) {
			String ins="insert into student values("+sid+",'"+sname+"','"+sage+"','"+gender+"','"+sphone+"')";
			int r=st.executeUpdate(ins);
			if(r>0) {
				System.out.println("Registered Suceesfully");
			}else {
				System.out.println(sid+"Already exist");
			}
			
		}
	
	}else {
		System.out.println("Not connected");
	}
	

}
}
