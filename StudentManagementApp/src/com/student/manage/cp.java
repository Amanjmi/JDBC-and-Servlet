package com.student.manage;

import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

public class cp {
	static Connection con;
public static Connection createC() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/student_man";
				con = DriverManager.getConnection(url,user,password);
	}
	return con;
}

}
