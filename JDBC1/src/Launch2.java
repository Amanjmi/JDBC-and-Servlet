// Insertion into database using jdbc

import java.sql.*;
public class Launch2 {
 static Connection connection= null;
	public static void main(String[] args) throws SQLException {
		try {
//		step1. It can be ignored as from JDBC4.X version onwards,there is a facility of "autoloading".
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver loaded successfully...");
		//Step2. Establish the Connection with database
//			localhost:3306   from the below line it can be removed as database and sql jar both are in
//			the same pc.
		String url = "jdbc:mysql:///aman";
		//username and password would vary from user to user//
		String userName = "root";
		String passWord = "root";
		Connection connection = DriverManager.getConnection(url,userName,passWord);
		System.out.println("connection established succesfully...");
		System.out.println("The implement class name is "+
		connection.getClass().getName());
		// Step3. Create statement Object and send the Query
		Statement statement = connection.createStatement();
		System.out.println("STATEMENT object created...");
		// Step4. Execute the Query and Process the resultSet
		String sqlInsertQuery = "insert into jobsall (duration, Company, salary) values (9,'unilever',450000)";
		int rowAffected = statement.executeUpdate(sqlInsertQuery);
		System.out.println("RESULTSET object created...");
		System.out.println("No. of rows affected is :: "+
		rowAffected);
		
		// Step6. Close the resources
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");
	}
	catch(SQLException se){
		se.printStackTrace();
	}catch(Exception e){
	e.printStackTrace();
	}}}
