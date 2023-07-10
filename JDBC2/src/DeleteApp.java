import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbcUtil;

public class DeleteApp {

	public static void main(String[] args) {
   Connection connection =null;
   PreparedStatement pstmt=null;
   int id =0;
   Scanner scn = null;
   try {
   connection = jdbcUtil.getJdbcConnection();
   String sqlDelete = "delete from employee where id = ?";
   if (connection!=null)
	   pstmt = connection.prepareStatement(sqlDelete);
   System.out.println("Statement has been prepared successfully....");
   if (pstmt != null);
    scn= new Scanner(System.in);
    System.out.println("please enter the id of employee to delete");
	 id  = scn.nextInt();
	pstmt.setInt(1,id);
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
