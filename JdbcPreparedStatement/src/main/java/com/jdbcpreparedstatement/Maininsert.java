package com.jdbcpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Maininsert {
	private static String driver;
	public static String url;
    public static String un;	
	public static String password;
	public static PreparedStatement pst=null;
	private static int id;
	private static String name;
	private static int age;
	private static String email;
	private static float salary;
	private static long phone;
   private static Scanner sc=new Scanner(System.in);

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
  public static void insert() throws ClassNotFoundException, SQLException {
	  Connection con=Maininsert.getConnection();
		String sql="insert into employee values (?,?,?,?,?,?)";
	 PreparedStatement pst=con.prepareStatement(sql);
	 //System.out.println("Enter id");
	 //id=sc.nextInt();
	 String sql1="select max(eid) as id from employee ";
	 PreparedStatement pst1=con.prepareStatement(sql1);
	 ResultSet rs1= pst1.executeQuery();
	 Maininsert.inputData();
	 if(rs1.next()) {
		 id=rs1.getInt(1)+1;
		 pst.setInt(1,id);
		 pst.setString(2,name);
		 pst.setInt(3,age);
		 pst.setString(4,email);
		 pst.setFloat(5,salary);
		 pst.setLong(6,phone);
		 int i=pst.executeUpdate();
		 if(i>0) {
			 System.out.println("Record is updated");
		 }else {
			 System.out.println("Record is not updated");
		 }
        System.exit(0);
	 }
  }
  public static void inputData() throws ClassNotFoundException, SQLException {
	  
	  System.out.println("Enter name");
		 name=sc.next();
		 System.out.println("Enter age");
		 age=sc.nextInt();

		 System.out.println("Enter email ");
		 email=sc.next();
		 System.out.println("Enter salary ");
		 salary=sc.nextFloat();
		 System.out.println("Enter phone");
		 phone=sc.nextLong();
		

  }
  

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Maininsert.insert();
		
		
	}

}
