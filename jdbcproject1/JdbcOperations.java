package com.jdbcproject1;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcOperations {
    private static Connection con=null; 
    private static Statement st;
    private static String sql;
    private static ResultSet rs;
    private static int id;
    private static String name;
    private static int age;
    private static String email;
    private static float salary;
    private static long phone;
    private static int i;
    private static Scanner sc=new Scanner(System.in);
	public static void displayEmployees() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		con=DataBaseConnection.getConnection();
		st=con.createStatement();
		sql="select * from employee";
		rs=st.executeQuery(sql);
	
		System.out.println("Id\tName\tage\t\temail\t\tsalary\t\tphone");
		while(rs.next()) {
			id=rs.getInt(1);
			name=rs.getString(2);
			age=rs.getInt(3);
			email=rs.getString(4);
			salary=rs.getFloat(5);
			phone=rs.getLong(6);
			System.out.println(id+"\t"+name+"\t"+age+"\t\t"+email+"\t\t"+salary+"\t\t"+phone);
			
		}
	}
	public static void addEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DataBaseConnection.getConnection();
		st=con.createStatement();
		sql="select max(eid) as id from employee";
		rs=st.executeQuery(sql);
		if(rs.next()) {
			id=rs.getInt("id")+1;
			//System.out.println("mac id = "+id);
		}
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter age");
		age=sc.nextInt();
		System.out.println("Enter email");
		email=sc.next();
		System.out.println("Enter salary");
		salary=sc.nextFloat();
		System.out.println("Enter phone");
		phone=sc.nextLong();
		sql="insert into employee values("+id+",'"+name+"',"+age+",'"+email+"',"+salary+","+phone+")";
		i= st.executeUpdate(sql);
		if(i>0){
			System.err.println("Employee registered successfully");
		}else {
			System.out.println("Empolyee not registered");
		}

	}
	public static void deleteEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DataBaseConnection.getConnection();
		st=con.createStatement();
		System.out.println("Enter employee id");
		id=sc.nextInt();
		
		
		sql="select eid from employee where eid= "+id+"";
		
		 rs=st.executeQuery(sql);
		//System.out.println("Sid\tSname\tSage\tGender\tsphone");
		if(rs.next()) {
		     sql="delete from employee where eid="+id+"";
			i=st.executeUpdate(sql);
			if(i>0) {
				System.out.println("deleted Suceesfully");

			}
			}else {
				System.out.println("Data is not exist");
				
			
		}

		
	}
	public static void updateEmployee() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
			int upchoice;
			con = DataBaseConnection.getConnection();
			st = con.createStatement();
				
			System.out.println("Enter your choice to update");
			System.out.println("1.To change name");
			System.out.println("2.Change age");
			System.out.println("3.Change email");
			System.out.println("4.update salary");
			System.out.println("5.update phone");
			
			System.out.println("Enter your choice");
			upchoice = sc.nextInt();
			
			System.out.println("Enter employee id to update");
			id = sc.nextInt();
			
			sql = "select eid from employee where eid="+id;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
					
			switch(upchoice) {
			case 1: 
				   System.out.println("Enter name to change");
				   name = sc.next();
				   
				   sql = "update employee set ename='"+name+"' where eid="+id;
				   i = st.executeUpdate(sql);
				   
				   if(i>0) {
					   System.out.println(name+" is changed successfully");
				   }
				   else {
					   System.out.println("name is not changed");
				   }
				   break;
			case 2:
				System.out.println("Enter age to change age");
				age=sc.nextInt();
				sql="update employee set eage="+age+" where eid="+id;
				i=st.executeUpdate(sql);
				if(i>0) {
					System.out.println(age+"is changed successfully");
				}else {
					System.out.println("age is not changed");
				}
				break;
			case 3:
				System.out.println("Enter email to change");
				email=sc.next();
				sql="update employee set eemail='"+email+"' where eid="+id;
				i=st.executeUpdate(sql);
				if(i>0) {
					System.out.println(email+"is changed successfully");
				}else {
					System.out.println("email is not changed");
				}
				break;
			case 4:
				System.out.println("Enter salary to change");
				salary=sc.nextFloat();
				sql="update employee set esalary="+salary+" where eid="+id;
				i=st.executeUpdate(sql);
				if(i>0) {
					System.out.println(salary+"is changed succsessfully");
				}else {
					System.out.println("salary is not changed");
				}
				break;
			case 5:
				System.out.println("Enter phone number to change");
				phone=sc.nextLong();
				sql="update employee set ephone= "+phone+" where eid="+id;
			    i=st.executeUpdate(sql);
			    if(i>0) {
			    	System.out.println(phone+"is changed successfully");
			    }else {
			    	System.out.println("phone is not changed");
			    }
			    
				
				
			}//switch
			}//if
			else {
				System.out.println("employee "+id +" not exists");
			}
		}
		}
