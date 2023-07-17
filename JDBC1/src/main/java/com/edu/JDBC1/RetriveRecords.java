package com.edu.JDBC1;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveRecords {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String driver="com.mysql.cj.jdbc.Driver";
		//load driver
		
		int sid;
		String sname;
	    int sage;
	    String gender;
	    Long sphone;
		Class.forName(driver);
		//Make connection
		String url="jdbc:mysql://localhost:3306/lavanyadb";
		String user="root";
		String password="@Lavanya#2220";
		Connection con=DriverManager.getConnection(url, user, password);
	
		if(con!=null) {
			System.out.println("Database connection successful");
			
			//retrive data
			String sel="select * from student";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sel);
			System.out.println("Sid\tSname\tSage\tGender\tsphone");
			while(rs.next()) {
				//sid=rs.getInt(1);
				sid=rs.getInt("sid");
				//sname=rs.getString(2);
				sname=rs.getString("sname");
				//sage=rs.getInt(3);
				sage=rs.getInt("sage");
				
				gender=rs.getString("gender");
				 //gender=rs.getString(4);
				//sphone=rs.getLong(5);
				sphone=rs.getLong("sphone");
				System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+gender+"\t"+sphone);
				
			}
		
		}else {
			System.out.println("Not connected");
		}
		
		
}
}
