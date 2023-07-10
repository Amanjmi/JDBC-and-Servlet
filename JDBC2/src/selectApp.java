import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.jdbcUtil;

public class selectApp {

	public static void main(String[] args) {
   Connection connection =null;
   PreparedStatement pstmt= null;
   ResultSet resultSet = null;
   Scanner scn = null;
   int id = 0;
   try {
   connection = jdbcUtil.getJdbcConnection();
   String sqlSelect = "select id,name,salary,gender from employee where id = ?";
   if (connection !=null)
	   pstmt = connection.prepareStatement(sqlSelect);
   System.out.println("Statement has been prepared successfully....");
   if (pstmt != null) {
    scn= new Scanner(System.in);
    System.out.print("Enter the id");
    id = scn.nextInt();
	pstmt.setInt(1,id);
	resultSet = pstmt.executeQuery();
   }
	if (resultSet != null){
		if(resultSet.next()) {
			System.out.println("id\tname\tsalary\tgender");
			System.out.println(resultSet.getInt(1)+"\t"+ resultSet.getString(2)+"\t"+ resultSet.getInt(3)+"\t"+ resultSet.getString(4));
		}else
			System.out.println("Record is not available...");
   }
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
		   jdbcUtil.cleanUp(connection, pstmt, resultSet);
		   scn.close();
		   System.out.println("Closing the resources...");
   }catch(SQLException se){
	   se.printStackTrace();
   }
	}
}}
