import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.IOException;
import java.sql.*;
import util.jdbcUtil;

public class dateInsert1 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psmt = null;
		Scanner scn = null;
		java.sql.Date sqlDob =null;
		java.sql.Date sqlDom = null;
		try {
			connection = jdbcUtil.getJdbcConnection();
			String sqlInsert = "insert into user1(name, dob, dom) values(?,?,?)";
			if (connection!= null)
			psmt = connection.prepareStatement(sqlInsert);
			if (psmt!= null) {
				scn = new Scanner(System.in);
				if (scn!= null) {
				System.out.println("Enter the name ::");
				String name = scn.next();
				System.out.println("Enter Date of birth (MM-dd-yyyy) ::");
				String dob = scn.next();
				System.out.println("Enter dom(yyyy-MM-dd ::");
				String dom = scn.next();
				if (dob != null) {
					// Conversion of String to sqlDate
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
					java.util.Date uDate = sdf.parse(dob);

					long value = uDate.getTime();
					sqlDob = new java.sql.Date(value);
				}

				if (dom != null)
					sqlDom = java.sql.Date.valueOf(dom);
				psmt.setString(1,name);
				psmt.setDate(2, sqlDob);
				psmt.setDate(3,sqlDom);
				int rowCount = psmt.executeUpdate();
				System.out.println("No. of rows Affected :: "+ rowCount);
			}
		}
	} catch (SQLException | IOException sio) {
		sio.printStackTrace();
		}catch (ParseException e) {
		e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}		finally {
			try {
	jdbcUtil.cleanUp(connection, psmt, null);
	scn.close();
}catch (Exception e) {
	e.printStackTrace();
}}}}
