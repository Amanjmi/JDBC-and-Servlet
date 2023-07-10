import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import util.jdbcUtil;
 
public class pdfInsertion {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psmt = null;
		Scanner scn = null;
		try {
			connection = jdbcUtil.getJdbcConnection();
			String sqlInsert = "insert into history(name, pdf) values(?,?)";
			if (connection!= null)
			psmt = connection.prepareStatement(sqlInsert);
			if (psmt!= null) {
				scn = new Scanner(System.in);
				if (scn!= null) {
				System.out.println("Enter the name ::");
				String name = scn.next();
				System.out.println("Enter pdf address ::");
				String pdfLoc = scn.next();
				
				psmt.setString(1,name);
				psmt.setCharacterStream(2, new FileReader(new File(pdfLoc)));
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
