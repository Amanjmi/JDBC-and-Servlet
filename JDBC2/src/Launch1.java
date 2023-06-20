// If you want to see your database using select operation in jdbc

import java.sql.*;
public class Launch1 {
 static Connection connection= null;
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded successfully...");
		//Step2. Establish the Connection with database
		String url = "jdbc:mysql://localhost:3306/aman";
		//username and password would vary from user to user//
		String userName = "root";
		String passWord = "root";
		connection = DriverManager.getConnection(url,userName,passWord);
		System.out.println("connection established succesfully...");
		System.out.println("The implement class name is "+
		connection.getClass().getName());
		// Step3. Create statement Object and send the Query
		Statement statement = connection.createStatement();
		System.out.println("STATEMENT object created...");
		// Step4. Execute the Query and Process the resultSet
		String sqlSelectQuery = "select duration,Company,salary from jobsall";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("RESULTSET object created...");
		System.out.println("duration\tcompany\tsalary");
		while (resultSet.next()) {
		int duration = resultSet.getInt(1);
		String Company = resultSet.getString("Company");

		int salary = resultSet.getInt("salary");
		System.out.println(duration + "\t" + "\t" + Company + "\t" + salary);
		}
		// Step6. Close the resources
		resultSet.close();
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");
	}
	catch (ClassNotFoundException ce) {
		ce.printStackTrace();
	}catch(SQLException se){
		se.printStackTrace();
	}catch(Exception e){
	e.printStackTrace();
	}}}
