import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
public class Self1 {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql:///Company";
		String user= "root";
		String passWord ="root";
		Connection connection = DriverManager.getConnection(url,user,passWord);
		System.out.println("Connection stablished succesfully");
		Statement statement = connection.createStatement();
		System.out.println("Statement created succesfully");
		String selectQuery = "select id, name,salary,gender from employee";
		ResultSet resultSet = statement.executeQuery(selectQuery);
		System.out.println("Query exicuted");
		System.out.println("ID\t Name\t salary\t Gender");
		while (resultSet.next()) {
		int id=resultSet.getInt(1);
		String name= resultSet.getString(2);
		int salary=resultSet.getInt(3);
		String gender= resultSet.getString(4);
		System.out.println(id +"\t" + name+ "\t"+ salary+"\t   "+gender);
		}
		resultSet.close();
		statement.close();
		connection.close();
		System.out.println("Resources closing.....");
	}
	
}
