// Insertion into database using jdbc skipping first step as db and jre are in the same machine

import java.sql.*;
public class Self {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql:///Company";
		String user= "root";
		String passWord ="root";
		Connection connection = DriverManager.getConnection(url,user,passWord);
		System.out.println("Connection stablished succesfully");
		Statement statement = connection.createStatement();
		System.out.println("Statement created succesfully");
		String sqlQuery = "insert into employee(name, salary, gender) values ('Rakesh',220000,'M')";
		int rowAff =statement.executeUpdate(sqlQuery);
		System.out.println("Updated DB");
		System.out.println("No. of rows affected is :: "+
				rowAff);
		statement.close();
		connection.close();
		System.out.println("Resources closing.....");
	}
	
}
