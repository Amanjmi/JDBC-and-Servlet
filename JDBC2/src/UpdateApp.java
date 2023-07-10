import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbcUtil;

public class UpdateApp {

	public static void main(String[] args) {
   Connection connection =null;
   PreparedStatement pstmt=null;
   Scanner scn = null;
   try {
   connection = jdbcUtil.getJdbcConnection();
   String sqlUpdate = "update employee set salary = ? where id =?";
   if (connection!=null)
	   pstmt = connection.prepareStatement(sqlUpdate);
   System.out.println("Statement has been prepared successfully....");
   if (pstmt != null);
   
    scn= new Scanner(System.in);
    
    System.out.println("please enter the id of employee to update salary");
	int  id  = scn.nextInt();
	 
	  System.out.println("please enter the correct salary detail");
		int salary  = scn.nextInt();
	pstmt.setInt(2,id);
	pstmt.setInt(1,salary);
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
