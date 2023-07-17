package com.edu.JDBC1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class DeleteRecords {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		//load driver
		Scanner sc= new Scanner(System.in);
		
		
		
	
		String sname;
	      System.out.println("Enter Student name");
	    sname=sc.next();
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
			String del="select * from student where sname= '"+sname+"'";
			
			ResultSet rs=st.executeQuery(del);
			//System.out.println("Sid\tSname\tSage\tGender\tsphone");
			if(rs.next()) {
				String ins="delete from student where sname='"+sname+"'";
				int r=st.executeUpdate(ins);
				if(r>0) {
					System.out.println("deleted Suceesfully");

				}
				}else {
					System.out.println("Data is not exist");
					
				
			}
		
		}else {
			System.out.println("Not connected");
		}
		

	}
	

	 
}

