package com.jdbcproject1;
import java.sql.SQLException;
import java.util.*;
public class MainApp {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	int ch;
	String choice;
	Scanner sc= new Scanner(System.in);
	while(true) {
	System.out.println("Select the option which you want to perform");
	System.out.println("1. Show all employee");
	System.out.println("2. Add employee");
	System.out.println("3. Delete employee");
	System.out.println("4. Update empolyee");
	System.out.println("Please enter your choice");
	ch=sc.nextInt();
	switch(ch) {
	case 1: JdbcOperations.displayEmployees();
	       break;
	case 2: JdbcOperations.addEmployee();
	      break;
	case 3: JdbcOperations.deleteEmployee();
	      break;
	case 4: JdbcOperations.updateEmployee();
	      break;
	default:System.out.println("Invalid Input");
		
	}

	
	System.out.println("Do you want to continue y or n");
	choice=sc.next();
	if(choice.equalsIgnoreCase("Y")) {
	continue;
	}else if(choice.equalsIgnoreCase("n")){
		break;
	}
	
}}
}
