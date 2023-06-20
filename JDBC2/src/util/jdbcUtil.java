package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {
	private jdbcUtil() {}
	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded successfully...");
	}catch (ClassNotFoundException ce) {
		ce.printStackTrace();
		}
	}
	public static Connection getJdbcConnection() throws SQLException, IOException{
			FileInputStream fis =new FileInputStream("D:\\Amanur Rehman\\JDBC\\JDBC2\\Application.properties");
			Properties properties = new Properties();
			properties.load(fis);
		//username and password would vary from user to user//
		Connection connection = DriverManager.getConnection
				(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		System.out.println("connection established succesfully...");
		return connection;
	}
	public static void cleanUp(Connection con, Statement statement, ResultSet
			resultSet) throws SQLException {
		if (con != null) {
			con.close();
			}
			if (statement != null) {
			statement.close();
			}
			if (resultSet != null) {
			resultSet.close();
			}
			}

	}