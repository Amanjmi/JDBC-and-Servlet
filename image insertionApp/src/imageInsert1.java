import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import util.jdbcUtil;
 
public class imageInsert1 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psmt = null;
		Scanner scn = null;
		try {
			connection = jdbcUtil.getJdbcConnection();
			String sqlInsert = "insert into persons(name, image) values(?,?)";
			if (connection!= null)
			psmt = connection.prepareStatement(sqlInsert);
			if (psmt!= null) {
				scn = new Scanner(System.in);
				if (scn!= null) {
				System.out.println("Enter the name ::");
				String name = scn.next();
				System.out.println("Enter Image address ::");
				String imageLoc = scn.next();
				
				psmt.setString(1,name);
				psmt.setBinaryStream(2, new FileInputStream(new File(imageLoc)));
				int rowCount = psmt.executeUpdate();
				System.out.println("No. of rows Affected :: "+ rowCount);
			}
		}
	} catch (SQLException | IOException sio) {
		sio.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}		finally {
			try {
	jdbcUtil.cleanUp(connection, psmt, null);
	scn.close();
}catch (Exception e) {
	e.printStackTrace();
}}}}
