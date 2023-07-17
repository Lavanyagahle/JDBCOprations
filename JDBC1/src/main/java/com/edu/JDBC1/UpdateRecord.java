package com.edu.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		//load driver
		Scanner sc= new Scanner(System.in);
		
	    
		String sname;
		//String sage;
		//String gender;
		//Long sphone;
		
		 System.out.println("Enter student name");
		 sname=sc.nextLine();
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
			if(rs.next()) {
				System.out.println("Choose option to perform operation:");
				System.out.println("1.Name, 2.Age, 3.Gender, 4.Phone");
				int option=sc.nextInt();
				String up;
				int r;
				switch(option) {
				case 1:
					
						System.out.println("Enter name");
				        String newname=sc.next();
				         up= "update student set sname='"+newname+"' where sname='"+sname+"'";
					     r=st.executeUpdate(up);
                    if(r>0) {
                    	System.out.println("Name updated successfully");
                    }
                    break;
					
				case 2:
				
					System.out.println("Enter age");
					int newage=sc.nextInt();
					 up="update student set sage='"+newage+"' where sname='"+sname+"'";
					 r=st.executeUpdate(up);
					if(r>0) {
						System.out.println("Age updated successfully");
					}
					break;
				
				case 3:
				
					System.out.println("Enter gender");
					String newgen=sc.next();
				      up="update student set gender='"+newgen+"' where sname='"+sname+"'";
				      r=st.executeUpdate(up);
					if(r>0) {
						System.out.println("Gender updated successfully");
						
					}
					break;
				
				case 4:
				
					System.out.println("Enter phone number");
					Long newphone=sc.nextLong();
				    up="update student set sphone='"+newphone+"' where sname='"+sname+"'";
				     r=st.executeUpdate(up);
					if(r>0) {
						System.out.println("Phone number updated successfully");
					}
					break;
				
				default:
				
					System.out.println("Invalid input...Please enter valid opetion");
				
				}
					
					
				
			}else {
				System.out.println("Data does not exist");
			}
		
		}else {
			System.out.println("Not connected");
		}
		

	}
	


}
