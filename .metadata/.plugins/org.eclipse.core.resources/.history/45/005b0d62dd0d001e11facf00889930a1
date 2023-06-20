// insertion to Database by taking input from keboard
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Self2 {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql:///Company";
		String user= "root";
		String passWord ="root";
		Connection connection = DriverManager.getConnection(url,user,passWord);
		System.out.println("Connection stablished succesfully");
		Statement statement = connection.createStatement();
		System.out.println("Statement created succesfully");
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the name of employee");
		String name = scn.next();
		System.out.println("Enter the salary of employee");
		int salary = scn.nextInt();
		System.out.println("Enter employee gender");
		String gender = scn.next(); 
		String sqlSelect = String.format("insert into employee(name, salary, gender)values('%s',%d,'%s')",name,salary,gender);
	//	String sqlQuery = "insert into employee(name, salary, gender) values ('prabhat',330000,'M')";
		int rowAff =statement.executeUpdate(sqlSelect);
		System.out.println("Updated DB");
		System.out.println("No. of rows affected is :: "+
				rowAff);
		statement.close();
		connection.close();
		System.out.println("Resources closing.....");
	}
	
}
