import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbcUtil;

public class insertPSTSMT {

	public static void main(String[] args) {
   Connection connection =null;
   PreparedStatement pstmt=null;
   Scanner scn = null;
   try {
   connection = jdbcUtil.getJdbcConnection();
   String sqlInsertq = "insert into employee(name, salary, gender) value (?,?,?)";
   if (connection!=null)
	   pstmt = connection.prepareStatement(sqlInsertq);
   System.out.println("Statement has been prepared successfully....");
   if (pstmt != null);
    scn= new Scanner(System.in);
    System.out.println("please enter the name of employee");
   String name = scn.next();
	System.out.println("Enter the salary of employee");
	int salary = scn.nextInt();
	System.out.println("Enter employee gender");
	String gender = scn.next();  
	pstmt.setString(1,name);
	pstmt.setInt(2,salary);
	pstmt.setString(3,gender);
	System.out.println("new insertion is "+ sqlInsertq);
	int rowAffected = pstmt.executeUpdate();
	System.out.println("No. of row affected :: "+ rowAffected);
   }
   catch (IOException ie) {
	   ie.printStackTrace();
   }
   catch (SQLException se) {
	   se.printStackTrace();
   }
   catch (Exception e) {
	   e.printStackTrace();
   }finally {
	   try {
		   jdbcUtil.cleanUp(connection, pstmt, null);
		   scn.close();
		   System.out.println("Closing the resources...");
   }catch(Exception e){
	   e.printStackTrace();
   }
	}
}}
