package com.jdbcpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePreparedStatement2 {
	public static String driver;

	public static String url;
	public static String un;

	public static String pass;
	public static Connection con;
	public static PreparedStatement pst;
	public static ResultSet rs;
	public static int i;
	public static String s;
	public static Connection getConnection() throws ClassNotFoundException {
		 driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		 url="jdbc:mysql://localhost:3306/lavanyadb";
		 un="root";
		pass="@Lavanya#2220";
		try {
		 con=DriverManager.getConnection(url,un,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void update() throws ClassNotFoundException {
		Connection con=UpdatePreparedStatement2.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		
		try {
			con=DriverManager.getConnection(url,un,pass);
				
			String sql="select * from employee where eid=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);

			 rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println("Choose option to perform operation");
				System.out.println("1.Name, 2.Age, 3.Email, 4.Salary, 5.Phone ");
				int option=sc.nextInt();
				switch(option) {
				case 1:
					System.out.println("Enter name to change");
					String name=sc.next();
					s="update employee set ename=? where eid=?";
					pst= con.prepareStatement(s);
					pst.setString(1,name);
					pst.setInt(2,id);
					i=pst.executeUpdate();
					if(i>0) {
						System.out.println("Name is updated");
					}else {
						System.out.println("Name is not updated");
					}
					break;
				case 2:
					System.out.println("Enter age to update");
					int age=sc.nextInt();
					s="update employee set eage=? where eid=?";
					pst=con.prepareStatement(s);
					pst.setInt(1,age);
					pst.setInt(2,id);
					i= pst.executeUpdate();
					if(i>0) {
						System.out.println("Age is updated ");
					}else {
						System.out.println("Age is not updated");
					}
					break;
				case 3:
					System.out.println("Enter email to change");
					String email=sc.next();
					s="update employee set eemail=? where eid=?";
					pst=con.prepareStatement(s);
					pst.setString(1,email);
					pst.setInt(2,id);
					i=pst.executeUpdate();
					if(i>0) {
						System.out.println("Email is updated");
					}else {
						System.out.println("Email is not updated");
					}
					break;
				case 4:
					System.out.println("Enter salary to change");
					float salary=sc.nextFloat();
					s="update employee set esalary=? where eid=?";
					pst=con.prepareStatement(s);
					pst.setFloat(1,salary);
					pst.setInt(2,id);
					i=pst.executeUpdate();
					if(i>0) {
						System.out.println("Salary is updated");
					}else {
						System.out.println("Salary is not updated");
					}
					break;
				case 5:
					System.out.println("Enter phone to change");
					long phone=sc.nextLong();
					s="update employee set ephone=? where eid=?";
					pst=con.prepareStatement(s);
					pst.setLong(1,phone);
					pst.setInt(2,id);
					i=pst.executeUpdate();
					if(i>0) {
						System.out.println("Phone is updated");
					}else {
						System.out.println("Phone is not updated");
					}
					break;
				default:
					System.out.println("Invalid option you choosed!... please choose correct option....");
					
				}
			}else {
				System.out.println(id+" does not exist");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) throws ClassNotFoundException {
		UpdatePreparedStatement2.update();
	}
}
