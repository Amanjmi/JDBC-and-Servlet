// Insertion into database using jdbc

import java.io.IOException;
import java.sql.*;
import util.jdbcUtil;
public class Select {
// static Connection connection= null;
	public static void main(String[] args){
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection =jdbcUtil.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();
			if (statement!= null) {
				
				resultSet=statement.executeQuery("select id,name,salary,gender from employee");
				if (resultSet!= null) {
					System.out.println("id\tname\tsalary\tgender");
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1) +"\t" + resultSet.getString(2)+ "\t"+ resultSet.getInt(3)+"\t   "+ resultSet.getString(4));
					}} }}}
	catch(IOException ie) {
		ie.printStackTrace();
	}catch(SQLException se){
		
		se.printStackTrace();
	}catch(Exception e){
	e.printStackTrace();
	}finally{
	try {
		jdbcUtil.cleanUp(connection, statement, resultSet);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Closing the resources...");
	}
	}}
