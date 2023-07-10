import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbcUtil;

public class crudApp {

	public static void main(String[] args) {
		Connection connection=null;
		ResultSet resultSet= null;
		PreparedStatement psmt = null;
		Scanner scn = null;
		
		try {
			connection = jdbcUtil.getJdbcConnection();
			 scn = new Scanner(System.in);
			System.out.println("ENter any no.");
			System.out.println("Press 1 to Insert operation");
			System.out.println("Press 2 to Select operation");
			System.out.println("Press 3 to update operation");
			System.out.println("Press 4 to delete operation");
			System.out.println("Press 5 to exit");

			int no = scn.nextInt();
			if(no == 1) {
				String sqlInsert = "insert into employee(id,name,salary,gender) values(?,?,?,?)";
				if (connection != null)
				psmt  = connection.prepareStatement(sqlInsert); 
				System.out.println("Enter id of employee");
				int id =scn.nextInt();
				System.out.println("Enter name of employee");
				String name =scn.next();
				System.out.println("Enter salary of employee");
				int salary =scn.nextInt();
				System.out.println("Enter gender of employee");
				String gender =scn.next();
				psmt.setInt(1,id);
				psmt.setString(2,name);
				psmt.setInt(3,id);
				psmt.setString(4,gender);
				
				 int rowCount = psmt.executeUpdate();
				 System.out.println("No. of row affected ::"+ rowCount);
				 if (rowCount > 0)
					 System.out.println("Record inserted successful");
				 else
					 System.out.println("Record insertion failed");
					 
			}else if(no ==2) {
				String sqlSelect = "select id, name, salary, gender from employee where id = ?";
				if (connection != null) {
					psmt = connection.prepareStatement(sqlSelect);
					int id = scn.nextInt();
					psmt.setInt(1, id);
					resultSet = psmt.executeQuery();
					if (resultSet!=null) {
						System.out.println("id\tname\tsalary\tgender");
						if (resultSet.next()) {
							System.out.println(resultSet.getInt(id) +"\t"+resultSet.getString(2) +"\t"+resultSet.getInt(3) +"\t"+ resultSet.getInt(4));
						} else 
							System.out.println("No record found for the given id");
					}
				}} else if(no==3) {
					String sqlUpdate = "update employee set salary = ? where id = ?";
					if (connection != null) {
						psmt = connection.prepareStatement(sqlUpdate);
						System.out.println("Enter the employee salary");
						int salary = scn.nextInt();
						System.out.println("Enter the employee id to update salary");
						int id = scn.nextInt();
						psmt.setInt(1,salary);
						psmt.setInt(2, id);
						System.out.println("Old salary was :: "+"write here");
						int rowAffected = psmt.executeUpdate();
						System.out.println("Updated salary is :: "+ salary);
						System.out.println("No. of row affected :: "+ rowAffected);
					}
				} else if (no == 4) {
					String sqlDelete = "delete from employee where id = ?";
					if (connection != null) {
						psmt = connection.prepareStatement(sqlDelete);
						System.out.println("Enter the employee id to delete details");
						int id = scn.nextInt();
						psmt.setInt(1, id);
						int rowAffected = psmt.executeUpdate();
						System.out.println("No. of row affected :: "+ rowAffected);
						if (rowAffected > 0)
							 System.out.println("Record Deleted successful...");
						 else
							 System.out.println("No record found for the given id...");
					}
				}
				else
					System.out.println("Please choose a valid no.");
				}catch (IOException ie) {
					   ie.printStackTrace();
				   }
				   catch (SQLException se) {
					   se.printStackTrace();
				   }
				   catch (Exception e) {
					   e.printStackTrace();
				   }finally {
					   try {
						   jdbcUtil.cleanUp(connection, psmt, resultSet);
						   scn.close();
						   System.out.println("Closing the resources...");
				   }catch(Exception e){
					   e.printStackTrace();
				   }
					}
		}


		
	}


